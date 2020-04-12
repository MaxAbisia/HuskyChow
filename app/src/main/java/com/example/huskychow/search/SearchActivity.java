package com.example.huskychow.search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.huskychow.CurrencyType;
import com.example.huskychow.GlobalVariables;
import com.example.huskychow.MapsActivity;
import com.example.huskychow.R;
import com.example.huskychow.Restaurant;
import com.example.huskychow.RestaurantList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// the search page that's created when the search bar is touched
public class SearchActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    // the restaurants returned by a search
    private Map<CurrencyType, ArrayList<Restaurant>> foundRestaurants;
    // all of the restaurants in our database and if they've been found yet
    private Map<Restaurant, Boolean> allRestaurants;
    // boolean for husky dollars filter
    private Boolean onlyDollars;
    // boolean for meal swipes filter
    private Boolean onlySwipes;

    GlobalVariables globals;

    // ui elements
    private EditText searchBar;
    private ImageButton cardButton;
    private ImageButton dollarButton;

    private SearchResultsViewModel model;
    private SearchResultsLayout searchResultsLayout;


    public SearchActivity() {
        allRestaurants = new HashMap<>();
        foundRestaurants = new HashMap<>();

        onlyDollars = false;
        onlySwipes = false;

        RestaurantList restaurantList = new RestaurantList();
        for (Restaurant res : restaurantList.getRestaurants()) {
            allRestaurants.put(res, false);
        }

        foundRestaurants.put(CurrencyType.HUSKY_DOLLARS, new ArrayList<Restaurant>());
        foundRestaurants.put(CurrencyType.MEAL_SWIPES, new ArrayList<Restaurant>());
        foundRestaurants.put(CurrencyType.BOTH, new ArrayList<Restaurant>());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        globals = (GlobalVariables) getApplication();

        searchBar = findViewById(R.id.SearchBar);
        model = ViewModelProviders.of(this).get(SearchResultsViewModel.class);
        searchResultsLayout = findViewById(R.id.ResultsLayout);

        cardButton = findViewById(R.id.cardbutton);
        cardButton.setOnClickListener(this);

        dollarButton = findViewById(R.id.dollarbutton);
        dollarButton.setOnClickListener(this);

        searchBar.requestFocus();
        searchBar.addTextChangedListener(this);

        ImageButton backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardbutton:
                if (cardButton.isActivated()) {
                    onlySwipes = false;
                    showAll();
                } else {
                    onlySwipes = true;
                    showOnlySwipes();
                }

                dollarButton.setActivated(false);
                cardButton.setActivated(!cardButton.isActivated());
                break;

            case R.id.dollarbutton:
                if (dollarButton.isActivated()) {
                    onlyDollars = false;
                    showAll();
                } else {
                    onlyDollars = true;
                    showOnlyHuskyDollar();
                }

                cardButton.setActivated(false);
                dollarButton.setActivated(!dollarButton.isActivated());
                break;

            case R.id.backbutton:
                startActivity(new Intent(SearchActivity.this, MapsActivity.class));
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    // changes the returned restaurants as the user types
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String input = searchBar.getText().toString();
        clearResults();

        for (Map.Entry<Restaurant, Boolean> restaurant : allRestaurants.entrySet()) {

            if (restaurant.getKey().getName().toLowerCase().contains(input.toLowerCase())) {
                addFoundRestaurant(restaurant);
            }
        }

        if (onlyDollars) {
            showOnlyHuskyDollar();
        } else if (onlySwipes) {
            showOnlySwipes();
        } else {
            showAll();
        }
    }

    // if the text is blank or only spaces, clears the results
    @Override
    public void afterTextChanged(Editable s) {
        String input = searchBar.getText().toString();

        if (input.equals("") || input.equals(" ")) {
            clearResults();
        }

        // TODO Delete this eventually. Shows all of the restaurants in the database
        if (input.equals("SHOW ALL")) {
            for (Map.Entry<Restaurant, Boolean> res : allRestaurants.entrySet()) {
                addFoundRestaurant(res);
                showAll();
            }
        }
    }

    // adds a restaurant to the list of found restaurants
    private void addFoundRestaurant(Map.Entry<Restaurant, Boolean> restaurant) {
        if (!restaurant.getValue()) {
            ArrayList<Restaurant> foundRestaurantsOfType = foundRestaurants.get(restaurant.getKey().getCurrencyType());

            if (foundRestaurantsOfType != null) {
                foundRestaurantsOfType.add(restaurant.getKey());
                restaurant.setValue(true);
            }
        }
    }

    // clears the list of found restaurants and the ui
    private void clearResults() {
        for (CurrencyType key : foundRestaurants.keySet()) {
            ArrayList<Restaurant> restaurants = Objects.requireNonNull(foundRestaurants.get(key));
            restaurants.clear();
        }

        for (Map.Entry<Restaurant, Boolean> restaurant : allRestaurants.entrySet()) {
            restaurant.setValue(false);
        }

        searchResultsLayout.removeAllViews();
        model.setResults(new ArrayList<Restaurant>());
    }

    // creates all of the search result fragments
    private void setResults(ArrayList<Restaurant> results) {
        searchResultsLayout.removeAllViews();

            for (Restaurant result : results) {
                final SearchResult searchResult = makeSearchResult(result);
                searchResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchResult.setBackgroundColor(Color.LTGRAY);
                        selectResult(v, searchResult.getPlaceName());
                    }
                });

                searchResultsLayout.addView(searchResult);
                model.setResults(results);
            }
    }

    // makes a fragment representing a restaurant returned from a search
    private SearchResult makeSearchResult(Restaurant restaurant) {
        SearchResult searchResult = new SearchResult(this);
        searchResult.setResultDetails(restaurant);
        return searchResult;
    }

    private void selectResult(View v, String restaurantName) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        globals.setActiveRestaurant(restaurantName);
        this.startActivity(intent);
        this.finish();
    }

    public void showOnlyHuskyDollar() {
        ArrayList<Restaurant> onlyHuskyDollars = new ArrayList<>();

        onlyHuskyDollars.addAll(Objects.requireNonNull(foundRestaurants.get(CurrencyType.HUSKY_DOLLARS)));
        onlyHuskyDollars.addAll(Objects.requireNonNull(foundRestaurants.get((CurrencyType.BOTH))));

        setResults(onlyHuskyDollars);
    }

    public void showOnlySwipes() {
        ArrayList<Restaurant> onlyHuskyDollars = new ArrayList<>();

        onlyHuskyDollars.addAll(Objects.requireNonNull(foundRestaurants.get(CurrencyType.MEAL_SWIPES)));
        onlyHuskyDollars.addAll(Objects.requireNonNull(foundRestaurants.get((CurrencyType.BOTH))));

        setResults(onlyHuskyDollars);
    }

    public void showAll() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        restaurants.addAll(Objects.requireNonNull(foundRestaurants.get(CurrencyType.HUSKY_DOLLARS)));
        restaurants.addAll(Objects.requireNonNull(foundRestaurants.get((CurrencyType.MEAL_SWIPES))));
        restaurants.addAll(Objects.requireNonNull(foundRestaurants.get((CurrencyType.BOTH))));

        setResults(restaurants);
    }
}
