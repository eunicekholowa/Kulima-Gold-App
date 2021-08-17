package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeedsActivity extends AppCompatActivity {
    private TextView sadd1;
    private TextView sadd2;
    private TextView sadd3;
    private TextView sadd4;

    public SeedsActivity(){

    }

    public SeedsActivity(TextView sadd1, TextView sadd2, TextView sadd3, TextView sadd4) {
        this.sadd1 = sadd1;
        this.sadd2 = sadd2;
        this.sadd3 = sadd3;
        this.sadd4 = sadd4;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeds);
        sadd1=(TextView)findViewById(R.id.sadd1);
        sadd2=(TextView)findViewById(R.id.sadd2);
        sadd3=(TextView)findViewById(R.id.sadd3);
        sadd4=(TextView)findViewById(R.id.sadd4);

        sadd1.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        sadd2.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        sadd3.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        sadd4.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
    }
}
