package com.weather.problem1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Main{
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
}
