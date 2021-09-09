package com.example.project2redo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        SharedPreferences myPrefs = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String name = myPrefs.getString("name", ""); //gets the name of the user

        TextView Welcome = findViewById(R.id.tvWelcome);
        TextView Time = findViewById(R.id.tvTime);

        Welcome.setText("Welcome " + name + "!"); //welcomes user by name
        Date currentTime = Calendar.getInstance().getTime();

        int hourOfDay = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //take the hour of the day (millitary time)

        if(hourOfDay >= 0 && hourOfDay < 12){ //checks what time of the day it is and displays a greeting that is appropriate as well as the full calendar display on the line after
            Time.setText("Good Morning " + "\n" + currentTime);
        }else if(hourOfDay >=12 && hourOfDay <16){
            Time.setText("Good Afternoon" + "\n" + currentTime);
        }else if(hourOfDay >= 16 && hourOfDay < 21){
            Time.setText("Good Evening" + "\n" + currentTime);
        }else if(hourOfDay >= 21 && hourOfDay <24){
            Time.setText("Good Night" + "\n" + currentTime);
        }
        //Time.setText("Good " + "\n" + currentTime);


    }

    public void callbackFunctionButtonCalcPage(View view) { //goes to bmi calc activity
        Intent myIntent = new Intent(DisplayInfo.this, BMICalc.class);
        startActivity(myIntent);

    }
}