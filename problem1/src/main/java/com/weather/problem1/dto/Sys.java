package com.weather.problem1.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sys{
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
}