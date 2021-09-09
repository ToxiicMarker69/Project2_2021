package com.example.project2redo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
    }
    public void callbackFunctionButtonReturn(View view) { //.returns to the sign up activity

        Intent myIntent = new Intent(SignIn.this, SignUp.class);
        startActivity(myIntent);
    }


    public void callBackFunctionButtonSignIn(View view) { //acesses the shared preferences to get the username and password previously saved
        Intent myIntent = new Intent(SignIn.this, DisplayInfo.class);

        SharedPreferences myPrefs = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String username = myPrefs.getString("username", "");
        String password = myPrefs.getString("password", "");

        EditText usrEnter = findViewById(R.id.etEnterUsr);
        EditText passEnter = findViewById(R.id.etEnterPass);

        if ((username.equals(usrEnter.getText().toString())) && (password.equals(passEnter.getText().toString()))) { //if the username and password match what is saved then the display info activity to shown
            Toast.makeText(getApplicationContext(), "Logging in!", Toast.LENGTH_SHORT).show(); //user is notified that it worked
            Log.i("UserEntered", usrEnter.getText().toString());
            Log.i("PassEntered", passEnter.getText().toString());
            Log.i("Correct Pass", "You entered: " + username + " " +  password +".");
            startActivity(myIntent);

        }else{
            Toast.makeText(getApplicationContext(), "Username and/or password incorrect..", Toast.LENGTH_LONG).show(); //user is notified that the usrname/password is wrong
            Log.i("UserEntered", usrEnter.getText().toString());
            Log.i("PassEntered", passEnter.getText().toString());
            Log.i("Correct Pass", "You entered: " + username + " " +  password +".");

        }
    }
}