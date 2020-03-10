package com.example.huskychow;

import java.util.ArrayList;

//This class represents all the data needed to run husky chow.
public class HuskyChowModel {

    //an ArrayList of Restaurant objects
    private ArrayList<Restaurant> restaurantList;

    //TODO need to know the information needed to construct a restaurant (from API)
    public void addRestaurant() {

    }

    //removes the first restaurant in the list that matches by name
    //compares after normalizing capitalization
    public void removeRestaurant(String name) {
        for (Restaurant restaurant : this.restaurantList) {
            if (restaurant.getName().toLowerCase().equals(name.toLowerCase())) {
                //mutates the list of restaurants
                this.restaurantList.remove(restaurant);
            }
        }
    }


}
