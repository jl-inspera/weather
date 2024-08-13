package com.spond.data.model;

import com.spond.api.weather.model.GeographicalCoordinates;
import com.spond.data.web.metno.model.METJSONForecast;

import java.time.Instant;

public class WeatherForecast {
    GeographicalCoordinates location;
    Instant creationInstant;
    Instant lastUpdateInstant;
    METJSONForecast data;

    public WeatherForecast(GeographicalCoordinates location, Instant creationInstant, Instant lastUpdateInstant, METJSONForecast data) {
        this.location = location;
        this.creationInstant = creationInstant;
        this.lastUpdateInstant = lastUpdateInstant;
        this.data = data;
    }

    public GeographicalCoordinates getLocation() {
        return location;
    }

    public void setLocation(GeographicalCoordinates location) {
        this.location = location;
    }

    public Instant getLastUpdateInstant() {
        return lastUpdateInstant;
    }

    public void setLastUpdateInstant(Instant lastUpdateInstant) {
        this.lastUpdateInstant = lastUpdateInstant;
    }

    public Instant getCreationInstant() {
        return creationInstant;
    }

    public void setCreationInstant(Instant creationInstant) {
        this.creationInstant = creationInstant;
    }

    public METJSONForecast getData() {
        return data;
    }

    public void setData(METJSONForecast data) {
        this.data = data;
    }


}
