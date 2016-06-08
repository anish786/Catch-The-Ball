package com.saas.catchtheball;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import org.w3c.dom.Text;

/**
 * Created by Anish Ali on 6/2/2016.
 */
public class GameOver extends AppCompatActivity {

    private Button retry;
    private Button backToMenu;
    private TextView score;
    private TextView highScore;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        System.out.println("Count: " + MainActivity.count);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8415855867616929/1793402299");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
//                GameActivity ga = new GameActivity();
//                ga.BeginPlayingGame();
            }
        });

        requestNewInterstitial();

        retry = (Button) findViewById(R.id.retry);
        backToMenu = (Button) findViewById(R.id.backtomenu);
        score = (TextView) findViewById(R.id.ScoreText);
        highScore = (TextView) findViewById(R.id.HighScoreText);
        GameActivity ga = new GameActivity();
        score.setText(new String(String.valueOf(ga.getScore())));
        highScore.setText(new String(String.valueOf(ga.getHighScore())));

        retry.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(MainActivity.count % 4 == 0){
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        MainActivity.count = MainActivity.count + 1;
                    }
                } else {
                    Intent intent = new Intent(GameOver.this, GameActivity.class);
                    startActivity(intent);
                }
            }
        });

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("E7C584FC96C075610AA859CC0E734936")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
