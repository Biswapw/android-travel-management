package com.example.travelmanagementsystem;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText usernameEditText, emailEditText, passwordEditText, SecurityEditText, answerEditText;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        SecurityEditText = findViewById(R.id.SecurityEditText);
        answerEditText = findViewById(R.id.answerEditText);
        signUpButton = findViewById(R.id.signupButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String securityQuestion = SecurityEditText.getText().toString();
                String answer = answerEditText.getText().toString();
                signUpButton = (Button) findViewById(R.id.signupButton);
                    Intent intent  = new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);

            }
        });
    }
}

