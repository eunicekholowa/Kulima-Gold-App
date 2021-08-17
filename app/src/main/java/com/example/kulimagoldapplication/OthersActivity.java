package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OthersActivity extends AppCompatActivity {
    private TextView oadd1;
    private TextView oadd2;
    private TextView oadd3;
    private TextView oadd4;
    public OthersActivity(){

    }

    public OthersActivity(TextView oadd1, TextView oadd2, TextView oadd3, TextView oadd4) {
        this.oadd1 = oadd1;
        this.oadd2 = oadd2;
        this.oadd3 = oadd3;
        this.oadd4 = oadd4;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        oadd1=(TextView)findViewById(R.id.oadd1);
        oadd2=(TextView)findViewById(R.id.oadd2);
        oadd3=(TextView)findViewById(R.id.oadd3);
        oadd4=(TextView)findViewById(R.id.oadd4);

        oadd1.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        oadd2.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        oadd3.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });
        oadd4.setOnClickListener(v-> {
            startActivity(new Intent(this, OrangecidesActivity.class));
        });

    }
}