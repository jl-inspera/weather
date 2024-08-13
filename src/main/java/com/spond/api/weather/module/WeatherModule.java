package com.spond.api.weather.module;

import com.spond.api.weather.data.CachedMetNoWeatherRepository;
import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.data.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class WeatherModule {
    private static final Logger LOG = Logger.getLogger("WeatherModule");

    @Value("${weather.module.minimum.hourly.freshness}")
    private Long minimumHourlyFreshness;

    @Value("${weather.module.failure.back.off.minutes}")
    private Long failureBackOffMinutes;

    private final CachedMetNoWeatherRepository cachedWeatherRepository;

    WeatherModule(CachedMetNoWeatherRepository cachedWeatherRepository) {
        this.cachedWeatherRepository = cachedWeatherRepository;
    }

    /**
     * Gets the latest weather forecast for a specific location.
     * Items are cached
     * @param location
     * @return
     */
    public WeatherForecast getLatestWeatherForLocation(GeographicalCoordinates location) {
        WeatherForecast weatherForecast = cachedWeatherRepository.getWeatherForLocation(location);

        Instant now = Instant.now();

        // Mechanism for backing off in case of failure
        boolean isFailureMode = weatherForecast.getCreationInstant() == null;
        if (isFailureMode) {
            Instant lastAttempt = weatherForecast.getLastUpdateInstant();
            boolean isRetryOverdue = lastAttempt.plus(Duration.ofMinutes(failureBackOffMinutes)).isBefore(now);
            LOG.log(Level.WARNING, "Operating in failure mode for location " + location + " with last attempt at " + lastAttempt + " retry is overdue: " + isRetryOverdue);
            if (isRetryOverdue) {
                WeatherForecast freshWeatherForecast = cachedWeatherRepository.updateWeatherForLocation(location);
                return freshWeatherForecast;
            }
        }

        // Mechanism for keeping cached values fresh
        Instant createdAtInstant = weatherForecast.getCreationInstant();
        boolean isForecastInformationMoreThanXHoursOld = createdAtInstant.plus(Duration.ofHours(minimumHourlyFreshness)).isBefore(now);
        if (isForecastInformationMoreThanXHoursOld) {
            LOG.log(Level.FINE, "Forecast for location " + location + " lost freshness, updating");
            WeatherForecast freshWeatherForecast = cachedWeatherRepository.updateWeatherForLocation(location);

            // If refresh fails, fake freshness to avoid miss and do a freshness long back off
            Instant freshCreatedAtInstant = freshWeatherForecast.getCreationInstant();
            isFailureMode = freshCreatedAtInstant == null;
            if (isFailureMode) {
                LOG.log(Level.WARNING, "Operating in failure mode for location " + location + " with stale data");
                WeatherForecast overrideWeatherForecast = cachedWeatherRepository.overrideWeatherForLocation(location, weatherForecast);
                return overrideWeatherForecast;
            }

            // If met.no can't keep up with the required freshness, fake freshness to avoid every request being a miss
            boolean isForecastDataOverMinimumHourlyFreshness = freshCreatedAtInstant.plus(Duration.ofHours(minimumHourlyFreshness)).isBefore(now);
            if (isForecastDataOverMinimumHourlyFreshness) {
                LOG.log(Level.WARNING, "Getting stale forecast data for location " + location + " so it will be forced fresh");
                WeatherForecast overrideWeatherForecast = cachedWeatherRepository.overrideWeatherForLocation(location, freshWeatherForecast);
                return overrideWeatherForecast;
            }

            return freshWeatherForecast;
        }

        return weatherForecast;
    }

    public Long getMinimumHourlyFreshness() {
        return minimumHourlyFreshness;
    }

    public void setMinimumHourlyFreshness(Long minimumHourlyFreshness) {
        this.minimumHourlyFreshness = minimumHourlyFreshness;
    }

    public Long getFailureBackOffMinutes() {
        return failureBackOffMinutes;
    }

    public void setFailureBackOffMinutes(Long failureBackOffMinutes) {
        this.failureBackOffMinutes = failureBackOffMinutes;
    }
}
