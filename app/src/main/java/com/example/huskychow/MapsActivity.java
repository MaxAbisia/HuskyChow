package com.example.huskychow;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    // BUTTONS
    private Button menuButton;
    private ImageButton cardButton;
    private ImageButton dollarButton;

    Marker rebeccaMarker;
    Marker ivMarker;
    Marker chickenLousMarker;

    LinearLayout summaryView;
    TextView summaryTitle;
    TextView summaryHours;
    TextView summaryDistance;
    ImageView summaryCurrency;
    Button summaryNavButton;
    Button summaryDetailsButton;

    LatLng rebeccasLocation = new LatLng(42.338975, -71.088670);
    LatLng ivLocation = new LatLng(42.335376, -71.089357);
    LatLng chickenLousLocation = new LatLng(42.339279, -71.090179);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //buttons
        menuButton = findViewById(R.id.menubutton);
        menuButton.setOnClickListener(this);

        cardButton = findViewById(R.id.cardbutton);
        cardButton.setOnClickListener(this);

        dollarButton = findViewById(R.id.dollarbutton);
        dollarButton.setOnClickListener(this);

        // Summary View
        summaryView = findViewById(R.id.summary_view);

        summaryNavButton = findViewById(R.id.summaryNav);
        summaryNavButton.setOnClickListener(this);

        summaryDetailsButton = findViewById(R.id.summaryDetails);
        summaryDetailsButton.setOnClickListener(this);

        summaryTitle = findViewById(R.id.summaryTitle);

        summaryHours = findViewById(R.id.summaryHours);

        summaryDistance = findViewById(R.id.summaryDistance);

        summaryCurrency = findViewById(R.id.summaryCurrency);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menubutton:
                break;

            case R.id.cardbutton:
                cardButton.setActivated(!cardButton.isActivated());
                break;

            case R.id.dollarbutton:
                dollarButton.setActivated(!dollarButton.isActivated());
                break;

            case R.id.summaryDetails:
                startActivity(new Intent(MapsActivity.this, DetailActivity.class));
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.clear();

        BitmapDescriptor huskyDollarIcon =
                BitmapDescriptorFactory.fromResource(R.drawable.huskydollar);
        BitmapDescriptor swipeIcon =
                BitmapDescriptorFactory.fromResource(R.drawable.swipe);
        BitmapDescriptor swipeAndDollarIcon =
                BitmapDescriptorFactory.fromResource(R.drawable.swipeanddollar);

        // Add a marker in Rebecca's
        rebeccaMarker =
                mMap.addMarker(new MarkerOptions()
                        .position(rebeccasLocation)
                        .title("Rebecca's Cafe")
                        .icon(swipeAndDollarIcon));

        // Add a marker in IV
        ivMarker =
                mMap.addMarker(new MarkerOptions()
                        .position(ivLocation)
                        .title("International Village")
                        .icon(swipeIcon));

        // Add a marker in Chicken Lou's
        chickenLousMarker =
                mMap.addMarker(new MarkerOptions()
                        .position(chickenLousLocation)
                        .title("Chicken Lou's")
                        .icon(huskyDollarIcon));

        // move map and set zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chickenLousLocation));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {

                if (marker.equals(rebeccaMarker)) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(rebeccasLocation));
                    setRebeccaSummary();
                    summaryView.setVisibility(View.VISIBLE);
                    return true;
                }
                if (marker.equals(ivMarker)) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ivLocation));
                    setIVSummary();
                    summaryView.setVisibility(View.VISIBLE);
                    return true;
                }
                if (marker.equals(chickenLousMarker)) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(chickenLousLocation));
                    setChickenLousSummary();
                    summaryView.setVisibility(View.VISIBLE);
                    return true;
                }
                return false;
            }
        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                summaryView.setVisibility(View.GONE);
            }
        });
    }

    public void setRebeccaSummary() {
        summaryTitle.setText("Rebecca's Cafe");
        summaryHours.setText("8:00 am – 4:00 pm");
        summaryDistance.setText("4 minutes away");

        summaryCurrency.setImageResource(R.drawable.swipeanddollar);
    }

    public void setIVSummary() {
        summaryTitle.setText("International Village");
        summaryHours.setText("7:00 am – 9:00 pm");
        summaryDistance.setText("12 minutes away");

        summaryCurrency.setImageResource(R.drawable.swipe);
    }

    public void setChickenLousSummary() {
        summaryTitle.setText("Chicken Lou's");
        summaryHours.setText("7:30 am - 2:00 pm");
        summaryDistance.setText("2 minutes away");

        summaryCurrency.setImageResource(R.drawable.huskydollar);
    }
}