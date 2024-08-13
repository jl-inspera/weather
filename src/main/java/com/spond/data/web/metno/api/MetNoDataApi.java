package com.spond.data.web.metno.api;

import com.spond.data.web.metno.invoker.MetNoApiClient;

import com.spond.data.web.metno.model.METJSONForecast;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.annotation.processing.Generated;

@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-09T15:59:38.720538+02:00[Europe/Oslo]")
@Component("com.spond.data.web.metno.api.MetNoDataApi")
public class MetNoDataApi {
    private final MetNoApiClient metNoApiClient;


    public MetNoDataApi(MetNoApiClient metNoApiClient) {
        this.metNoApiClient = metNoApiClient;
    }

    public MetNoApiClient getApiClient() {
        return metNoApiClient;
    }

/*    public void setApiClient(MetNoApiClient metNoApiClient) {
        this.metNoApiClient = metNoApiClient;
    }*/

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String classicFormatGet(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        return classicFormatGetWithHttpInfo(lat, lon, format, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> classicFormatGetWithHttpInfo(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling classicFormatGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling classicFormatGet");
        }
        
        // verify the required parameter 'format' is set
        if (format == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'format' when calling classicFormatGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("format", format);
        String path = metNoApiClient.expandPath("/classic.{format}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/xml"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String classicGet(Float lat, Float lon, Integer altitude) throws RestClientException {
        return classicGetWithHttpInfo(lat, lon, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> classicGetWithHttpInfo(Float lat, Float lon, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling classicGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling classicGet");
        }
        
        String path = metNoApiClient.expandPath("/classic", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/xml"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return METJSONForecast
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public METJSONForecast compactFormatGet(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        return compactFormatGetWithHttpInfo(lat, lon, format, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;METJSONForecast&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<METJSONForecast> compactFormatGetWithHttpInfo(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling compactFormatGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling compactFormatGet");
        }
        
        // verify the required parameter 'format' is set
        if (format == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'format' when calling compactFormatGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("format", format);
        String path = metNoApiClient.expandPath("/compact.{format}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<METJSONForecast> returnType = new ParameterizedTypeReference<METJSONForecast>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return METJSONForecast
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public METJSONForecast compactGet(Float lat, Float lon, Integer altitude) throws RestClientException {
        return compactGetWithHttpInfo(lat, lon, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;METJSONForecast&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<METJSONForecast> compactGetWithHttpInfo(Float lat, Float lon, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling compactGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling compactGet");
        }
        
        String path = metNoApiClient.expandPath("/compact", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<METJSONForecast> returnType = new ParameterizedTypeReference<METJSONForecast>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return METJSONForecast
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public METJSONForecast completeFormatGet(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        return completeFormatGetWithHttpInfo(lat, lon, format, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;METJSONForecast&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<METJSONForecast> completeFormatGetWithHttpInfo(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling completeFormatGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling completeFormatGet");
        }
        
        // verify the required parameter 'format' is set
        if (format == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'format' when calling completeFormatGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("format", format);
        String path = metNoApiClient.expandPath("/complete.{format}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<METJSONForecast> returnType = new ParameterizedTypeReference<METJSONForecast>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return METJSONForecast
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public METJSONForecast completeGet(Float lat, Float lon, Integer altitude) throws RestClientException {
        return completeGetWithHttpInfo(lat, lon, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;METJSONForecast&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<METJSONForecast> completeGetWithHttpInfo(Float lat, Float lon, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling completeGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling completeGet");
        }
        
        String path = metNoApiClient.expandPath("/complete", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<METJSONForecast> returnType = new ParameterizedTypeReference<METJSONForecast>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return METJSONForecast
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public METJSONForecast miniFormatGet(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        return miniFormatGetWithHttpInfo(lat, lon, format, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param format format code (file extension) (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;METJSONForecast&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<METJSONForecast> miniFormatGetWithHttpInfo(Float lat, Float lon, String format, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling miniFormatGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling miniFormatGet");
        }
        
        // verify the required parameter 'format' is set
        if (format == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'format' when calling miniFormatGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("format", format);
        String path = metNoApiClient.expandPath("/mini.{format}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<METJSONForecast> returnType = new ParameterizedTypeReference<METJSONForecast>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return METJSONForecast
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public METJSONForecast miniGet(Float lat, Float lon, Integer altitude) throws RestClientException {
        return miniGetWithHttpInfo(lat, lon, altitude).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param lat Latitude (required)
     * @param lon Longitude (required)
     * @param altitude Whole meters above sea level (optional)
     * @return ResponseEntity&lt;METJSONForecast&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<METJSONForecast> miniGetWithHttpInfo(Float lat, Float lon, Integer altitude) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'lat' is set
        if (lat == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lat' when calling miniGet");
        }
        
        // verify the required parameter 'lon' is set
        if (lon == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lon' when calling miniGet");
        }
        
        String path = metNoApiClient.expandPath("/mini", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "altitude", altitude));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lat", lat));
        queryParams.putAll(metNoApiClient.parameterToMultiValueMap(null, "lon", lon));

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<METJSONForecast> returnType = new ParameterizedTypeReference<METJSONForecast>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param format format code (file extension) (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String statusFormatGet(String format) throws RestClientException {
        return statusFormatGetWithHttpInfo(format).getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @param format format code (file extension) (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> statusFormatGetWithHttpInfo(String format) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'format' is set
        if (format == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'format' when calling statusFormatGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("format", format);
        String path = metNoApiClient.expandPath("/status.{format}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String statusGet() throws RestClientException {
        return statusGetWithHttpInfo().getBody();
    }

    /**
     * 
     * Weather forecast for a specified place
     * <p><b>200</b> - Success
     * <p><b>204</b> - 204 No Content
     * <p><b>400</b> - 400 Bad Request
     * <p><b>401</b> - 401 Unauthorized
     * <p><b>403</b> - 403 Forbidden
     * <p><b>404</b> - 404 Not Found
     * <p><b>422</b> - 422 Unprocessable Entity
     * <p><b>429</b> - 429 Too Many Requests
     * <p><b>500</b> - 500 Internal Server Error
     * <p><b>502</b> - 502 Bad Gateway
     * <p><b>503</b> - 503 Service Unavailable
     * <p><b>504</b> - 504 Gateway Timeout
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> statusGetWithHttpInfo() throws RestClientException {
        Object postBody = null;
        
        String path = metNoApiClient.expandPath("/status", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        final String[] accepts = { 
            "application/json;charset=UTF-8"
        };
        final List<MediaType> accept = metNoApiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = metNoApiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return metNoApiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
