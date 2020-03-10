package com.example.huskychow.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.huskychow.R;
import com.example.huskychow.Restaurant;
import com.google.android.libraries.places.api.Places;

import java.util.ArrayList;

// the search page that's created when the search bar is touched
public class SearchActivity extends AppCompatActivity {

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
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    try  {
                        String input = searchBarInput.getText().toString();
                        PlacesSearchTask task = new PlacesSearchTask(input, apiKey);
                        ArrayList<Restaurant> foundRestaurants = task.execute().get();
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
