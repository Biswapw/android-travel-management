package com.example.travelmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForGetPassword extends AppCompatActivity {
    EditText usernameEditText, emailEditText, passwordEditText, SecurityEditText, answerEditText;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassword);

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        SecurityEditText = findViewById(R.id.SecurityEditText);
        answerEditText = findViewById(R.id.answerEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String securityQuestion = SecurityEditText.getText().toString();
                String answer = answerEditText.getText().toString();
                backButton = (Button) findViewById(R.id.backButton);
                Intent intent  = new Intent(ForGetPassword.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}

