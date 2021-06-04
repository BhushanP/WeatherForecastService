package com.bhushan.project.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "country", "population" })
public class City {
	@JsonProperty("name")
	private String name;
	@JsonProperty("country")
	private String country;
	@JsonProperty("population")
	private Long population;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("population")
	public Long getPopulation() {
		return population;
	}

	@JsonProperty("population")
	public void setPopulation(Long population) {
		this.population = population;
	}

}