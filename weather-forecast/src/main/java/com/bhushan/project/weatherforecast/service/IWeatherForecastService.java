package com.bhushan.project.weatherforecast.service;

import com.bhushan.project.weatherforecast.model.WeatherForecastResponse;

public interface IWeatherForecastService {
	
	public WeatherForecastResponse getWeatherForecastForCity(final String city);

	public WeatherForecastResponse getWeatherForecastForCityForDays(final String city, int days);

}
