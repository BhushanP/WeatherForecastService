package com.bhushan.project.weatherforecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "city",
    "list"
})
public class ThirdPartyApiResponse {

    @JsonProperty("city")
    private City city;
    @JsonProperty("list")
    private java.util.List<Day> days = null;

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }   

    @JsonProperty("list")
    public List<Day> getDays() {
        return days;
    }

    @JsonProperty("list")
    public void setDays(List<Day> days) {
        this.days = days;
    }

}