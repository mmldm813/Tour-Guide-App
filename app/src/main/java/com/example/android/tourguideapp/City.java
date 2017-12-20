package com.example.android.tourguideapp;

/**
 * Created by michellemedina on 12/13/17.
 */

public class City {
    private String cityName;
    private String cityDescription;

    public City(String cityName, String cityDescription){
        this.cityName = cityName;
        this.cityDescription = cityDescription;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityDescription() {
        return cityDescription;
    }
}
