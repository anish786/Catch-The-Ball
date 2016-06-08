package com.saas.catchtheball;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Anish Ali on 6/5/2016.
 */
public class StoreActivity extends AppCompatActivity {

    public ImageButton ball0;
    public ImageButton ball1;
    public ImageButton ball2;
    public ImageButton ball3;
    public ImageButton ball4;
    public ImageButton ball5;
    public ImageButton ball6;
    public ImageButton ball7;
    public ImageButton ball8;
    public static int selected;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ball0 = (ImageButton) findViewById(R.id.ball0);
        ball1 = (ImageButton) findViewById(R.id.ball1);
        ball2 = (ImageButton) findViewById(R.id.ball2);
        ball3 = (ImageButton) findViewById(R.id.ball3);
        ball4 = (ImageButton) findViewById(R.id.ball4);
        ball5 = (ImageButton) findViewById(R.id.ball5);
        ball6 = (ImageButton) findViewById(R.id.ball6);
        ball7 = (ImageButton) findViewById(R.id.ball7);
        ball8 = (ImageButton) findViewById(R.id.ball8);

        ball1.setEnabled(false);

        selected = mSharedPreferences.getInt("selected", 0);

        ball0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 0;
            }
        });

        ball1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 1;
            }
        });

        ball2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 2;
            }
        });

        ball3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 3;
            }
        });

        ball4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 4;
            }
        });

        ball5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 5;
            }
        });

        ball6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 6;
            }
        });

        ball7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 7;
            }
        });

        ball8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 8;
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        mSharedPreferences.edit().putInt("selected", selected).commit();
    }
}
