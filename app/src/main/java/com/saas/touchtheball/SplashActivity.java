package com.saas.touchtheball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Anish Ali on 6/13/2016.
 */
public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }

}
