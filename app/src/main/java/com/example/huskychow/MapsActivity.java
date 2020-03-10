package com.example.huskychow;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    // BUTTONS
    private Button menuButton;
    private Button cardButton;
    private Button dollarButton;

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
        cardButton = findViewById(R.id.cardbutton);
        dollarButton = findViewById(R.id.dollarbutton);
        menuButton.setOnClickListener(this);
        cardButton.setOnClickListener(this);
        dollarButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menubutton:
//                startActivity(new Intent(MapsActivity.this, ScrollActivity.class));
                break;

            case R.id.cardbutton:
                cardButton.setActivated(!cardButton.isActivated());
                break;

            case R.id.dollarbutton:
                dollarButton.setActivated(!dollarButton.isActivated());
                break;
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

        // Add a marker in Hurtig and move the camera
        LatLng hurtig = new LatLng(42.339683, -71.086208);
        mMap.addMarker(new MarkerOptions().position(hurtig).title("Hurtig Hall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hurtig));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(18));

        // Add a marker in Hurtig and move the camera
        LatLng rebeccas = new LatLng(42.338975, -71.088670);
        mMap.addMarker(new MarkerOptions().position(rebeccas).title("Rebecca's Cafe"));
    }




}
