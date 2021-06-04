package com.bhushan.project.weatherforecast.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bhushan.project.weatherforecast.exception.WeatherForecastException;
import com.bhushan.project.weatherforecast.model.ErrorResponse;

@ControllerAdvice
public class WeatherForecastExceptionHandler {
	
	@ExceptionHandler(WeatherForecastException.class)
	public ResponseEntity<ErrorResponse>handleException(){		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(-1, "City not found, pleqase enter a valid city"));		
	}

}
