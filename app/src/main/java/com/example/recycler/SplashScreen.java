package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

        private final int TIME=4000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);


            getSupportActionBar().hide();

            new Handler().postDelayed(()->{
                startActivity(new Intent(getApplicationContext(),TeamActivity.class));
                finish();
            },TIME);

        }
    }

