package com.bhushan.project.weatherforecast.model;

import java.util.Date;

import com.bhushan.project.weatherforecast.util.Constants;
import com.bhushan.project.weatherforecast.util.DateFormatterUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Forecast {

	@JsonProperty("Day")
	private String day;

	@JsonProperty("Date")
	private String date;

	@JsonProperty("Temperature at day time")
	private Float dayTemperature;

	@JsonProperty("Temperature in the night")
	private Float nightTemperature;

	@JsonProperty("Temperature in the morning")
	private Float morningTemperature;

	@JsonProperty("Highest")
	private Float temperatureHigh;

	@JsonProperty("Lowest")
	private Float temperatureLow;

	@JsonProperty("Wind speed")
	private Float windSpeed;

	@JsonProperty("Pressure")
	private Float pressure;

	@JsonProperty("Humidity")
	private Long humidity;

	@JsonProperty("Rain Prediction")
	private float rainPrediction;

	@JsonProperty("Message for the day")
	private String message;

	private Forecast(String day, String date, Float dayTemperature, Float nightTemperature, Float morningTemperature,
			Float temperatureHigh, Float temperatureLow, Float windSpeed, Float pressure, Long humidity,
			float rainPrediction, String message) {
		super();
		this.day = day;
		this.date = date;
		this.dayTemperature = dayTemperature;
		this.nightTemperature = nightTemperature;
		this.morningTemperature = morningTemperature;
		this.temperatureHigh = temperatureHigh;
		this.temperatureLow = temperatureLow;
		this.windSpeed = windSpeed;
		this.pressure = pressure;
		this.humidity = humidity;
		this.rainPrediction = rainPrediction;
		this.message = message;
	}

	private Forecast() {
	}

	public static class ForecastBuilder {

		private String day;
		private String date;
		private Float dayTemperature;
		private Float nightTemperature;
		private Float morningTemperature;
		private Float temperatureHigh;
		private Float temperatureLow;
		private Float windSpeed;
		private Float pressure;
		private Long humidity;
		private float rainPrediction;
		private String message;

		public ForecastBuilder(Long date) {
			Date tempDate = new Date(date * 1000);
			this.date = DateFormatterUtil.formatDate(tempDate, Constants.DATE_PATTERN_DD_MM_YY);
			this.day = DateFormatterUtil.formatDate(tempDate, Constants.DATE_PATTERN_DAY);
		}

		public ForecastBuilder withDayTemperature(Float dayTemperature) {
			this.dayTemperature = dayTemperature;
			return this;
		}

		public ForecastBuilder withNightTemperature(Float nightTemperature) {
			this.nightTemperature = nightTemperature;
			return this;
		}

		public ForecastBuilder withMorningTemperature(Float morningTemperature) {
			this.morningTemperature = morningTemperature;
			return this;
		}

		public ForecastBuilder withTemperatureHigh(Float temperatureHigh) {
			this.temperatureHigh = temperatureHigh;
			return this;
		}

		public ForecastBuilder withTemperatureLow(Float temperatureLow) {
			this.temperatureLow = temperatureLow;
			return this;
		}

		public ForecastBuilder withWindSpeed(Float windSpeed) {
			this.windSpeed = windSpeed;
			return this;
		}

		public ForecastBuilder withpressure(Float pressure) {
			this.pressure = pressure;
			return this;
		}

		public ForecastBuilder withHumidity(Long humidity) {
			this.humidity = humidity;
			return this;
		}

		public ForecastBuilder withRainPrediction(float rainPrediction) {
			this.rainPrediction = rainPrediction;
			return this;
		}

		public ForecastBuilder withMessage(String message) {
			if (this.rainPrediction > 0)
				this.message = "Its going to rain!! Carry umbrella!!!";
			else if (this.temperatureHigh > 40)
				this.message = "Its too hot outside, Use suscreen lotion";
			else
				this.message = message;
			return this;
		}

		public Forecast build() {
			Forecast forecast = new Forecast(this.day, this.date, this.dayTemperature, this.nightTemperature,
					this.morningTemperature, this.temperatureHigh, this.temperatureLow, this.windSpeed, this.pressure,
					this.humidity, this.rainPrediction, this.message);
			return forecast;

		}
	}

}
