package com.example.huskychow;

//This class represents a single restaurant near campus
public class Restaurant {

    //the name of the restaurant
    private String name;

    //the address of the restaurant
    private String address;

    //a link to the url hosting this Restaurant's website
    private String url;

    //TODO: how do we want to store times?
    private String openTime;
    private String closeTime;

    //the type of currency the restaurant accepts: husky dollars, meal swipes, or both
    private CurrencyType currencyType;

    //the relative price of the restaurant: high, medium, or low
    private RestaurantPrice price;

    //constructor for a Restaurant object
    public Restaurant(String name, String address, String url, String openTime, String closeTime,
                      CurrencyType currencyType, RestaurantPrice price) {
        this.name = name;
        this.address = address;
        this.url = url;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.currencyType = currencyType;
        this.price = price;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //getters for the 5 private fields of this object
    //TODO add one for open and close time

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

    //return the RestaurantPrice of the restaurant.
    public RestaurantPrice getPrice() {
        return this.price;
    }
}
