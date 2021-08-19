package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private Button blauncher;
    private Button bAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        blauncher =  findViewById(R.id.blauncher);
        bAdmin = findViewById(R.id.bAdmin);


        blauncher.setOnClickListener(v->{
            startActivity(new Intent(SplashActivity.this, CustomerSigninActivity.class));
        });

        bAdmin.setOnClickListener(v ->{
            startActivity(new Intent( SplashActivity.this, AdminSigninActivity.class));
        });
    }
}