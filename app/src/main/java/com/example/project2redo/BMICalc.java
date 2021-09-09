package com.example.project2redo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calc);
    }

    public void callbackFunctionButtonCalculate(View view) {
        EditText Weight = findViewById(R.id.etWeightE);
        EditText Height = findViewById(R.id.etHeightE);
        TextView BMIVal = findViewById(R.id.tvBMIVal);
        TextView Class = findViewById(R.id.tvBMIClass);

        try { //tries to use the inputs
            int val1 = Integer.parseInt(Weight.getText().toString()); //converts string to int
            int val2 = Integer.parseInt(Height.getText().toString());

            float item = 703 * val1 / (val2 * val2); //converts int to float and performs the calculation in inches and pounds
            String output = String.valueOf(item); //converts to string
            BMIVal.setText(output); //sets text for bmi
            if(item > 0 && item < 18.5){ //checks class
                Class.setText("Underweight"); //sets text for class
            }else if(item >= 18.5 && item < 25){
                Class.setText("Normal");
            }else if(item >= 25 && item < 30){
                Class.setText("Overweight");
            }else if(item >= 30){
                Class.setText("Obese");
            }
        } catch(NumberFormatException nfe) { //if the inputs do not work then it prints and sets text to error for BMIVal and N/A for Class
            System.out.println("Could not parse " + nfe);
            BMIVal.setText("ERROR");
            Class.setText("N/A");
        }
    }
}