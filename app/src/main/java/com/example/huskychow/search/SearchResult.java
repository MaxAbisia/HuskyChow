package com.example.huskychow.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.huskychow.R;
import com.example.huskychow.Restaurant;

// a singular restaurant displayed on the search page
public class SearchResult extends FrameLayout {
    // the name of the restaurant on the ui
    private TextView PlaceName;
    // the restaurant's address on the ui
    private TextView Address;

    public SearchResult(Context context) {
        super(context);
        init(context,null);
    }

    public SearchResult(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public SearchResult(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet set) {
        LayoutInflater.from(context).inflate(R.layout.search_result, this);
        PlaceName = findViewById(R.id.PlaceName);
        Address = findViewById(R.id.Address);
    }

    // sets the ui text of the search result
    public void setResultDetails(Restaurant restaurant) {
        PlaceName.setText(restaurant.getName());
        Address.setText(restaurant.getAddress());
        postInvalidate();
    }
}
