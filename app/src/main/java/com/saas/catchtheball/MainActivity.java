package com.saas.catchtheball;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button highScoreButton;
    private Button storeButton;
    AdView mAdView;
    public static ImageButton ball;
    private static int totalScore;
    private SharedPreferences mSharedPreferences;
    public static int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getPreferences(MODE_PRIVATE);
        getTotalScore();

        count = 0;
        ball = (ImageButton) findViewById(R.id.Ball);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8415855867616929/3739957091");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest.Builder adRequest = new AdRequest.Builder();
        adRequest.addTestDevice("E7C584FC96C075610AA859CC0E734936");


        mAdView.loadAd(adRequest.build());
        playButton = (Button) findViewById(R.id.playgame);
        highScoreButton = (Button) findViewById(R.id.highscore);
        storeButton = (Button) findViewById(R.id.store);


        playButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                count = count + 1;
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);

            }
        });

        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HighScore.class);
                startActivity(intent);
            }
        });

        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HighScore.class);
                startActivity(intent);
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        mAdView.resume();
    }

    @Override
    public void onPause(){
        mAdView.pause();
        super.onPause();
        mSharedPreferences.edit().putInt("Total Score", totalScore).commit();
    }

    @Override
    public void onDestroy(){
        mAdView.destroy();
        super.onDestroy();
    }

    public int getTotalScore(){
        return totalScore;
    }

    public void setTotalScore(int score){
        totalScore = totalScore + score;
    }
}
