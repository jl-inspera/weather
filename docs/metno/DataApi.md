# DataApi

All URIs are relative to *http://localhost/weatherapi/locationforecast/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**classicFormatGet**](DataApi.md#classicFormatGet) | **GET** /classic.{format} | 
[**classicGet**](DataApi.md#classicGet) | **GET** /classic | 
[**compactFormatGet**](DataApi.md#compactFormatGet) | **GET** /compact.{format} | 
[**compactGet**](DataApi.md#compactGet) | **GET** /compact | 
[**completeFormatGet**](DataApi.md#completeFormatGet) | **GET** /complete.{format} | 
[**completeGet**](DataApi.md#completeGet) | **GET** /complete | 
[**miniFormatGet**](DataApi.md#miniFormatGet) | **GET** /mini.{format} | 
[**miniGet**](DataApi.md#miniGet) | **GET** /mini | 
[**statusFormatGet**](DataApi.md#statusFormatGet) | **GET** /status.{format} | 
[**statusGet**](DataApi.md#statusGet) | **GET** /status | 



## classicFormatGet

> String classicFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;
import com.spond.data.web.metno.api.MetNoDataApi;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        String format = "format_example"; // String | format code (file extension)
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            String result = apiInstance.classicFormatGet(lat, lon, format, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#classicFormatGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **format** | **String**| format code (file extension) | [enum: xml]
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## classicGet

> String classicGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            String result = apiInstance.classicGet(lat, lon, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#classicGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## compactFormatGet

> METJSONForecast compactFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;
import com.spond.data.web.metno.api.MetNoDataApi;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        String format = "format_example"; // String | format code (file extension)
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            METJSONForecast result = apiInstance.compactFormatGet(lat, lon, format, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#compactFormatGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **format** | **String**| format code (file extension) | [enum: json]
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## compactGet

> METJSONForecast compactGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            METJSONForecast result = apiInstance.compactGet(lat, lon, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#compactGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## completeFormatGet

> METJSONForecast completeFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        String format = "format_example"; // String | format code (file extension)
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            METJSONForecast result = apiInstance.completeFormatGet(lat, lon, format, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#completeFormatGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **format** | **String**| format code (file extension) | [enum: json]
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## completeGet

> METJSONForecast completeGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;
import com.spond.data.web.metno.api.MetNoDataApi;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            METJSONForecast result = apiInstance.completeGet(lat, lon, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#completeGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## miniFormatGet

> METJSONForecast miniFormatGet(lat, lon, format, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        String format = "format_example"; // String | format code (file extension)
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            METJSONForecast result = apiInstance.miniFormatGet(lat, lon, format, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#miniFormatGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **format** | **String**| format code (file extension) | [enum: json]
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## miniGet

> METJSONForecast miniGet(lat, lon, altitude)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        Float lat = 3.4F; // Float | Latitude
        Float lon = 3.4F; // Float | Longitude
        Integer altitude = 56; // Integer | Whole meters above sea level
        try {
            METJSONForecast result = apiInstance.miniGet(lat, lon, altitude);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#miniGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **Float**| Latitude |
 **lon** | **Float**| Longitude |
 **altitude** | **Integer**| Whole meters above sea level | [optional]

### Return type

[**METJSONForecast**](METJSONForecast.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## statusFormatGet

> String statusFormatGet(format)



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoDataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        String format = "format_example"; // String | format code (file extension)
        try {
            String result = apiInstance.statusFormatGet(format);
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#statusFormatGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **format** | **String**| format code (file extension) | [enum: json]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |


## statusGet

> String statusGet()



Weather forecast for a specified place

### Example

```java
// Import classes:

import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;
import com.spond.data.web.metno.api.MetNoDataApi;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoDataApi apiInstance = new MetNoDataApi(defaultClient);
        try {
            String result = apiInstance.statusGet();
            System.out.println(result);
        } catch (RestClientException e) {
            System.err.println("Exception when calling DataApi#statusGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json;charset=UTF-8

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |
| **204** | 204 No Content |  -  |
| **400** | 400 Bad Request |  -  |
| **401** | 401 Unauthorized |  -  |
| **403** | 403 Forbidden |  -  |
| **404** | 404 Not Found |  -  |
| **422** | 422 Unprocessable Entity |  -  |
| **429** | 429 Too Many Requests |  -  |
| **500** | 500 Internal Server Error |  -  |
| **502** | 502 Bad Gateway |  -  |
| **503** | 503 Service Unavailable |  -  |
| **504** | 504 Gateway Timeout |  -  |

