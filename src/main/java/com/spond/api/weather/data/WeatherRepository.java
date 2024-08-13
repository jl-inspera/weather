package com.spond.api.weather.data;

import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.data.model.WeatherForecast;

public interface WeatherRepository {

    WeatherForecast getWeatherForLocation(GeographicalCoordinates location);

    WeatherForecast updateWeatherForLocation(GeographicalCoordinates location);

    WeatherForecast overrideWeatherForLocation(GeographicalCoordinates location, WeatherForecast weatherForecastOverride);
}
