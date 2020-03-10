package com.example.huskychow.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.huskychow.CurrencyType;
import com.example.huskychow.R;
import com.example.huskychow.Restaurant;

// a singular restaurant displayed on the search page
public class SearchResult extends FrameLayout {
    // the name of the restaurant on the ui
    private TextView PlaceName;
    // the restaurant's address on the ui
    private TextView Address;
    private ImageView CurrencyImage;

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
        CurrencyImage = findViewById(R.id.Currency);
    }

    // sets the ui text of the search result
    public void setResultDetails(Restaurant restaurant) {
        PlaceName.setText(restaurant.getName());
        Address.setText(restaurant.getAddress());

        switch (restaurant.getCurrencyType()) {
            case HUSKY_DOLLARS:
                CurrencyImage.setImageResource(R.drawable.huskydollar);
                break;
            case MEAL_SWIPES:
                CurrencyImage.setImageResource(R.drawable.swipe);
                break;
            case BOTH:
                CurrencyImage.setImageResource(R.drawable.swipeanddollar);
                break;
            default:
                CurrencyImage.setImageResource(R.drawable.swipeanddollar);
                break;
        }
        postInvalidate();
    }

    public String getPlaceName() {
        return PlaceName.toString();
    }
}
