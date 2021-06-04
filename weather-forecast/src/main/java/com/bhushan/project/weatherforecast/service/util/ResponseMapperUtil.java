package com.bhushan.project.weatherforecast.service.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bhushan.project.weatherforecast.model.Day;
import com.bhushan.project.weatherforecast.model.Forecast;
import com.bhushan.project.weatherforecast.model.ThirdPartyApiResponse;
import com.bhushan.project.weatherforecast.model.WeatherForecastResponse;
import com.bhushan.project.weatherforecast.util.Constants;
import com.bhushan.project.weatherforecast.util.DateFormatterUtil;

public class ResponseMapperUtil {

	public static WeatherForecastResponse mapThirdpartyResponse(ThirdPartyApiResponse thirdPartyApiResponse) {
		WeatherForecastResponse forecastResponse = new WeatherForecastResponse();
		forecastResponse.setCity(thirdPartyApiResponse.getCity().getName());
		forecastResponse.setDate(DateFormatterUtil.formatDate(new Date(), Constants.DATE_PATTERN_DD_MM_YY));
		List<Forecast> forecasts = new ArrayList<>();
		forecastResponse.setForecasts(forecasts);
		for (Day day : thirdPartyApiResponse.getDays()) {
			forecasts.add(new Forecast.ForecastBuilder(day.getDt()).withDayTemperature(day.getTemp().getDay())
					.withMorningTemperature(day.getTemp().getMorn()).withNightTemperature(day.getTemp().getNight())
					.withTemperatureHigh(day.getTemp().getMax()).withTemperatureLow(day.getTemp().getMin())
					.withHumidity(day.getHumidity()).withpressure(day.getPressure()).withWindSpeed(day.getSpeed())
					.withRainPrediction(day.getRain()).withMessage(day.getWeather().get(0).getDescription()).build());
		}

		return forecastResponse;
	}
}