package com.example.kulimagoldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetailsActivity extends AppCompatActivity {

        private TextView addToCartBtn;
        public ShowDetailsActivity(){

        }


    public ShowDetailsActivity(TextView addToCartBtn) {
        this.addToCartBtn = addToCartBtn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        addToCartBtn=(TextView) findViewById(R.id.addToCartBtn);
        addToCartBtn.setOnClickListener(v-> {
            startActivity(new Intent(this, ItemsSelectedActivity.class));
        });
        }
}