package com.spond.api.weather.module;

import com.spond.api.weather.data.CachedMetNoWeatherRepository;
import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.data.model.WeatherForecast;
import com.spond.data.web.metno.model.METJSONForecast;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.time.Instant;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherModuleTest {

    @Test
    public void getFreshData() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast metjsonForecast = new METJSONForecast();
        WeatherForecast weatherForecast = new WeatherForecast(location, now, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(weatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(weatherForecast, latestWeatherForLocation);
    }

    @Test
    public void getFreshData_whenOldData() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        Instant whenDataIsOld = now.minus(Duration.ofHours(weatherModule.getMinimumHourlyFreshness()));
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast metjsonForecast = new METJSONForecast();
        WeatherForecast oldweatherForecast = new WeatherForecast(location, whenDataIsOld, now, metjsonForecast);
        WeatherForecast freshweatherForecast = new WeatherForecast(location, now, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(oldweatherForecast);
        when(cachedMetNoWeatherRepositoryMock.updateWeatherForLocation(location)).thenReturn(freshweatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(freshweatherForecast, latestWeatherForLocation);
    }

    @Test
    public void getFreshData_whenOldData_thatDoesNotUpdateToFresh() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        Instant whenDataIsOld = now.minus(Duration.ofHours(weatherModule.getMinimumHourlyFreshness()));
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast metjsonForecast = new METJSONForecast();
        WeatherForecast oldweatherForecast = new WeatherForecast(location, whenDataIsOld, now, metjsonForecast);
        WeatherForecast freshweatherForecast = new WeatherForecast(location, whenDataIsOld, now, metjsonForecast);
        WeatherForecast overrideweatherForecast = new WeatherForecast(location, now, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(oldweatherForecast);
        when(cachedMetNoWeatherRepositoryMock.updateWeatherForLocation(location)).thenReturn(freshweatherForecast);
        when(cachedMetNoWeatherRepositoryMock.overrideWeatherForLocation(location, freshweatherForecast)).thenReturn(overrideweatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(overrideweatherForecast, latestWeatherForLocation);
    }

    @Test
    public void getNoForecast_andNoUpdate_whenFailureIsCached_andBackOffStillInEffect() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast metjsonForecast = null;
        WeatherForecast weatherForecast = new WeatherForecast(location, now, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(weatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(weatherForecast, latestWeatherForLocation);
    }

    @Test
    public void getNoForecast_andUpdateToNoForecast_whenFailureIsCached_andBackOffIsNoLongerInEffect() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        Instant whenFailureCanRetry = now.minus(Duration.ofMinutes(weatherModule.getFailureBackOffMinutes()));
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast metjsonForecast = null;
        WeatherForecast emptyWeatherForecast = new WeatherForecast(location, null, whenFailureCanRetry, metjsonForecast);
        WeatherForecast emptyFreshWeatherForecast = new WeatherForecast(location, null, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(emptyWeatherForecast);
        when(cachedMetNoWeatherRepositoryMock.updateWeatherForLocation(location)).thenReturn(emptyFreshWeatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(emptyFreshWeatherForecast, latestWeatherForLocation);
    }

    @Test
    public void getNoForecast_andUpdateToFreshForecast_whenFailureIsCached_andBackOffIsNoLongerInEffect() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        Instant whenFailureCanRetry = now.minus(Duration.ofMinutes(weatherModule.getFailureBackOffMinutes()));
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast emptyMetjsonForecast = null;
        METJSONForecast metjsonForecast = new METJSONForecast();
        WeatherForecast emptyWeatherForecast = new WeatherForecast(location, null, whenFailureCanRetry, emptyMetjsonForecast);
        WeatherForecast freshWeatherForecast = new WeatherForecast(location, null, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(emptyWeatherForecast);
        when(cachedMetNoWeatherRepositoryMock.updateWeatherForLocation(location)).thenReturn(freshWeatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(freshWeatherForecast, latestWeatherForLocation);
    }

    @Test
    public void getOldData_whenOldData_thatFailsToUpdate() {
        CachedMetNoWeatherRepository cachedMetNoWeatherRepositoryMock = mock(CachedMetNoWeatherRepository.class);
        WeatherModule weatherModule = new WeatherModule(cachedMetNoWeatherRepositoryMock);
        weatherModule.setMinimumHourlyFreshness(2L);
        weatherModule.setFailureBackOffMinutes(10L);

        Instant now = Instant.now();
        Instant whenDataIsOld = now.minus(Duration.ofHours(weatherModule.getMinimumHourlyFreshness()));
        GeographicalCoordinates location = new GeographicalCoordinates(20.0f, 20.0f);
        METJSONForecast metjsonForecast = new METJSONForecast();
        WeatherForecast oldweatherForecast = new WeatherForecast(location, whenDataIsOld, now, metjsonForecast);
        WeatherForecast freshweatherForecast = new WeatherForecast(location, null, now, null);
        WeatherForecast overrideweatherForecast = new WeatherForecast(location, now, now, metjsonForecast);

        when(cachedMetNoWeatherRepositoryMock.getWeatherForLocation(location)).thenReturn(oldweatherForecast);
        when(cachedMetNoWeatherRepositoryMock.updateWeatherForLocation(location)).thenReturn(freshweatherForecast);
        when(cachedMetNoWeatherRepositoryMock.overrideWeatherForLocation(location, oldweatherForecast)).thenReturn(overrideweatherForecast);

        WeatherForecast latestWeatherForLocation = weatherModule.getLatestWeatherForLocation(location);

        Assertions.assertEquals(overrideweatherForecast, latestWeatherForLocation);
    }
}
