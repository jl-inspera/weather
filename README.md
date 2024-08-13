# Weather Server

Java based RESTful API service for weather forecasts of upcoming events.
An event has location as a latitude and longitude. An event takes place between start time and end time. Latitude and Longitude are floating point values. Start and end time are UTC timestamps.

The server shows, for any event that starts in the next 7 day:
- air temperature, in Celsius
- wind speed, in m/s
- weather summary, in plain english

The [met.no Located Forecast API](https://api.met.no/weatherapi/locationforecast/2.0/documentation) is used to provide weather forecast information. The forecast information is no more than 2 hours old, except in states where there is failure to contact met.no.

# Requirements
This software was developed with/for the following tools. Some adaptation may or may not be required to run it with different tools/versions.
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
```
curl -v -X 'GET' 'http://localhost:8080/event?latitude=20.0&longitude=20.00&startTime=2024-08-18T19:00:00Z&endTime=2024-08-18T20:00:00Z'
```