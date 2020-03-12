package com.paulleukefeld.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //Date textView
    TextView dateTextView;
    //Breakfast menu textView
    TextView breakFastTextView;
    //Lunch menu textView
    TextView lunchTextView;
    //Dinner menu textView
    TextView dinnerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_menu);

        //Connecting the layout with the textViews
        dateTextView = findViewById(R.id.textViewDate);
        breakFastTextView = findViewById(R.id.textViewBreakfast);
        lunchTextView = findViewById(R.id.textViewLunch);
        dinnerTextView = findViewById(R.id.textViewDinner);

        //Getting the current menu items
        getMenuItems();

        //Button that switches to the set menu activity
        Button buttonSetMenu = findViewById(R.id.buttonChangeMenu);

        buttonSetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    //Method that gets the current menu items
    public void getMenuItems(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        dateTextView.setText("for: " + formatter.format(date));
        breakFastTextView.setText("Breakfast: " + prefs.getString("breakfast", ""));
        lunchTextView.setText("Lunch: "+ prefs.getString("lunch", ""));
        dinnerTextView.setText("Dinner: "+ prefs.getString("dinner", ""));
    }
}
