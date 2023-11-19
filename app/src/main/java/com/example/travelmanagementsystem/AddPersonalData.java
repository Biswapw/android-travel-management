package com.example.travelmanagementsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.travelmanagementsystem.model.TravelManagement;
import com.example.travelmanagementsystem.retrofit.RetrofitService;
import com.example.travelmanagementsystem.retrofit.TravelManagementApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPersonalData extends AppCompatActivity {
    EditText editTextUsername, editTextId, editTextNumber, editTextName, editTextGender,
            editTextCountry, editTextAddress, editTextPhone, editTextEmailAddress;
    Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpersonaldetails);
        initializeComponents();
    }
    private void initializeComponents() {

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextId = findViewById(R.id.editTextId);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextName = findViewById(R.id.editTextName);
        editTextGender = findViewById(R.id.editTextGender);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);

        buttonAdd = findViewById(R.id.buttonAdd);
        RetrofitService retrofitService = new RetrofitService();
        TravelManagementApi travelManagementApi = retrofitService.getRetrofit().create(TravelManagementApi.class);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String username = String.valueOf(editTextUsername.getText());
                    long id = Long.parseLong(String.valueOf(editTextId.getText()));
                    double number = Double.parseDouble(String.valueOf(editTextNumber.getText()));
                    String name = String.valueOf(editTextName.getText());
                    String gender = String.valueOf(editTextGender.getText());
                    String country =String.valueOf(editTextCountry.getText());
                    String address = String.valueOf(editTextAddress.getText());
                    double phone = Double.parseDouble(String.valueOf(editTextPhone.getText()));
                    String emailAddress = String.valueOf(editTextEmailAddress.getText());

                    TravelManagement travelManagement = new TravelManagement();


                    travelManagement.setUserName(username);
                    travelManagement.setId(id);
                    travelManagement.setNumber(number);
                    travelManagement.setName(name);
                    travelManagement.setGender(gender);
                    travelManagement.setCountry(country);
                    travelManagement.setAddress(address);
                    travelManagement.setPhone(phone);
                    travelManagement.setEmail(emailAddress);

                    Call<TravelManagement> call = travelManagementApi.createTravelManagement(travelManagement);
                    call.enqueue(new Callback<TravelManagement>() {
                        @Override
                        public void onResponse( Call<TravelManagement> call,  Response<TravelManagement> response) {

                                Toast.makeText(AddPersonalData.this, "Save successful!!", Toast.LENGTH_SHORT).show();

                        }
                        @Override
                        public void onFailure(Call<TravelManagement> call, Throwable t) {
                            // Handle network or other failures
                            Toast.makeText(AddPersonalData.this, "Save failed. An error occurred.", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(AddPersonalData.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
                } catch (NumberFormatException e) {
                    // Handle number format exceptions here
                    Toast.makeText(AddPersonalData.this, "Invalid number format.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

