package com.weather.problem1.service;

import com.weather.problem1.dto.WeatherRequest;
import com.weather.problem1.dto.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
@CacheConfig(cacheNames={"weatherRequest"})
@Slf4j
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${weather.url}")
    String weatherUrl;
    @Value("${weather.appKey}")
    String appKey;

    @Cacheable
    public WeatherResponse fetchWeatherDetailsByCityAndCountry(WeatherRequest weatherRequest) {
        log.info("weather request object" + weatherRequest);
        String uri = weatherUrl+"?q="+weatherRequest.getCity()+","+weatherRequest.getCountry()+"&appid="+appKey;
        log.info("***************Checking caching service call*****************");
        return restTemplate
                .getForObject(uri, WeatherResponse.class);
    }

    @Cacheable
    public WeatherResponse fetchWeatherDetailsByCoordinates(WeatherRequest weatherRequest) {
        log.info("weather request object" + weatherRequest);
        String uri = weatherUrl+"?lat="+weatherRequest.getLat()+"&lon="+weatherRequest.getLng()+"&appid="+appKey;
        log.info("***************Checking caching service call*****************");
        return restTemplate
                .getForObject(uri, WeatherResponse.class);
    }

    @CacheEvict(allEntries = true)
    @Scheduled(fixedDelay = 7200000)
    public void removeWeatherDetails() {
        log.info("***********Cache Cleaning**********, " +
                "Next Cleanup scheduled at : " + new Date(System.currentTimeMillis()+ 7200000));
    }
}
