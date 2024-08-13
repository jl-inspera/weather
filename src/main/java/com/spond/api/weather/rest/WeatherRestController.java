package com.spond.api.weather.rest;

import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.api.weather.model.Weather;
import com.spond.api.weather.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

///TODO: I didn't add any https or authentication. https would be relevant for such service and easily done with Spring
///TODO: Security + some packaging step per environment to add certificates. authentication would be good to restrict
///TODO: access to the API...I'm paranoid enough to add that to everything but context matters and I don't have any so
///TODO: I'm just mentioning it as a possible and common thing.
@RestController
public class WeatherRestController {

    private final WeatherService weatherService;

    WeatherRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("event")
    Weather event(
            @RequestParam("latitude") Float latitude,
            @RequestParam("longitude") Float longitude,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") Instant startTime,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'") Instant endTime) {
        Instant now = Instant.now();

        Instant aWeekFromNow = now.plus(Duration.ofDays(7));
        boolean isStartMoreThanAWeekFromNow = startTime.isAfter(aWeekFromNow);
        if (isStartMoreThanAWeekFromNow) {
            return null;
        }

        boolean isEventStarted = now.isAfter(startTime);
        if (isEventStarted) {
            return null;
        }

        GeographicalCoordinates geographicalCoordinates = new GeographicalCoordinates(latitude, longitude);
        Weather weather = weatherService.getWeatherForEventTime(geographicalCoordinates, startTime, endTime);
        return weather;
    }
}
