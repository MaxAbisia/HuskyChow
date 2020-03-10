package com.example.huskychow;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class DetailActivity extends FragmentActivity implements View.OnClickListener {

    //fields
    TextView name;
    ImageView icon;
    TextView hours;
    TextView address;
    TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        //connecting to xml code
        this.name = (TextView) findViewById(R.id.name_field);
        this.icon = (ImageView) findViewById(R.id.icon);
        this.hours = (TextView) findViewById(R.id.hours_field);
        this.address = (TextView) findViewById(R.id.address_field);
        this.url = (TextView) findViewById(R.id.url_field);

        //need to set data



    }

    @Override
    public void onClick(View v) {

    }




}
