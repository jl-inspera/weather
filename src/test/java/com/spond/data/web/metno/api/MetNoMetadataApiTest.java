/*
 * Locationforecast
 * Weather forecast for a specified place
 *
 * The version of the OpenAPI document: 2.0
 * Contact: weatherapi-adm@met.no
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.spond.data.web.metno.api;

import org.junit.Test;
import org.junit.Ignore;

import org.springframework.web.client.RestClientException;

/**
 * API tests for MetadataApi
 */
@Ignore
public class MetNoMetadataApiTest {

    private final MetNoMetadataApi api = new MetNoMetadataApi();

    
    /**
     * 
     *
     * RSS feed of changes to this product
     *
     * @throws RestClientException
     *          if the Api call fails
     */
    @Test
    public void changelogGetTest() {
        api.changelogGet();

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Check health status for product
     *
     * @throws RestClientException
     *          if the Api call fails
     */
    @Test
    public void healthzGetTest() {
        api.healthzGet();

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Schema for XML data
     *
     * @throws RestClientException
     *          if the Api call fails
     */
    @Test
    public void schemaGetTest() {
        api.schemaGet();

        // TODO: test validations
    }
    
}
