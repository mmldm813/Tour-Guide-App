package com.example.android.tourguideapp.models;

/**
 * Created by michellemedina on 12/13/17.
 */

public class Attraction {
    public String attractionName;
    public int imageResourceID;
    public String attractionDescription;
    public String attractionAddress;
    public String attractionHours;

    public Attraction(String attractionName, int imageResourceID, String attractionDescription,
               String attractionAddress, String attractionHours) {
        this.attractionName = attractionName;
        this.imageResourceID = imageResourceID;
        this.attractionDescription = attractionDescription;
        this.attractionAddress = attractionAddress;
        this.attractionHours = attractionHours;
    }
}

