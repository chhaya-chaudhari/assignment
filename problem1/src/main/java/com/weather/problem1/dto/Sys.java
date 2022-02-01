package com.weather.problem1.dto;

import lombok.Setter;

@Setter
public class Sys{
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
}