package com.example.huskychow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class DetailActivity extends FragmentActivity implements OnClickListener {

    RestaurantList restaurantList = new RestaurantList();

    //fields
    private TextView name;
    private ImageView icon;
    private TextView hours;
    private TextView mins_away;
    private TextView address;
    private TextView url;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        //connecting to xml code
        this.name = findViewById(R.id.name_field);
        this.address = findViewById(R.id.address_field);
        this.hours = findViewById(R.id.hours_field);
        this.mins_away = findViewById(R.id.mins_away_field);
        this.url = findViewById(R.id.url_field);
        this.icon = findViewById(R.id.icon_field);

        backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(this);

        GlobalVariables g = (GlobalVariables) getApplication();

        // if restaurant is selected, set the detail info
        for (Restaurant res : restaurantList.getRestaurants()) {
            if (res.getName().equals(g.getValue())) {
                setDetails(res);
            }
        }
    }

    public void setDetails(Restaurant res) {
        this.name.setText(res.getName());
        this.address.setText(res.getAddress());
        this.hours.setText(res.getHours());
        if (res.getUrl().equals("")) {
            this.url.setVisibility(View.GONE);
        } else this.url.setText(res.getUrl());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backbutton:
                this.startActivity(new Intent(DetailActivity.this, MapsActivity.class));
                this.finish();
        }
    }
}
