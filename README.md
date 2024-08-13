# Weather Server

Java based RESTful API service for weather forecasts of upcoming events.
An event has location as a latitude, longitude, start time and end time value. Latitude and Longitude are floating point values. Start and end time are UTC timestamps.

The server shows, for any event that starts in the next 7 day:
- air temperature, in Celsius
- wind speed, in m/s
- weather summary, in plain english

The [met.no Located Forecast API](https://api.met.no/weatherapi/locationforecast/2.0/documentation) is used to provide weather forecast information. The forecast information is no more than 2 hours old, except in states where there is failure to contact met.no.

# Requirements
This software was developed for the follow tools. Some adaptation may or may not be required to run it with different tools or versions of it.
| tool      | version |
| ----------- | ----------- |
| Maven      | 3.9.8       |
| Java   | 17        |

# Running
Simply navigate to the project path and run the following command to start the server locally.
```
./mvnw spring-boot:run
```

# Issue requests
To make use of the server, you can use the following command or adapt it to your use case.