package com.example.huskychow;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

//This class represents a single restaurant near campus
public class Restaurant {

    //the name of the restaurant
    private String name = "";

    //the address of the restaurant
    private String address = "";

    //a link to the url hosting this Restaurant's website
    private String url = "";

    //the opening and closing time
    private String hours = "";

    //the type of currency the restaurant accepts: husky dollars, meal swipes, or both
    private CurrencyType currencyType;

    //cartesian coordinate of the restauraunt
    private LatLng location = new LatLng(0, 0);

    // Google Maps marker
    private Marker marker;

    //constructor for a Restaurant object
    public Restaurant(String name, String address, String hours,
                      CurrencyType currencyType, double lat, double lon) {
        this.name = name;
        this.address = address;
        this.hours = hours;
        this.currencyType = currencyType;
        this.location = new LatLng(lat, lon);
    }

    public Restaurant(String name, String address, CurrencyType currencyType) {
        this.name = name;
        this.address = address;
        this.currencyType = currencyType;
    }

    //getters for the 5 private fields of this object
    public String getHours() { return this.hours; }

    //returns the name of the restaurant.
    public String getName() {
        return this.name;
    }

    //return the address of the restaurant.
    public String getAddress() {
        return this.address;
    }

    //return the url of the restaurant's website.
    public String getUrl() {
        return this.url;
    }

    //return the CurrencyType of the restaurant.
    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    //getter for the location
    public LatLng getLocation() {
        return this.location;
    }

    //setter for the marker
    void setMarker(Marker m) {
        this.marker = m;
    }

    //getter for the marker
    public Marker getMarker() {
        return this.marker;
    }
}
