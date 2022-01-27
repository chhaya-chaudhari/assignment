package com.weather.problem1.api;

import com.weather.problem1.dto.WeatherRequest;
import com.weather.problem1.dto.WeatherResponse;
import com.weather.problem1.service.WeatherService;
import com.weather.problem1.validators.OnCitySearch;
import com.weather.problem1.validators.OnLatLngSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weathers")
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping
    public ResponseEntity<WeatherResponse> fetchByCityAndCountry(@Validated(OnCitySearch.class) @RequestBody WeatherRequest weatherRequest){
        log.info("****************Checking caching controller***************");
        WeatherResponse weatherResponse = weatherService.fetchWeatherDetailsByCityAndCountry(weatherRequest);
            return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
    }

    @PostMapping("/coordinates")
    public ResponseEntity<WeatherResponse> fetchByCoordinates(@Validated(OnLatLngSearch.class) @RequestBody WeatherRequest weatherRequest){
        log.info("****************Checking caching controller***************");
        WeatherResponse weatherResponse = weatherService.fetchWeatherDetailsByCoordinates(weatherRequest);
        return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
    }
}
