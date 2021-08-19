package com.example.kulimagoldapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminSigninActivity extends AppCompatActivity {
    private Button admin;
    private Button admin1;
    private EditText Email;
    private EditText Password;
    DBHelper MyDB;
   public AdminSigninActivity(){}

    public AdminSigninActivity(Button admin, Button admin1, EditText email, EditText password) {
        admin = admin;
        admin1 = admin1;
        Email = email;
        Password = password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signin);

        admin = (Button) findViewById(R.id.admin);
        admin1 = (Button) findViewById(R.id.admin1);
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        MyDB = new DBHelper(this);

        admin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSigninActivity.this, AdminMainActivity.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Email.getText().toString();
                String pass = Password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(AdminSigninActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = MyDB.checkEmailPassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(AdminSigninActivity.this, "Sign in  Successifully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AdminSigninActivity.this, "Invalid credentials else register", Toast.LENGTH_SHORT).show();
                    }
                }


            }


        });
    }
}