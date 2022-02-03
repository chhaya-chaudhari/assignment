package com.weather.problem1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Weather{
    private int id;
    private String main;
    private String description;
    private String icon;
}
