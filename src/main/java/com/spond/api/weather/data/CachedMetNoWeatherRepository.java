package com.spond.api.weather.data;

import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.data.model.WeatherForecast;
import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.model.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

///TODO: I did not use any specific cache provider, just a local implementation, because this is a sample project and
///TODO: using/integrating with redis is trivial to do but just more time to do and then to run using docker
@Component
public class CachedMetNoWeatherRepository implements WeatherRepository {
    private static final Logger LOG = Logger.getLogger("CachedMetNoWeatherRepository");

    private final MetNoDataApi metNoDataApi;

    CachedMetNoWeatherRepository(MetNoDataApi metNoDataApi) {
        this.metNoDataApi = metNoDataApi;
    }

    /**
     * Gets a weather forecast from met.no or serves a cached value
     * Synced on the cache key to avoid concurrent cache misses
     * @param location
     * @return
     */
    @Override
    @Cacheable(cacheNames = "weather-for-location-metno", key = "#location", sync = true)
    public WeatherForecast getWeatherForLocation(GeographicalCoordinates location) {
        METJSONForecast metNoForecast = null;
        Instant now = Instant.now();
        Instant creationInstant = null;
        try {
            metNoForecast = metNoDataApi.compactGet(location.getLatitude(), location.getLongitude(), null);
            String updatedAt = metNoForecast.getProperties().getMeta().getUpdatedAt();
            creationInstant = Instant.parse(updatedAt);
        } catch (RestClientException restClientException) {
            LOG.log(Level.WARNING, "API communication failed while getting forecast from met.no, for location: " + location, restClientException);
        } catch (Exception exception) {
            LOG.log(Level.SEVERE, "Failed while getting forecast for location: " + location, exception);
            metNoForecast = null;
            creationInstant = null;
        }
        WeatherForecast weatherForecast = new WeatherForecast(location, creationInstant, now, metNoForecast);
        return weatherForecast;
    }

    /**
     * Force gets a weather forecast from met.no
     * The cache is evicted prior to getting the forecast, ensuring a cache miss
     * @param location
     * @return
     */
    @Override
    @CacheEvict(cacheNames = "weather-for-location-metno", key = "#location", beforeInvocation = true)
    public WeatherForecast updateWeatherForLocation(GeographicalCoordinates location) {
        return getWeatherForLocation(location);
    }

    /**
     * Force caches a weather forecast
     * The freshness of the data os override to be the freshest
     * @param location
     * @param weatherForecastOverride
     * @return
     */
    @Override
    @CachePut(cacheNames = "weather-for-location-metno", key = "#location")
    public WeatherForecast overrideWeatherForLocation(GeographicalCoordinates location, WeatherForecast weatherForecastOverride) {
        Instant now = Instant.now();
        WeatherForecast weatherForecast = new WeatherForecast(location, now, now, weatherForecastOverride.getData());
        return weatherForecast;
    }

    ///TODO: could be interesting to add a mechanism that warms up the cache prior to peek hours
    ///TODO: with knowledge of existing clubs, a pre-fetch prior to peek hours would not improve performance by much
    ///TODO: but would decrease load on met.no. Not sure if that is a consideration so just mentioning it.
}
