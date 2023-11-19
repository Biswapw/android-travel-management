package com.example.travelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        // Initialize buttons
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonView = findViewById(R.id.buttonView);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        Button buttonCheckPackage = findViewById(R.id.buttonCheckPackage);
        Button buttonBookPackage = findViewById(R.id.buttonBookPackage);
        Button buttonViewPackage = findViewById(R.id.buttonViewPackage);
        Button buttonViewHotel = findViewById(R.id.buttonViewHotel);
        Button buttonBookedHotel = findViewById(R.id.buttonBookedHotel);
        Button buttonDestination = findViewById(R.id.buttonDestination);
        Button buttonPayment = findViewById(R.id.buttonPayment);
        Button buttonAbout = findViewById(R.id.buttonAbout);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AddPersonalData.class);
                startActivity(intent);
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Dashboard.this,UpdateDetails.class);
                startActivity(intent1);
            }
        });
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Dashboard.this,ViewDetails.class);
                startActivity(intent2);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Dashboard.this, ViewDetails.class);
                startActivity(intent3);
            }
        });

    }
}