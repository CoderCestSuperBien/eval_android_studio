package com.example.eval_android_studio_joris;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoCalculatrice(View v){
        Intent intent = new Intent(this,CalculatriceActivity.class);
        startActivity(intent);
    }

    public void gotoTva(View v){
        Intent intent = new Intent(this,TvaActivity.class);
        startActivity(intent);
    }

    public void gotoColor(View v){
        Intent intent = new Intent(this, ColorActivity.class);
        startActivity(intent);
    }
}
