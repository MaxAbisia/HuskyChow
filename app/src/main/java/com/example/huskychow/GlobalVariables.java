package com.example.huskychow;

import android.app.Application;

public class GlobalVariables extends Application {

    // the Title of the active restaurant
    private String activeRestaurant = "";

    public String getValue() {
        return this.activeRestaurant;
    }

    public void setActiveRestaurant(String r) {
        this.activeRestaurant = r;
    }
}
