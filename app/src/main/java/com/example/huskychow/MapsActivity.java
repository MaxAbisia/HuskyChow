package com.example.huskychow;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.huskychow.search.SearchActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener, View.OnTouchListener {

    private GoogleMap mMap;

    RestaurantList restaurantList;

    // BUTTONS
    private EditText searchBar;
    private ImageButton cardButton;
    private ImageButton dollarButton;

    LinearLayout summaryView;
    TextView summaryTitle;
    TextView summaryHours;
    TextView summaryDistance;
    ImageView summaryCurrency;
    Button summaryNavButton;
    Button summaryDetailsButton;

    LatLng chickenLousLocation = new LatLng(42.339279, -71.090179);

    private static final LatLng BOUND_CORNER_NW = new LatLng(42.354308, -71.123175);
    private static final LatLng BOUND_CORNER_SE = new LatLng(42.330500, -71.077609);
    private static final LatLngBounds RESTRICTED_BOUNDS_AREA = new LatLngBounds.Builder()
            .include(BOUND_CORNER_NW)
            .include(BOUND_CORNER_SE)
            .build();

    GlobalVariables g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        restaurantList = new RestaurantList();

        //buttons
        searchBar = findViewById(R.id.SearchBar);
        searchBar.setOnTouchListener(this);

        cardButton = findViewById(R.id.cardbutton);
        cardButton.setOnClickListener(this);

        dollarButton = findViewById(R.id.dollarbutton);
        dollarButton.setOnClickListener(this);

        // Summary View
        summaryView = findViewById(R.id.summary_view);
        summaryView.setOnClickListener(this);

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
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.SearchBar) {
            Intent intent = new Intent(MapsActivity.this, SearchActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardbutton:
                if (cardButton.isActivated()) {
                    showAll();
                } else {
                    showOnlySwipes();
                }
                dollarButton.setActivated(false);
                cardButton.setActivated(!cardButton.isActivated());
                break;

            case R.id.dollarbutton:
                if (dollarButton.isActivated()) {
                    showAll();
                } else {
                    showOnlyHuskyDollar();
                }
                cardButton.setActivated(false);
                dollarButton.setActivated(!dollarButton.isActivated());
                break;

            case R.id.summaryDetails:


            case R.id.summary_view:
                startActivity(new Intent(MapsActivity.this, DetailActivity.class));
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
        mMap.clear();

        mMap.setLatLngBoundsForCameraTarget(RESTRICTED_BOUNDS_AREA);
        mMap.setMinZoomPreference(14);
        mMap.setMaxZoomPreference(20);
        mMap.getUiSettings().setTiltGesturesEnabled(false);

        // removed google maps location pins
        // create a new json file here: https://mapstyle.withgoogle.com/
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.map_style));

        for (Restaurant res : restaurantList.getRestaurants()) {
            res.setMarker(
                    mMap.addMarker(new MarkerOptions()
                            .position(res.getLocation()))
            );
        }

        // move map and set zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chickenLousLocation));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        // if location already selected
        g = (GlobalVariables) getApplication();
        setIcons();

        // if there is a restaurant already active (from search) then focus on that restaurant
        for (Restaurant res : restaurantList.getRestaurants()) {
            if (res.getName().equals(g.getValue())) {
                focus(res.getLocation(), res.getName(), res.getHours(), res.getCurrencyType());
            }
        }


        mMap.setOnMarkerClickListener(
                new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(final Marker marker) {

                        clearSelectedMarker();

                        for (Restaurant res : restaurantList.getRestaurants()) {
                            if (res.getMarker().equals(marker)) {
                                g.setActiveRestaurant(res.getName());
                                focus(res.getLocation(), res.getName(), res.getHours(), res.getCurrencyType());
                                return true;
                            }
                        }
                        return false;
                    }
                });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                summaryView.setVisibility(View.GONE);
                clearSelectedMarker();
            }
        });
    }

    public void clearSelectedMarker() {
        g.setActiveRestaurant("");
        setSelectedIcon();
    }

    public void setIcons() {
        BitmapDescriptor huskyDollarIcon =
                BitmapDescriptorFactory.fromResource(R.drawable.husky_dollars);
        BitmapDescriptor swipeIcon =
                BitmapDescriptorFactory.fromResource(R.drawable.husky_swipe);
        BitmapDescriptor swipeAndDollarIcon =
                BitmapDescriptorFactory.fromResource(R.drawable.dollars_and_swipes);

        for (Restaurant res : restaurantList.getRestaurants()) {
            if (res.getCurrencyType().equals(CurrencyType.HUSKY_DOLLARS)) {
                res.getMarker().setIcon(huskyDollarIcon);
            }
            if (res.getCurrencyType().equals(CurrencyType.MEAL_SWIPES)) {
                res.getMarker().setIcon(swipeIcon);
            }
            if (res.getCurrencyType().equals(CurrencyType.BOTH)) {
                res.getMarker().setIcon(swipeAndDollarIcon);
            }
        }
    }

    public void setSelectedIcon() {
        if (g.getValue().equals("")) {
            setIcons();
            return;
        }

        BitmapDescriptor selectedIcon =
                BitmapDescriptorFactory.fromResource((R.drawable.paw_print));

        for (Restaurant res : restaurantList.getRestaurants()) {
            if (res.getName().equals(g.getValue())) {
                res.getMarker().setIcon(selectedIcon);
            }
        }
    }

    public void focus(LatLng location, String title, String hours, CurrencyType currencyType) {
        setSelectedIcon();
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(location));

        summaryTitle.setText(title);
        summaryHours.setText(hours);
        summaryDistance.setText("");

        if (currencyType == CurrencyType.BOTH) {
            summaryCurrency.setImageResource(R.drawable.dollars_and_swipes);
        } else if (currencyType == CurrencyType.HUSKY_DOLLARS) {
            summaryCurrency.setImageResource(R.drawable.husky_dollars);
        } else if (currencyType == CurrencyType.MEAL_SWIPES) {
            summaryCurrency.setImageResource(R.drawable.husky_swipe);
        }

        summaryView.setVisibility(View.VISIBLE);
    }

    public void showOnlyHuskyDollar() {
        for (Restaurant res : restaurantList.getRestaurants()) {
            if (res.getCurrencyType() == CurrencyType.MEAL_SWIPES) {
                res.getMarker().setVisible(false);
            } else {
                res.getMarker().setVisible(true);
            }
        }
    }

    public void showOnlySwipes() {
        for (Restaurant res : restaurantList.getRestaurants()) {
            if (res.getCurrencyType() == CurrencyType.HUSKY_DOLLARS) {
                res.getMarker().setVisible(false);
            } else {
                res.getMarker().setVisible(true);
            }
        }
    }

    public void showAll() {
        for (Restaurant res : restaurantList.getRestaurants()) {
            res.getMarker().setVisible(true);
        }
    }
}