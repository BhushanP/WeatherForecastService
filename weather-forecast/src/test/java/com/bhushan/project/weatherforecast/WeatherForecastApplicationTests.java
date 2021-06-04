package com.bhushan.project.weatherforecast;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bhushan.project.weatherforecast.model.WeatherForecastResponse;
import com.bhushan.project.weatherforecast.service.impl.WeatherForecastServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastApplicationTests {
	
	@Autowired
	private WeatherForecastServiceImpl forecastService;

	@Test
	public void testCityWeatherFore() {		
		WeatherForecastResponse forecast = this.forecastService.getWeatherForecastForCity("Bangalore");
		assertThat(forecast.getCity().equalsIgnoreCase("Bangalore"));
		assertThat(forecast.getForecasts().size()==3);
		assertThat(forecast!=null);
	}

	@Test
	public void testCityWeatherForeForNDays() {
		WeatherForecastResponse forecast = this.forecastService.getWeatherForecastForCityForDays("Mumbai",5);
		assertThat(forecast.getCity().equalsIgnoreCase("Mumbai"));
		assertThat(forecast.getForecasts().size()==5);
		assertThat(forecast!=null);
	}

}