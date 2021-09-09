package com.example.project2redo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }
    //Goes to the Sign in page
    public void callBackFunctionButtonSignInPage(View view) {
        Intent myIntent = new Intent(SignUp.this, SignIn.class);
        startActivity(myIntent);
    }
    //Attempts to create a new user storing the data in shared preferences
    public void callBackFunctionButtonSignUp(View view) {
        SharedPreferences myPrefs = getSharedPreferences("UserDetails", MODE_PRIVATE);
        EditText etName = findViewById(R.id.etNewName);
        EditText etPass = findViewById(R.id.etNewPassword);
        EditText etConPass = findViewById(R.id.etConfirmPassword);
        EditText etUsrName = findViewById(R.id.etNewUsername);


        Intent myIntent = new Intent(SignUp.this, SignIn.class);

        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("name", etName.getText().toString().trim());
        editor.putString("username", etUsrName.getText().toString().trim());

            if (etConPass.getText().toString().equals(etPass.getText().toString())) { //checks if the passwords match to then switch the activity

                editor.putString("password", etPass.getText().toString().trim());
                Toast.makeText(getApplicationContext(), "Profile created! Hi " +etName.getText().toString() + "!", Toast.LENGTH_SHORT).show(); //Notifies the user
                editor.apply();
                startActivity(myIntent);

            } else {
                Toast.makeText(getApplicationContext(), "Passwords do not match.", Toast.LENGTH_SHORT).show(); //if the passwords do not match the user is notified
                Log.i("Pass", etPass.getText().toString());
                Log.i("ConPass", etConPass.getText().toString());
            }


    }
}