package com.saas.catchtheball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Anish Ali on 6/2/2016.
 */
public class HighScore extends AppCompatActivity {

    private Button backToMenu;
    private TextView hsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        hsText = (TextView) findViewById(R.id.HighScoreText);
        backToMenu = (Button) findViewById(R.id.backtomenu);
        GameActivity ga = new GameActivity();
        hsText.setText(new String(String.valueOf(ga.getHighScore())));

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HighScore.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
