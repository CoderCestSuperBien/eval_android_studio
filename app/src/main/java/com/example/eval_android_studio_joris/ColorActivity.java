package com.example.eval_android_studio_joris;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        SeekBar r = findViewById(R.id.seekBar4);
        SeekBar g = findViewById(R.id.seekBar5);
        SeekBar b = findViewById(R.id.seekBar6);
        SeekBar h = findViewById(R.id.seekBar9);
        SeekBar s = findViewById(R.id.seekBar10);
        SeekBar v = findViewById(R.id.seekBar12);

        int[] rgb = {0,0,0};
        float[] hsv = {0f,0f,0f};
        View ecran = findViewById(R.id.ecranCouleur);
        ecran.setBackgroundColor(Color.parseColor(String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2])));

        onChangePutColor(r,rgb,hsv,ecran);
        onChangePutColor(g,rgb,hsv,ecran);
        onChangePutColor(b,rgb,hsv,ecran);
        onChangePutColor(h,rgb,hsv,ecran);
        onChangePutColor(s,rgb,hsv,ecran);
        onChangePutColor(v,rgb,hsv,ecran);


    }


    public void onChangePutColor (SeekBar seekBar , final int[] rgb , final float[] hsv , final View ecran){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                System.out.println(seekBar.getTag());
                if (seekBar.getTag().equals("r"))
                {
                    rgb[0] = seekBar.getProgress();
                    ecran.setBackgroundColor(Color.parseColor(String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2])));
                }
                else if(seekBar.getTag().equals("g"))
                {
                    rgb[1] = seekBar.getProgress();
                    ecran.setBackgroundColor(Color.parseColor(String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2])));
                }
                else if (seekBar.getTag().equals("b"))
                {
                    rgb[2] = seekBar.getProgress();
                    ecran.setBackgroundColor(Color.parseColor(String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2])));
                }
                else if (seekBar.getTag().equals("h"))
                {
                    hsv[0] = (float) seekBar.getProgress();
                    ecran.setBackgroundColor(Color.HSVToColor(hsv));
                }
                else if (seekBar.getTag().equals("s"))
                {
                    hsv[1] = ((float) seekBar.getProgress())/100;
                    ecran.setBackgroundColor(Color.HSVToColor(hsv));
                }
                else if (seekBar.getTag().equals("v"))
                {
                    hsv[2] = ((float) seekBar.getProgress())/100;
                    ecran.setBackgroundColor(Color.HSVToColor(hsv));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }




}
