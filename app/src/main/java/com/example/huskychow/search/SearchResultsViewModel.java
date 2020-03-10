package com.example.huskychow.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.huskychow.Restaurant;

import java.util.ArrayList;

public class SearchResultsViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Restaurant>> results = new MutableLiveData<>();

    public void setResults(ArrayList<Restaurant> restaurants) {
        results.setValue(restaurants);
    }

    public LiveData<ArrayList<Restaurant>> getResults() {
        return results;
    }
}
