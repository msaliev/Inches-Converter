package com.mysaliev.inchesconverter;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etInches;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        btnConvert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String inchesString = etInches.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input a value!", Toast.LENGTH_SHORT).show();
                } else {
                    double result = calculateHeight(inchesString);
                    displayFinalResult(result);
                }

            }
        });
    }


    private void findViews() {
        etInches = findViewById(R.id.etInches);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);
    }


    private double calculateHeight(String inchesString) {
        int inchesInteger = Integer.parseInt(inchesString);
        return inchesInteger * 0.0254;
    }

    private void displayFinalResult(double result) {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultString = myFormatter.format(result);
        tvResult.setText(resultString + " meters");
    }


}