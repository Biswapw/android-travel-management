package com.example.travelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travelmanagementsystem.model.TravelManagement;
import com.example.travelmanagementsystem.retrofit.RetrofitService;
import com.example.travelmanagementsystem.retrofit.TravelManagementApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateDetails extends AppCompatActivity {
    EditText editTextUserName, editTextId, editTextAdarPan, editTextName, editTextGender, editTextCountry, editTextAddress, editTextPhone, editTextEmail;

    Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextId = findViewById(R.id.editTextId);
        editTextAdarPan = findViewById(R.id.editTextAdharPan);
        editTextName = findViewById(R.id.editTextName);
        editTextGender = findViewById(R.id.editTextGender);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        RetrofitService retrofitService = new RetrofitService();
        TravelManagementApi travelManagementApi = retrofitService.getRetrofit().create(TravelManagementApi.class);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String username = editTextUserName.getText().toString();
                    long id = Long.parseLong(editTextId.getText().toString());
                    double number = Double.parseDouble(editTextAdarPan.getText().toString());
                    String name = editTextName.getText().toString();
                    String gender = editTextGender.getText().toString();
                    String country = editTextCountry.getText().toString();
                    String address = editTextAddress.getText().toString();
                    double phone = Double.parseDouble(editTextPhone.getText().toString());
                    String emailAddress = editTextEmail.getText().toString();

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

                    Call<TravelManagement> call = travelManagementApi.updateTravelManagement(id, travelManagement);
                    call.enqueue(new Callback<TravelManagement>() {
                        @Override
                        public void onResponse(Call<TravelManagement> call, Response<TravelManagement> response) {
                            if (response.isSuccessful()) {
                                // The update was successful
                                Toast.makeText(UpdateDetails.this, "Update successful!!", Toast.LENGTH_SHORT).show();
                            } else {
                                // The server returned an error response
                                // You can handle specific HTTP error codes here
                                Toast.makeText(UpdateDetails.this, "Update failed. Server returned an error.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<TravelManagement> call, Throwable t) {
                            // Handle network or other failures
                            Toast.makeText(UpdateDetails.this, "Update failed. An error occurred.", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(UpdateDetails.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
                } catch (NumberFormatException e) {
                    // Handle number format exceptions here
                    Toast.makeText(UpdateDetails.this, "Invalid number format.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
