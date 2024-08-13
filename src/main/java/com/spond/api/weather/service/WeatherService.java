package com.spond.api.weather.service;

import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.api.weather.model.Weather;
import com.spond.api.weather.module.WeatherModule;
import com.spond.data.model.WeatherForecast;
import com.spond.data.web.metno.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class WeatherService {
    private static final Logger LOG = Logger.getLogger("WeatherService");

    private final WeatherModule weatherModule;

    WeatherService(WeatherModule weatherModule) {
        this.weatherModule = weatherModule;
    }

    public Weather getWeatherForEventTime(GeographicalCoordinates location, Instant startTime, Instant endTime) {
        WeatherForecast forecast = weatherModule.getLatestWeatherForLocation(location);

        boolean isNoDataAvailable = forecast.getCreationInstant() == null;
        if (isNoDataAvailable) {
            return null;
        }

        Weather weather = null;
        try {
            List<ForecastTimeStep> timeSeries = forecast.getData().getProperties().getTimeseries();
            Optional<ForecastTimeStep> nearestForecastTimeStep = timeSeries.stream().filter(
                            forecastTimeStep -> Math.abs(forecastTimeStep.getTime().toEpochMilli() - startTime.toEpochMilli()) <= 1000 * 60 * 30)
                    .findFirst();
            if (nearestForecastTimeStep.isEmpty()) {
                return null;
            }
            ForecastTimeStepData forecastTimeStepData = nearestForecastTimeStep.get().getData();

            BigDecimal airTemperature =  null;
            BigDecimal windSpeed = null;
            ForecastTimeInstant forecastTimeInstant = forecastTimeStepData.getInstant().getDetails();
            if (forecastTimeInstant != null) {
                airTemperature = forecastTimeInstant.getAirTemperature();
                windSpeed = forecastTimeInstant.getWindSpeed();
            }
            WeatherSymbol weatherSymbol = getWeatherSymbol(startTime, endTime, forecastTimeStepData);

            weather = new Weather(airTemperature, windSpeed, weatherSymbol);

        } catch (NullPointerException | NoSuchElementException missingDataException) {
            LOG.log(Level.WARNING, "Failed to process weather data due to missing data in expected fields", missingDataException);
        }

        return weather;
    }

    private WeatherSymbol getWeatherSymbol(Instant startTime, Instant endTime, ForecastTimeStepData forecastTimeStepData) {
        boolean isOverOneHour = startTime.plus(Duration.ofHours(1)).isAfter(endTime);
        if (!isOverOneHour) {
            ForecastTimeStepDataNext1Hours forecastTimeStepDataNext1Hours = forecastTimeStepData.getNext1Hours();
            if (forecastTimeStepDataNext1Hours == null) {
                return null;
            }
            WeatherSymbol weatherSymbol = forecastTimeStepDataNext1Hours.getSummary().getSymbolCode();
            return weatherSymbol;
        }
        boolean isOverSixHours = startTime.plus(Duration.ofHours(6)).isAfter(endTime);
        if (!isOverSixHours) {
            ForecastTimeStepDataNext6Hours forecastTimeStepDataNext6Hours = forecastTimeStepData.getNext6Hours();
            if (forecastTimeStepDataNext6Hours == null) {
                return null;
            }
            WeatherSymbol weatherSymbol = forecastTimeStepDataNext6Hours.getSummary().getSymbolCode();
            return weatherSymbol;
        }
        ForecastTimeStepDataNext12Hours forecastTimeStepDataNext12Hours = forecastTimeStepData.getNext12Hours();
        if (forecastTimeStepDataNext12Hours == null) {
            return null;
        }
        WeatherSymbol weatherSymbol = forecastTimeStepDataNext12Hours.getSummary().getSymbolCode();
        return weatherSymbol;
    }
}
