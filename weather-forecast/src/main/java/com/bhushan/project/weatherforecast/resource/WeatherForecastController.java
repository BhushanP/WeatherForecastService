package com.bhushan.project.weatherforecast.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhushan.project.weatherforecast.model.WeatherForecastResponse;
import com.bhushan.project.weatherforecast.service.IWeatherForecastService;

@RestController
@RequestMapping("/app")
public class WeatherForecastController {
	
	@Autowired 
	IWeatherForecastService  forecastService;
	
	@GetMapping("/weatherforecast/{city}")
	public ResponseEntity<WeatherForecastResponse>getWeatherForecastForCity(@PathVariable("city") String city){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body((forecastService.getWeatherForecastForCity(city)));
	}
	
	@GetMapping("/weatherforecast/{city}/{days}")
	public ResponseEntity<WeatherForecastResponse>getCityForecastForDays(@PathVariable("city") String city,@PathVariable("days") int days){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body((forecastService.getWeatherForecastForCityForDays(city,days)));
	}

}
