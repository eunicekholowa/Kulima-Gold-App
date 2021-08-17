package com.example.kulimagoldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SoyapiecesActivity extends AppCompatActivity {
    private TextView fadd6;

    public SoyapiecesActivity (){

    }
    public SoyapiecesActivity(TextView fadd6) {
        this.fadd6 = fadd6;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soyapieces);
        fadd6 = (TextView) findViewById(R.id.fadd6);

        fadd6.setOnClickListener(v-> {
            startActivity(new Intent(this, ShowDetailsActivity.class));
        });
    }
}