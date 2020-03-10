package com.example.huskychow.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.huskychow.CurrencyType;
import com.example.huskychow.R;
import com.example.huskychow.Restaurant;
import com.google.android.libraries.places.api.Places;

import java.util.ArrayList;

// the search page that's created when the search bar is touched
public class SearchActivity extends AppCompatActivity {
    ArrayList<Restaurant> restaurants;

    public SearchActivity() {
        Restaurant RebeccasCafe = new Restaurant("Rebecca's Cafe",
                "Churchill Hall, 380 Huntington Ave, Boston, MA 02115", CurrencyType.BOTH);
        Restaurant IV = new Restaurant("IV", "1155 Tremont St, Boston, MA 02120",
                CurrencyType.MEAL_SWIPES);
        Restaurant ChickenLous= new Restaurant("Chicken Lou's", "50 Forsyth St, Boston, MA 02115",
                CurrencyType.HUSKY_DOLLARS);

        restaurants.add(RebeccasCafe);
        restaurants.add(IV);
        restaurants.add(ChickenLous);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        final String apiKey = getString(R.string.places_api_key);


        if (apiKey.equals("")) {
            Toast.makeText(this, getString(R.string.error_api_key), Toast.LENGTH_LONG).show();
            return;
        }

        // Setup Places Client
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }

        final SearchResultsViewModel model = ViewModelProviders.of(this)
                .get(SearchResultsViewModel.class);

        final SearchResultsLayout searchResultsLayout = findViewById(R.id.ResultsLayout);

        final EditText searchBarInput = findViewById(R.id.SearchBar);
        searchBarInput.requestFocus();

        // only runs search on enter... look into autocomplete API?
        searchBarInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN /*&& keyCode == KeyEvent.KEYCODE_ENTER*/) {
                    try  {
                        String input = searchBarInput.getText().toString();
                        ArrayList<Restaurant> foundRestaurants = new ArrayList<>();

                        for (Restaurant restaurant : restaurants) {
                            if (restaurant.getName().contains(input)) {
                                foundRestaurants.add(restaurant);
                            }
                        }

                        searchResultsLayout.setViews(foundRestaurants);
                        model.setResults(foundRestaurants);
                        return true;
                    }
                    catch (Exception e) {
                        System.out.println("Failed");
                        return false;
                    }
                }
                return false;
            }
        });
    }

}
