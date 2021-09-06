package com.example.kulimagoldapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kulimagoldapplication.Databases.DBHelper;
import com.example.kulimagoldapplication.R;

public class CustomerSigninActivity extends AppCompatActivity {

    private TextView bRegister;
    private Button bLogin;
    private EditText Email;
    private EditText Password;
    DBHelper MyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signin);

        bRegister = (TextView) findViewById(R.id.bRegister);
        bLogin = (Button) findViewById(R.id.bLogin);
        Email = (EditText) findViewById(R.id.Email);
        Password= (EditText) findViewById(R.id.Password);
        MyDB =new DBHelper(this);

//
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerSigninActivity.this, CustomerRegisterActivity.class);
                startActivity(intent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Email.getText().toString();
                String pass = Password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(CustomerSigninActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkuserpass= MyDB.checkEmailPassword(user, pass);
                    if(checkuserpass == true) {
                        Toast.makeText(CustomerSigninActivity.this, "Sign in  Successifully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(CustomerSigninActivity.this, "Invalid credentials else register", Toast.LENGTH_SHORT).show();
                    }
                }



            }


        });

    }
}