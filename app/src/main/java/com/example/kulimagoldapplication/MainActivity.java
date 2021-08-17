package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(v-> {
            startActivity(new Intent(this, FoodItemsActvity.class));
        });
//
        btn2.setOnClickListener(v-> {
            startActivity(new Intent(this,  SeedsActivity.class));
        });
//
        btn3.setOnClickListener(v-> {
            startActivity(new Intent(this, PesticidesActivity.class));
        });

//
        btn4.setOnClickListener(v-> {
            startActivity(new Intent(this, OthersActivity.class));
        });

    }
}