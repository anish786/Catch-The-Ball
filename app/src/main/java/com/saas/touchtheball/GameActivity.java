package com.saas.touchtheball;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Anish Ali on 6/1/2016.
 */
public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private static int score;
    private static int hs;
    //private ImageButton ball;
    private TextView scoreText;
    private int width;
    private int height;
    private Random random;
    private AnimatorSet set;
    private ObjectAnimator animation1;
    private ObjectAnimator animation2;
    private RelativeLayout layout;
    DisplayMetrics displaymetrics;
    private TextView goScore;
    private TextView hScore;
    private SharedPreferences mSharedPreferences;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mSharedPreferences = getPreferences(MODE_PRIVATE);
        MainActivity.ball = (ImageButton) findViewById(R.id.Ball);
        //Toast.makeText(getApplicationContext(), "Tap ball to score", Toast.LENGTH_LONG).show();

        //changing the ball
        StoreActivity sa = new StoreActivity();
        //MainActivity.ball.setBackgroundResource(R.drawable.ball0);
        MainActivity.count = MainActivity.count + 1;
        if(sa.selected == 0){
            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
        }
        if(sa.selected == 1){
            MainActivity.ball.setBackgroundResource(R.drawable.ball1);
        }
        if(sa.selected == 2){
            MainActivity.ball.setBackgroundResource(R.drawable.ball2);
        }
        if(sa.selected == 3){
            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
        }
//        else if(sa.selected == 4){
//            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
//        }
//        else if(sa.selected == 5){
//            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
//        }
//        else if(sa.selected == 6){
//            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
//        }
//        else if(sa.selected == 7){
//            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
//        }
//        else {
//            MainActivity.ball.setBackgroundResource(R.drawable.ball0);
//        }


        scoreText = (TextView) findViewById(R.id.ScoreText);
        layout = (RelativeLayout) findViewById(R.id.relativeLayout);
        goScore = (TextView) findViewById(R.id.ScoreText);
        hScore = (TextView) findViewById(R.id.HighScoreText);
        score = 0;
        hs = mSharedPreferences.getInt("High Score", 0);
        MainActivity.totalScore = mSharedPreferences.getInt("Total Score", 0);
        System.out.println("HS: " + hs);
        System.out.println("Total Score In GAME: " + MainActivity.totalScore);


        scoreText.setText("Tap ball");
        displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        width = displaymetrics.widthPixels;
        height = displaymetrics.heightPixels;
        random = new Random();
        scoreText.setAlpha(0.3f);

        MainActivity.ball.setOnClickListener((View.OnClickListener) this);


        set = createAnimation();
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(final Animator animation) {
                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setHighScore();
                        setTotal();
                        animation.cancel();
                        Intent intent = new Intent(GameActivity.this, GameOver.class);
                        startActivity(intent);
                    }
                });
                BeginPlayingGame();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void playTouchSound() {
        AudioManager audioManager =
                (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.playSoundEffect(SoundEffectConstants.CLICK);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSharedPreferences.edit().putInt("High Score", hs).commit();
        mSharedPreferences.edit().putInt("Total Score", MainActivity.totalScore).commit();
    }
    public void setHighScore(){
        if(hs < score){
            hs = score;
        }
    }

    public void setTotal(){
        MainActivity ma = new MainActivity();
        ma.setTotalScore(score);
        //mSharedPreferences.edit().putInt("Total Score", ma.getTotalScore()).commit();
    }
    public int getScore(){
        return score;
    }

    public int getHighScore(){
        return hs;
    }
    @Override
    public void onClick(View v){
        playTouchSound();
        score = score + 1;
        scoreText.setText(new String(String.valueOf(score)));
    }

    private AnimatorSet createAnimation() {
        int nextX = random.nextInt(width);
        int nextY = random.nextInt(height);

        animation1 = ObjectAnimator.ofFloat(MainActivity.ball, "x", nextX);
        animation1.setDuration(900);
        animation2 = ObjectAnimator.ofFloat(MainActivity.ball, "y", nextY);
        animation2.setDuration(900);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animation1, animation2);
        return set;
    }

    public void BeginPlayingGame(){
        int nextX = random.nextInt(width);
        int nextY = random.nextInt(height);




        while(nextX > width){
            nextX = random.nextInt(width);

        }
        while(nextY > height){
            nextY = random.nextInt(height);

        }
        //System.out.println("Width: " + width);
        //System.out.println("Height: " + height);
        //System.out.println("Next X: " + nextX);
        //System.out.println("Nexy Y: " + nextY);
        animation1 = ObjectAnimator.ofFloat(MainActivity.ball, "x", MainActivity.ball.getX(),
                nextX);

        if(score >= 0 && score <= 15) {
            animation1.setDuration(900);
            animation2 = ObjectAnimator.ofFloat(MainActivity.ball, "y", MainActivity.ball.getY(),
                    nextY);
            animation2.setDuration(900);
            set.playTogether(animation1, animation2);
            set.start();
        }
        else if(score > 15 && score <= 30) {
            animation1.setDuration(800);
            animation2 = ObjectAnimator.ofFloat(MainActivity.ball, "y", MainActivity.ball.getY(),
                    nextY);
            animation2.setDuration(800);
            set.playTogether(animation1, animation2);
            set.start();
        }
        else if(score > 30 && score <= 45) {
            animation1.setDuration(700);
            animation2 = ObjectAnimator.ofFloat(MainActivity.ball, "y", MainActivity.ball.getY(),
                    nextY);
            animation2.setDuration(700);
            set.playTogether(animation1, animation2);
            set.start();
        }
        else if(score > 45 && score <= 60) {
            animation1.setDuration(600);
            animation2 = ObjectAnimator.ofFloat(MainActivity.ball, "y", MainActivity.ball.getY(),
                    nextY);
            animation2.setDuration(600);
            set.playTogether(animation1, animation2);
            set.start();
        }
        else {
            animation1.setDuration(500);
            animation2 = ObjectAnimator.ofFloat(MainActivity.ball, "y", MainActivity.ball.getY(),
                    nextY);
            animation2.setDuration(500);
            set.playTogether(animation1, animation2);
            set.start();
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
