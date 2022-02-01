package com.weather.problem1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.weather.problem1.validators.OnCitySearch;
import com.weather.problem1.validators.OnLatLngSearch;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
public class WeatherRequest {
    @NotBlank(groups = OnCitySearch.class, message = "City name is required")
    private String city;
    private String country;
    @NotBlank(groups = OnLatLngSearch.class, message = "Latitude is required")
    private String lat;
    @NotBlank(groups = OnLatLngSearch.class, message = "Longitude is required")
    private String lng;
}
