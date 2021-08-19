package com.example.kulimagoldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ItemsSelectedActivity extends AppCompatActivity {
    private TextView checkout;

    public ItemsSelectedActivity(){

    }
    public ItemsSelectedActivity(TextView checkout) {
        this.checkout = checkout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        checkout = (TextView) findViewById(R.id.checkout);
        checkout.setOnClickListener(v-> {
            startActivity(new Intent(this, OrderActivity.class));
        });
    }
}