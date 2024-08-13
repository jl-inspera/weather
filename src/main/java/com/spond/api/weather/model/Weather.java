package com.spond.api.weather.model;

import com.spond.data.web.metno.model.WeatherSymbol;

import java.math.BigDecimal;

public class Weather {
    BigDecimal airTemperatureInCelsius;
    BigDecimal windSpeedInMetersPerSecond;
    WeatherSymbol weatherSymbol;

    public Weather(BigDecimal airTemperatureInCelsius, BigDecimal windSpeedInMetersPerSecond, WeatherSymbol weatherSymbol) {
        this.airTemperatureInCelsius = airTemperatureInCelsius;
        this.windSpeedInMetersPerSecond = windSpeedInMetersPerSecond;
        this.weatherSymbol = weatherSymbol;
    }

    public BigDecimal getAirTemperatureInCelsius() {
        return airTemperatureInCelsius;
    }

    public void setAirTemperatureInCelsius(BigDecimal airTemperatureInCelsius) {
        this.airTemperatureInCelsius = airTemperatureInCelsius;
    }

    public BigDecimal getWindSpeedInMetersPerSecond() {
        return windSpeedInMetersPerSecond;
    }

    public void setWindSpeedInMetersPerSecond(BigDecimal windSpeedInMetersPerSecond) {
        this.windSpeedInMetersPerSecond = windSpeedInMetersPerSecond;
    }

    public WeatherSymbol getWeatherSymbol() {
        return weatherSymbol;
    }

    public void setWeatherSymbol(WeatherSymbol weatherSymbol) {
        this.weatherSymbol = weatherSymbol;
    }
}
