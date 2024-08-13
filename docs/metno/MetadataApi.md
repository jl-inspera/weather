# MetadataApi

All URIs are relative to *http://localhost/weatherapi/locationforecast/2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changelogGet**](MetadataApi.md#changelogGet) | **GET** /changelog | 
[**healthzGet**](MetadataApi.md#healthzGet) | **GET** /healthz | 
[**schemaGet**](MetadataApi.md#schemaGet) | **GET** /schema | 



## changelogGet

> changelogGet()



RSS feed of changes to this product

### Example

```java
// Import classes:

import com.spond.data.web.metno.api.MetNoMetadataApi;
import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoMetadataApi apiInstance = new MetNoMetadataApi(defaultClient);
        try {
            apiInstance.changelogGet();
        } catch (RestClientException e) {
            System.err.println("Exception when calling MetadataApi#changelogGet");
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## healthzGet

> healthzGet()



Check health status for product

### Example

```java
// Import classes:

import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;
import com.spond.data.web.metno.api.MetNoMetadataApi;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoMetadataApi apiInstance = new MetNoMetadataApi(defaultClient);
        try {
            apiInstance.healthzGet();
        } catch (RestClientException e) {
            System.err.println("Exception when calling MetadataApi#healthzGet");
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## schemaGet

> schemaGet()



Schema for XML data

### Example

```java
// Import classes:

import com.spond.data.web.metno.invoker.MetNoApiClient;
import com.spond.data.web.metno.invoker.Configuration;
import com.spond.data.web.metno.invoker.models.*;
import com.spond.data.web.metno.api.MetNoMetadataApi;

public class Example {
    public static void main(String[] args) {
        MetNoApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost/weatherapi/locationforecast/2.0");

        MetNoMetadataApi apiInstance = new MetNoMetadataApi(defaultClient);
        try {
            apiInstance.schemaGet();
        } catch (RestClientException e) {
            System.err.println("Exception when calling MetadataApi#schemaGet");
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

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

