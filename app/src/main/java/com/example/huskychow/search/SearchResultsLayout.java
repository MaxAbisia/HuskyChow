package com.example.huskychow.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.huskychow.MapsActivity;
import com.example.huskychow.Restaurant;

import java.util.ArrayList;

/**
 * The list of restaurants returned by a search
 */
public class SearchResultsLayout extends LinearLayout {
    Context mContext;

    public SearchResultsLayout(Context context) {
        super(context);
        init(context);
    }

    public SearchResultsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SearchResultsLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        this.mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setViews(ArrayList<Restaurant> results) {
        this.removeAllViews();
        for (Restaurant result : results) {
            final SearchResult searchResult = makeSearchResult(result);
            searchResult.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // open that other view
                    searchResult.setBackgroundColor(Color.LTGRAY);
                    SelectResult(v);
                }
            });
            this.addView(searchResult);
        }
    }

    private void SelectResult(View v) {
        Intent intent = new Intent(mContext, MapsActivity.class);
        mContext.startActivity(intent);
    }

    private SearchResult makeSearchResult(Restaurant restaurant) {
        SearchResult searchResult = new SearchResult(mContext);
        searchResult.setResultDetails(restaurant);
        return searchResult;
    }
}
