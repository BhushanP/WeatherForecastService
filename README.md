# WeatherForecastService
Spring boot app that provides weather forecast of a given city

The service uses a thirdparty api to fetch the real time weather forecast. App provides below 2 apis:
http://localhost:8080/app/weatherforecast/{city}: Fethces the weather forecast for next 3 days for the entered city.
http://localhost:8080/app/weatherforecast/{city}/{noOfDays} : Fetches the weather forecast for the given no of days for the specified city.

It also provides support to be run in a docker container. 
