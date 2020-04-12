package com.example.huskychow;

import java.util.ArrayList;

class RestaurantList {

    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    RestaurantList() {

        // ON CAMPUS
        Restaurant rebeccas = new Restaurant(
                "Rebecca's Cafe",
                "Churchill Hall - 380 Huntington Ave",
                "7:00 am - 4:00 pm",
                CurrencyType.BOTH,
                42.338975, -71.088670);

        Restaurant iv = new Restaurant(
                "International Village",
                "1155 Tremont St",
                "7:00 am - 11:00 pm",
                CurrencyType.MEAL_SWIPES,
                42.335281, -71.089366);

        Restaurant chickenLous = new Restaurant(
                "Chicken Lou's",
                "50 Forsyth Street",
                "7:30 am - 2:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339279, -71.090179);

        Restaurant argo = new Restaurant(
                "Argo Tea",
                "Snell Library",
                "7:00 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.338533, -71.088122);

        Restaurant cafe716 = new Restaurant(
                "Café 716",
                "716 Columbus Ave",
                "7:00 am - 4:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.337728, -71.085334);

        Restaurant cafeCrossing = new Restaurant(
                "Café Crossing",
                "International Village - 1175 Tremont St",
                "7:00 am - 4:00 pm",
                CurrencyType.BOTH,
                42.335068, -71.088737);

        Restaurant cafeStrega = new Restaurant(
                "Café Strega",
                "ISEC - 805 Columbus Ave",
                "7:00 am - 4:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.337937, -71.086962);

        Restaurant dunkinShillman = new Restaurant(
                "Dunkin'",
                "Shillman - 115 Forsyth St",
                "7:00 am - 6:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.337572, -71.090201);

        Restaurant bGood = new Restaurant(
                "b.good",
                "Marino - 359 Huntington Ave",
                "11:30 am - 8:30 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.340106, -71.090230);

        Restaurant tatte = new Restaurant(
                "Tatte Bakery and Café",
                "Marino - 359 Huntington Ave",
                "7:00 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.340028, -71.090503);

        Restaurant steast = new Restaurant(
                "Stetson East\n(Levine Marketplace)",
                "11 Speare Pl",
                "7:00 am - 9:00 pm",
                CurrencyType.MEAL_SWIPES,
                42.341307, -71.090242);

        Restaurant outtakes = new Restaurant(
                "Outtakes",
                "11 Speare Pl",
                "11:00 am - 1:00 am",
                CurrencyType.MEAL_SWIPES,
                42.340957, 71.090197);

        Restaurant qdoba = new Restaurant(
                "Qdoba",
                "393 Huntington Ave Ste 101",
                "11:00 am - 10:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339814, -71.090850);

        Restaurant popeyes = new Restaurant(
                "Popeye's Louisiana Kitchen",
                "Curry Student Center",
                "11:00 am - 7:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339093, -71.087400);

        Restaurant kigo = new Restaurant(
                "Kigo Kitchen",
                "Curry Student Center",
                "11:00 am - 7:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339170, -71.087414);

        Restaurant starbucks = new Restaurant(
                "Starbucks",
                "Curry Student Center",
                "8:00 am - 10:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339033, -71.087270);

        Restaurant theMarket = new Restaurant(
                "The Market",
                "Curry Student Center",
                "11:00 am - 7:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339349, -71.087712);


        //ON CAMPUS
        this.restaurants.add(rebeccas);
        this.restaurants.add(iv);
        this.restaurants.add(chickenLous);
        this.restaurants.add(argo);
        this.restaurants.add(cafe716);
        this.restaurants.add(cafeCrossing);
        this.restaurants.add(cafeStrega);
        this.restaurants.add(dunkinShillman);
        this.restaurants.add(bGood);
        this.restaurants.add(tatte);
        this.restaurants.add(steast);
        this.restaurants.add(outtakes);
        this.restaurants.add(qdoba);
        this.restaurants.add(popeyes);
        this.restaurants.add(kigo);
        this.restaurants.add(starbucks);
        this.restaurants.add(theMarket);
    }

    ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
