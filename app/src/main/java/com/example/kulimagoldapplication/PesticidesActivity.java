package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PesticidesActivity extends AppCompatActivity {
        private TextView padd1;
        private TextView padd2;
        private TextView padd3;
        private TextView padd4;

      public PesticidesActivity(){

      }

    public PesticidesActivity(TextView padd1, TextView padd2, TextView padd3, TextView padd4) {
        this.padd1 = padd1;
        this.padd2 = padd2;
        this.padd3 = padd3;
        this.padd4 = padd4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesticides);
        padd1=(TextView)findViewById(R.id.padd1);
        padd2=(TextView)findViewById(R.id.padd2);
        padd3=(TextView)findViewById(R.id.padd3);
        padd4=(TextView)findViewById(R.id.padd4);

        padd1.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        padd2.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        padd3.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        padd4.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
    }
}