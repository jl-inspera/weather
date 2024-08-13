package com.spond.data.web.metno.api;

import com.spond.data.web.metno.invoker.MetNoApiClient;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.annotation.processing.Generated;

@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-09T15:59:38.720538+02:00[Europe/Oslo]")
@Component("com.spond.data.web.metno.api.MetNoMetadataApi")
public class MetNoMetadataApi {
    private MetNoApiClient metNoApiClient;

    public MetNoMetadataApi() {
        this(new MetNoApiClient());
    }

    @Autowired
    public MetNoMetadataApi(MetNoApiClient metNoApiClient) {
        this.metNoApiClient = metNoApiClient;
    }

    public MetNoApiClient getApiClient() {
        return metNoApiClient;
    }

    public void setApiClient(MetNoApiClient metNoApiClient) {
        this.metNoApiClient = metNoApiClient;
    }

    /**
     * 
     * RSS feed of changes to this product
     * <p><b>200</b> - OK
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void changelogGet() throws RestClientException {
        changelogGetWithHttpInfo();
    }

    /**
     * 
     * RSS feed of changes to this product
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> changelogGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = metNoApiClient.expandPath("/changelog", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        final String[] accepts = { };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Check health status for product
     * <p><b>200</b> - OK
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void healthzGet() throws RestClientException {
        healthzGetWithHttpInfo();
    }

    /**
     * 
     * Check health status for product
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> healthzGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = metNoApiClient.expandPath("/healthz", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        final String[] accepts = { };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Schema for XML data
     * <p><b>200</b> - OK
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void schemaGet() throws RestClientException {
        schemaGetWithHttpInfo();
    }

    /**
     * 
     * Schema for XML data
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> schemaGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = metNoApiClient.expandPath("/schema", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        final String[] accepts = { };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
