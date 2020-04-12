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

//        String activeRestaurant = g.getValue().toLowerCase();
//        if (activeRestaurant.equals("rebecca's cafe")) {
//            setRebeccas();
//        } else if (activeRestaurant.equals("international village")) {
//            setIV();
//        } else if (activeRestaurant.equals("chicken lou's")) {
//            setChickenLous();
//        }
    }

    public void setDetails(Restaurant res) {
        this.name.setText(res.getName());
        this.address.setText(res.getAddress());
        this.hours.setText(res.getHours());
        if (res.getUrl().equals("")) {
            this.url.setVisibility(View.GONE);
        } else this.url.setText(res.getUrl());
    }

    //void methods to populate data needed by the view
    //canned data, will change for final implementation

    public void setRebeccas() {
        this.name.setText("Rebecca's Cafe");
        this.icon.setImageResource(R.drawable.dollars_and_swipes_large);
        this.hours.setText("8:00 am - 4:00 pm");
        this.mins_away.setText("4 minutes away.");
        this.address.setText("Churchill Hall, 380 Huntington Ave, Boston, MA 02115");
        this.url.setText("https://rebeccascafe.com/");
    }

    public void setIV() {
        this.name.setText("International Village");
        this.icon.setImageResource(R.drawable.husky_swipes_large);
        this.hours.setText("7:00 am - 10:00 pm");
        this.mins_away.setText("12 minutes away.");
        this.address.setText("1155 Tremont St, Boston, MA 02120");
        this.url.setText("https://www.northeastern.edu/housing/residences/international-village/");
    }

    public void setChickenLous() {
        this.name.setText("Chicken Lou's");
        this.icon.setImageResource(R.drawable.husky_dollars_large);
        this.hours.setText("7:30 am - 2:00 pm");
        this.mins_away.setText("2 minutes away.");
        this.address.setText("50 Forsyth St, Boston, MA 02115");
        this.url.setText("chickenlous.com");
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
