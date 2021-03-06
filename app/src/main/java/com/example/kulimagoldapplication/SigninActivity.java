package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {
    private TextView bRegister;
    private Button bLogin;
    private EditText Email;
    private EditText Password;
    DBHelper MyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        bRegister = (TextView) findViewById(R.id.bRegister);
        bLogin = (Button) findViewById(R.id.bLogin);
        Email = (EditText) findViewById(R.id.Email);
        Password= (EditText) findViewById(R.id.Password);
        MyDB =new DBHelper(this);

//
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String user = Email.getText().toString();
              String pass = Password.getText().toString();

              if (user.equals("") || pass.equals(""))
                  Toast.makeText(SigninActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
              else
                  {
                      Boolean checkuserpass= MyDB.checkEmailPassword(user, pass);
                      if(checkuserpass == true) {
                              Toast.makeText(SigninActivity.this, "Sign in  Successifully", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                              startActivity(intent);
                          }
                          else {
                              Toast.makeText(SigninActivity.this, "Invalid credentials else register", Toast.LENGTH_SHORT).show();
                          }
                      }



                  }


        });

    }
}