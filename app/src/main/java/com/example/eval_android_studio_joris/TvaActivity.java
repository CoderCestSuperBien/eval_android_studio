package com.example.eval_android_studio_joris;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tva);
    }

    private EditText input;
    public String inputString;
    public Float inputNumber;



    public void onCalculate(View v)
    {

        TextView output20 = findViewById(R.id.resultat20);
        TextView output10 = findViewById(R.id.resultat10);
        TextView output55 = findViewById(R.id.resultat55);
        input = (EditText) findViewById(R.id.inputTva);
        inputString = input.getText().toString();

        inputNumber = Float.parseFloat(inputString);

        String tva55 = Float.toString(inputNumber*1.055f);
        String tva10 = Float.toString(inputNumber*1.1f);
        String tva20 = Float.toString(inputNumber*1.2f);

        output20.setText(" "+tva20+" €");
        output10.setText(" "+tva10+" €");
        output55.setText(" "+tva55+" €");

    }


}
