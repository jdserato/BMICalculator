package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculateListenerMethod();
    }

    public void calculateListenerMethod() {
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // GET weight
                EditText etWeight = (EditText) findViewById(R.id.etWeight);
                String str_weight = etWeight.getText().toString();
                double weight = Double.parseDouble(str_weight);

                // GET height
                EditText etHeight = (EditText) findViewById(R.id.etHeight);
                String str_height = etHeight.getText().toString();
                double height = Double.parseDouble(str_height);

                // CALCULATE BMI
                double BMI = weight / Math.pow(height, 2);
                EditText etBMI = (EditText) findViewById(R.id.etBMI);
                etBMI.setText(Double.toString(BMI));

                String BMI_Cat;
                if (BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if (BMI < 25)
                    BMI_Cat = "Normal";
                else if (BMI < 30)
                    BMI_Cat = "Overweight";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                else if (BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";

                EditText etClass = (EditText) findViewById(R.id.etClass);
                etClass.setText(BMI_Cat);
            }
        });
    }
}