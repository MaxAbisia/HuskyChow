package com.example.huskychow;

import java.util.ArrayList;

public class RestaurantList {

    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    public RestaurantList() {

        // ON CAMPUS
        Restaurant rebeccas = new Restaurant(
                "Rebecca's Cafe",
                "380 Huntington Avenue (Churchill Hall)",
                "7:00 am - 4:00 pm",
                CurrencyType.BOTH,
                42.338975, -71.088670);

        Restaurant iv = new Restaurant(
                "International Village",
                "1155 Tremont Street",
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
                "716 Columbus Avenue",
                "7:00 am - 4:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.337728, -71.085334);

        Restaurant cafeCrossing = new Restaurant(
                "Café Crossing",
                "1175 Tremont Street (International Village)",
                "7:00 am - 4:00 pm",
                CurrencyType.BOTH,
                42.335068, -71.088737);

        Restaurant cafeStrega = new Restaurant(
                "Café Strega",
                "805 Columbus Avenue (ISEC)",
                "7:00 am - 4:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.337937, -71.086962);

        Restaurant dunkinShillman = new Restaurant(
                "Dunkin' Shillman Hall",
                "115 Forsyth Street (Shillman)",
                "7:00 am - 6:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.337572, -71.090201);

        Restaurant bGood = new Restaurant(
                "b.good",
                "359 Huntington Avenue (Marino)",
                "11:30 am - 8:30 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.340106, -71.090230);

        Restaurant tatte = new Restaurant(
                "Tatte Bakery and Café",
                "359 Huntington Avenue (Marino)",
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
                42.340957, -71.090197);

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

        Restaurant stwest = new Restaurant(
                "Stetson West",
                "106 St Stephen Street",
                "11:00 am - 8:00 pm",
                CurrencyType.MEAL_SWIPES,
                42.340964, -71.090502);

        Restaurant sweetTomatoesPizza = new Restaurant(
                "Sweet Tomatoes Pizza",
                "Curry Student Center",
                "11:00 am - 7:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339316, -71.087558);

        Restaurant uburger = new Restaurant(
                "UBURGER",
                "Curry Student Center",
                "11:00 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339246, -71.087499);

        Restaurant wollastons = new Restaurant(
                "Wollaston’s Grocery",
                "369 Huntington Ave (Marino)",
                "7:00 am - 1:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.340256, -71.090645);

        Restaurant smallastons = new Restaurant(
                "Smallaston's Grocery",
                "460 Parker Street (West Village B)",
                "7:00 am - 12:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.337356, -71.092176);

        Restaurant subway = new Restaurant(
                "Subway",
                "11 Leon St (Ryder Hall)",
                "8:00 am - 8:30 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.336448, -71.090752);

        Restaurant tuTaco = new Restaurant(
                "Tu Taco",
                "Curry Student Center",
                "11:00 am - 7:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.338951, -71.087545);

        Restaurant westEnd = new Restaurant(
                "The West End",
                "Curry Student Center",
                "11:00 am - 7:00 pm",
                CurrencyType.BOTH,
                42.339146, -71.087612);




        // OFF CAMPUS
        Restaurant amelias = new Restaurant(
                "Amelia’s Taqueria",
                "309 Huntington Avenue",
                "11:00 am - 2:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.341165, -71.087408);

        Restaurant bangkokPinto = new Restaurant(
                "Bangkok Pinto",
                "1041 Tremont Street",
                "11:00 am - 10:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.336577, -71.085773);

        Restaurant bostonShawarma = new Restaurant(
                "Boston Shawarma",
                "315 Huntington Avenue",
                "11:00 am - 10:00 pm",
                CurrencyType.BOTH,
                42.341023, -71.087715);

        Restaurant cappys = new Restaurant(
                "Cappy’s Pizza and Subs",
                "82 Westland Avenue",
                "6:30 am - 2:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.343740, -71.089597);

        Restaurant collegeConvenience = new Restaurant(
                "College Convenience",
                "281 Huntington Avenue",
                "11:00 am - 10:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.341886, -71.086334);

        Restaurant cvs = new Restaurant(
                "CVS",
                "231 Massachusetts Avenue",
                "8:00 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.344265, -71.086625);

        Restaurant dominosBolyston = new Restaurant(
                "Domino's Pizza Boylston",
                "1260 Boylston Street",
                "10:00 am - 1:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.344876, -71.096099);

        Restaurant dominosTremont = new Restaurant(
                "Domino's Pizza Tremont",
                "1400 Tremont Street",
                "10:00 am - 1:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.331237, -71.095354);

        Restaurant ohe =  new Restaurant(
                "Dos Diablos Taco Bar and Two Saints Tavern",
                "52 Gainsborough St",
                "4:00 pm - 2:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.342270, -71.087266);

        Restaurant giovannis =  new Restaurant(
                "Giovanni’s Market",
                "624 Columbus Avenue",
                "8:30 am - 10:45 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.339465, -71.083138);

        Restaurant gyro =  new Restaurant(
                "Gyroscope",
                "305 Huntington Ave",
                "11:00 am - 9:30 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.341945, -71.087267);

        Restaurant lobster =  new Restaurant(
                "Lobstah on a Roll",
                "537 Columbus Ave",
                "10:30 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.349995, -71.082717);

        Restaurant noble =  new Restaurant(
                "Noble Roman’s Pizza",
                "Ruggles T Station",
                "6:30 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.336775, -71.089243);

        Restaurant panera =  new Restaurant(
                "Panera Bread",
                "289 Huntington Ave",
                "7:00 am - 8:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.342341, -71.086531);

        Restaurant phoAndI =  new Restaurant(
                "Pho and I",
                "267 Huntington Avenue",
                "11:30 am - 9:45 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.342913, -71.086142);

        Restaurant sprout =  new Restaurant(
                "Sprout",
                "305 Huntington Ave",
                "11:00 am - 9:30 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.341945, -71.087267);

        Restaurant symphMarket =  new Restaurant(
                "Symphony Market",
                "291 Huntington Avenue",
                "6:00 am - 2:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.342107, -71.086738);

        Restaurant uhop =  new Restaurant(
                "University House of Pizza",
                "42.342107, -71.086738",
                "11:00 am - 1:00 am",
                CurrencyType.HUSKY_DOLLARS,
                42.338673, -71.093057);

        Restaurant wholefoods =  new Restaurant(
                "Whole Foods Market",
                "15 Westland Ave",
                "7:00 am - 10:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.343851, -71.087312);

        Restaurant wingsover =  new Restaurant(
                "Wings Over Boston",
                "325 Huntington Ave",
                "4:00 Pm - 2:00 Am",
                CurrencyType.HUSKY_DOLLARS,
                42.341010, -71.088088);

        Restaurant energize =  new Restaurant(
                "Energize",
                "265 Massachusetts Ave",
                "9:30 am - 7:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.343738, -71.086330);

        Restaurant poke =  new Restaurant(
                "Poke Station",
                "313 Huntington Ave",
                "11:00 am - 10:00 pm",
                CurrencyType.HUSKY_DOLLARS,
                42.341275, -71.087673);

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
        this.restaurants.add(stwest);
        this.restaurants.add(sweetTomatoesPizza);
        this.restaurants.add(uburger);
        this.restaurants.add(smallastons);
        this.restaurants.add(wollastons);
        this.restaurants.add(subway);
        this.restaurants.add(westEnd);
        this.restaurants.add(tuTaco);

        //OFF CAMPUS
        this.restaurants.add(amelias);
        this.restaurants.add(bangkokPinto);
        this.restaurants.add(bostonShawarma);
        this.restaurants.add(cappys);
        this.restaurants.add(collegeConvenience);
        this.restaurants.add(cvs);
        this.restaurants.add(dominosBolyston);
        this.restaurants.add(dominosTremont);
        this.restaurants.add(ohe);
        this.restaurants.add(giovannis);
        this.restaurants.add(gyro);
        this.restaurants.add(lobster);
        this.restaurants.add(noble);
        this.restaurants.add(panera);
        this.restaurants.add(phoAndI);
        this.restaurants.add(sprout);
        this.restaurants.add(symphMarket);
        this.restaurants.add(uhop);
        this.restaurants.add(wholefoods);
        this.restaurants.add(wingsover);
        this.restaurants.add(energize);
        this.restaurants.add(poke);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
