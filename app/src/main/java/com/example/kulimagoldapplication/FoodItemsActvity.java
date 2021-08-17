package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodItemsActvity extends AppCompatActivity {
    private TextView fadd1;
    private TextView fadd2;
    private TextView fadd3;
    private TextView fadd4;
    private TextView fadd5;

    public FoodItemsActvity(){

    }

    public FoodItemsActvity(TextView fadd1, TextView fadd2, TextView fadd3, TextView fadd4,TextView fadd5) {
        this.fadd1 = fadd1;
        this.fadd2 = fadd2;
        this.fadd3 = fadd3;
        this.fadd4 = fadd4;
        this.fadd5 = fadd5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_items_actvity);
        fadd1=(TextView)findViewById(R.id.fadd1);
        fadd2=(TextView)findViewById(R.id.fadd2);
        fadd3=(TextView)findViewById(R.id.fadd3);
        fadd4=(TextView)findViewById(R.id.fadd4);
        fadd5=(TextView) findViewById(R.id.fadd5);

        fadd1.setOnClickListener(v-> {
            startActivity(new Intent(this, SoyapiecesActivity.class));
        });
        fadd2.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        fadd3.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        fadd4.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        fadd5.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
    }

}