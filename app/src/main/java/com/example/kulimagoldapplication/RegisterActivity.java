package com.example.kulimagoldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
        private Button bRegister;
        private TextView sRegister;
        private EditText Email;
        private EditText Password;
        private EditText rePassword;
        DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bRegister= (Button)findViewById(R.id.bRegister);
        sRegister= (TextView)findViewById(R.id.sRegister);
        Email = (EditText) findViewById(R.id.Email);
        Password= (EditText) findViewById(R.id.Password);
        rePassword= (EditText) findViewById(R.id.rePassword);
        MyDB =new DBHelper(this);

        sRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( RegisterActivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Email.getText().toString();
                String pass = Password.getText().toString();
                String repass = rePassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                Toast.makeText(RegisterActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)) {
                        Boolean checkuser = MyDB.checkEmail(user);
                        if (checkuser == false) {
                            Boolean insert = MyDB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration   failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "User already exist! Please Login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        }
}