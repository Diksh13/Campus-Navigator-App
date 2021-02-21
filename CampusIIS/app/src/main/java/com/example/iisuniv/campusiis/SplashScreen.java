package com.example.iisuniv.campusiis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    //Splash Screen Timer
    private static int Splash_Duration = 2000; //2 sec
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent i = new Intent(SplashScreen.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        }, Splash_Duration);
    }
}
