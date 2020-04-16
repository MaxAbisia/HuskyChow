package com.example.huskychow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
    private Button navButton;
    private Button shareButton;

    GlobalVariables g;


    String resAddress = "";
    String resName = "";

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

        navButton = findViewById(R.id.navigateButton);
        navButton.setOnClickListener(this);

        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(this);

        g = (GlobalVariables) getApplication();

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

        switch (res.getCurrencyType()) {
            case HUSKY_DOLLARS:
                icon.setImageResource(R.drawable.husky_dollars);
                break;
            case MEAL_SWIPES:
                icon.setImageResource(R.drawable.husky_swipe);
                break;
            case BOTH:
                icon.setImageResource(R.drawable.dollars_and_swipes);
                break;
            default:
                break;
        }

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
                break;

            case R.id.navigateButton:
                goMaps();
                break;

            case R.id.shareButton:
                goShare();
                break;
        }
    }


    public void goMaps() {

        for (Restaurant res : restaurantList.getRestaurants()) {
            if (g.getValue().equals(res.getName())) {
                resAddress = res.getAddress();
                resName = res.getName();
            }
        }

        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + resName + resAddress + " Boston, MA");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void goShare() {

        for (Restaurant res : restaurantList.getRestaurants()) {
            if (g.getValue().equals(res.getName())) {
                resAddress = res.getAddress();
                resName = res.getName();
            }
        }

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here's the address for " + resName + ":\n" + resAddress;
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
