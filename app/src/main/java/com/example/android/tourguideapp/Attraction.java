package com.example.android.tourguideapp;

/**
 * Created by michellemedina on 12/13/17.
 */

class Attraction {
    String attractionName;
    int imageResourceID;
    String attractionDescription;
    String attractionAddress;
    String attractionHours;

    Attraction(String attractionName, int imageResourceID, String attractionDescription,
               String attractionAddress, String attractionHours) {
        this.attractionName = attractionName;
        this.imageResourceID = imageResourceID;
        this.attractionDescription = attractionDescription;
        this.attractionAddress = attractionAddress;
        this.attractionHours = attractionHours;
    }
}

