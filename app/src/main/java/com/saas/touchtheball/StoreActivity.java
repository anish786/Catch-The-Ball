package com.saas.touchtheball;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
    public TextView text1;
    public TextView text2;
    public TextView text3;
    public TextView text4;
    public TextView text5;
    public TextView text6;
    public TextView text7;
    public TextView text8;

    public static int selected;
    private SharedPreferences mSharedPreferences;
    String inappid = "ball1";

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
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);
        text8 = (TextView) findViewById(R.id.text8);

        ball1.setEnabled(false);
        ball1.setAlpha(0.3f);
        ball2.setEnabled(false);
        ball2.setAlpha(0.3f);
        ball3.setEnabled(false);
        ball3.setAlpha(0.3f);
        ball4.setEnabled(false);
        ball4.setAlpha(0.3f);
        ball5.setEnabled(false);
        ball5.setAlpha(0.3f);
        ball6.setEnabled(false);
        ball6.setAlpha(0.3f);
        ball7.setEnabled(false);
        ball7.setAlpha(0.3f);
        ball8.setEnabled(false);
        ball8.setAlpha(0.3f);

        MainActivity ma = new MainActivity();
        if(ma.getTotalScore() >= 100){
            ball1.setEnabled(true);
            ball1.setAlpha(1.0f);
            text1.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 250){
            ball2.setEnabled(true);
            ball2.setAlpha(1.0f);
            text2.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 500){
            ball3.setEnabled(true);
            ball3.setAlpha(1.0f);
            text3.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 1000){
            ball4.setEnabled(true);
            ball4.setAlpha(1.0f);
            text4.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 2000){
            ball5.setEnabled(true);
            ball5.setAlpha(1.0f);
            text5.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 3500){
            ball6.setEnabled(true);
            ball6.setAlpha(1.0f);
            text6.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 5000){
            ball7.setEnabled(true);
            ball7.setAlpha(1.0f);
            text7.setVisibility(View.GONE);
        }

        if(ma.getTotalScore() >= 10000){
            ball8.setEnabled(true);
            ball8.setAlpha(1.0f);
            text8.setVisibility(View.GONE);
        }

        //selected = mSharedPreferences.getInt("selected", 0);
        System.out.println("Selected: " + selected);

        ball0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 0;
                //ball0.setColorFilter(R.drawable.image_border);
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
                //selected = 4;
            }
        });

        ball5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selected = 5;
            }
        });

        ball6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selected = 6;
            }
        });

        ball7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //selected = 7;
            }
        });

        ball8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //selected = 8;
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        //mSharedPreferences.edit().putInt("selected", selected).commit();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(StoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
