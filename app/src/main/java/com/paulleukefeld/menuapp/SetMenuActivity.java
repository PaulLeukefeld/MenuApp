package com.paulleukefeld.menuapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SetMenuActivity extends AppCompatActivity {

    //EditText for the menu items
    EditText editTextBreakfast;
    EditText editTextLunch;
    EditText editTextDinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_menu);

        //Button that changes to the display menu activity
        Button buttonUpdateMenu = findViewById(R.id.buttonUpdateMenu);

        //Connecting the editText with the layout
        editTextBreakfast = findViewById(R.id.editTextBreakfast);
        editTextLunch = findViewById(R.id.editTextLunch);
        editTextDinner = findViewById(R.id.editTextDinner);

        buttonUpdateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMenuItems();
                Intent intent = new Intent(SetMenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //Method that saves all menu items to shared preferences
    public void saveMenuItems(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("breakfast", editTextBreakfast.getText().toString());
        editor.putString("lunch", editTextLunch.getText().toString());
        editor.putString("dinner", editTextDinner.getText().toString());
        editor.apply();
    }

}
