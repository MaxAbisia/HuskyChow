package com.example.huskychow;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class DetailActivity extends FragmentActivity {

    //fields
    private TextView name;
    private ImageView icon;
    private TextView hours;
    private TextView mins_away;
    private TextView address;
    private TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        //connecting to xml code
        this.name = (TextView) findViewById(R.id.name_field);
        this.icon = (ImageView) findViewById(R.id.icon_field);
        this.hours = (TextView) findViewById(R.id.hours_field);
        this.mins_away = (TextView) findViewById(R.id.mins_away_field);
        this.address = (TextView) findViewById(R.id.address_field);
        this.url = (TextView) findViewById(R.id.url_field);

        //need to set data
        if (variable.toLowerCase().equals("rebecca's cafe")) {
            setRebeccas();
        } else if (variable.toLowerCase().equals("iv")) {
            setIV();
        } else {
            setChickenLous();
        }
    }

    //void methods to populate data needed by the view
    //canned data, will change for final implementation

    public void setRebeccas() {
        this.name.setText("Rebecca's Cafe");
        this.icon.setImageResource(R.drawable.swipeanddollar);
        this.hours.setText("8:00 am - 4:00 pm");
        this.mins_away.setText("4 minutes away.");
        this.address.setText("Churchill Hall, 380 Huntington Ave, Boston, MA 02115");
        this.url.setText("https://rebeccascafe.com/");
    }

    public void setIV() {
        this.name.setText("International Village");
        this.icon.setImageResource(R.drawable.swipe);
        this.hours.setText("7:00 am - 10:00 pm");
        this.mins_away.setText("12 minutes away.");
        this.address.setText("1155 Tremont St, Boston, MA 02120");
        this.url.setText("https://www.northeastern.edu/housing/residences/international-village/");
    }

    public void setChickenLous() {
        this.name.setText("Chicken Lou's");
        this.icon.setImageResource(R.drawable.huskydollar);
        this.hours.setText("7:30 am - 2:00 pm");
        this.mins_away.setText("2 minutes away.");
        this.address.setText("50 Forsyth St, Boston, MA 02115");
        this.url.setText("chickenlous.com");
    }
}
