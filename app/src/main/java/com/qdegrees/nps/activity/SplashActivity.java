package com.qdegrees.nps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.qdegrees.nps.R;
import com.qdegrees.nps.local.SharedPrefManager;

public class SplashActivity extends AppCompatActivity {

    // Splash Screen Duration
     int splashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        // Splash Screen Show time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (SharedPrefManager.getInstance(SplashActivity.this).isLoggedIn()) {

                    // go to Other Activity After Thread Time
                    startActivity(new Intent(SplashActivity.this, Main_MenuActivity.class));
                    finish();
                }else {
                    // go to Other Activity After Thread Time
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }

            }
        }, splashTime);
    }
}
