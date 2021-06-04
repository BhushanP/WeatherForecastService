package com.bhushan.project.weatherforecast.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bhushan.project.weatherforecast.exception.WeatherForecastException;
import com.bhushan.project.weatherforecast.model.ThirdPartyApiResponse;
import com.bhushan.project.weatherforecast.model.WeatherForecastResponse;
import com.bhushan.project.weatherforecast.service.IWeatherForecastService;
import com.bhushan.project.weatherforecast.service.util.ResponseMapperUtil;

@Service
public class WeatherForecastServiceImpl implements IWeatherForecastService {

	@Autowired
	RestTemplate restTemplate;

	private UriComponentsBuilder urlbuilder;

	@PostConstruct
	protected void init() {

		urlbuilder = UriComponentsBuilder.newInstance().scheme("http").host("api.openweathermap.org")
				.path("/data/2.5/forecast/daily").queryParam("mode", "json")
				.queryParam("units", "metric").queryParam("appid", "212c66a25a472c08ed353270edf23703");
	}

	@Override
	public WeatherForecastResponse getWeatherForecastForCity(String city) {
		try {
			String url = urlbuilder.replaceQueryParam("q", city).replaceQueryParam("cnt", 3).build().toUriString();
			ThirdPartyApiResponse thirdPartyApiResponse = new RestTemplate().getForObject(url,
					ThirdPartyApiResponse.class);
			WeatherForecastResponse forecastResponse = ResponseMapperUtil.mapThirdpartyResponse(thirdPartyApiResponse);
			return forecastResponse;
		} catch (Exception e) {
			throw new WeatherForecastException();
		}
	}

	@Override
	public WeatherForecastResponse getWeatherForecastForCityForDays(String city, int days) {
		try {
			String url = urlbuilder.replaceQueryParam("q", city).replaceQueryParam("cnt", days<=0?3:days).build().toUriString();
			ThirdPartyApiResponse thirdPartyApiResponse = new RestTemplate().getForObject(url,
					ThirdPartyApiResponse.class);
			WeatherForecastResponse forecastResponse = ResponseMapperUtil.mapThirdpartyResponse(thirdPartyApiResponse);
			return forecastResponse;
		} catch (Exception e) {
			throw new WeatherForecastException();
		}
	}

}
