package com.example.travelmanagementsystem;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button signupButton, loginButton;
    public TextView forgotPassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signupButton = (Button) findViewById(R.id.signupButton);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword) ;
        loginButton = (Button) findViewById(R.id.loginButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2  = new Intent(MainActivity.this,ForGetPassword.class);
                startActivity(intent2);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3  = new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent3);
            }
        });

    }
}