package com.example.travelmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelmanagementsystem.model.TravelManagement;
import com.example.travelmanagementsystem.retrofit.RetrofitService;
import com.example.travelmanagementsystem.retrofit.TravelManagementApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewDetails extends AppCompatActivity {
    EditText editTextId;
    Button buttonView, buttonDelete;
    TextView textViewUserName, textViewId, textViewAdarPan, textViewName, textViewGender, textViewCountry, textViewAddress, textViewPhone, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        editTextId = findViewById(R.id.editTextId);
        buttonView = findViewById(R.id.buttonView);
        buttonDelete = findViewById(R.id.buttonDelete);


        textViewUserName = findViewById(R.id.textViewUserName);
        textViewId = findViewById(R.id.textViewId);
        textViewAdarPan = findViewById(R.id.textViewAdarPan);
        textViewName = findViewById(R.id.textViewName);
        textViewGender = findViewById(R.id.textViewGender);
        textViewCountry = findViewById(R.id.textViewCountry);
        textViewAddress = findViewById(R.id.textViewAddress);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewEmail = findViewById(R.id.textViewEmail);

        RetrofitService retrofitService = new RetrofitService();
        TravelManagementApi travelManagementApi = retrofitService.getRetrofit().create(TravelManagementApi.class);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIdText = editTextId.getText().toString();
                if (userIdText.isEmpty()) {
                    // Handle the case where the user didn't enter an ID
                    Toast.makeText(ViewDetails.this, "Please enter a user ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                long userId = Long.parseLong(userIdText);

                Call<TravelManagement> call = travelManagementApi.getTravelManagementById(userId);

                call.enqueue(new Callback<TravelManagement>() {

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<TravelManagement> call, Response<TravelManagement> response) {
                        if (response.isSuccessful()) {
                            TravelManagement travelManagement = response.body();

                            // Set TextViews with the retrieved data

                            assert travelManagement != null;
                            textViewUserName.setText("User Name: " + travelManagement.getUserName());
                            textViewId.setText("ID: " + travelManagement.getId());
                            textViewAdarPan.setText("Adar/PAN: " + travelManagement.getNumber());
                            textViewName.setText("Name: " + travelManagement.getName());
                            textViewGender.setText("Gender: " + travelManagement.getGender());
                            textViewCountry.setText("Country: " + travelManagement.getCountry());
                            textViewAddress.setText("Address: " + travelManagement.getAddress());
                            textViewPhone.setText("Phone: " + travelManagement.getPhone());
                            textViewEmail.setText("Email: " + travelManagement.getEmail());
                        } else {
                            // Handle the case where the server returned an error
                            Toast.makeText(ViewDetails.this, "Failed to retrieve details. Server returned an error.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TravelManagement> call, Throwable t) {
                        // Handle the case where an error occurred
                        Toast.makeText(ViewDetails.this, "Failed to retrieve details. An error occurred.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIdText = editTextId.getText().toString();
                if (userIdText.isEmpty()) {
                    // Handle the case where the user didn't enter an ID
                    Toast.makeText(ViewDetails.this, "Please enter a user ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                long userId = Long.parseLong(userIdText);

                Call<Void> call = travelManagementApi.deleteTravelManagement(userId);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // Handle the case where the delete operation was successful
                            Toast.makeText(ViewDetails.this, "Details deleted successfully.", Toast.LENGTH_SHORT).show();
                            // Clear the TextViews or hide them as needed
                            clearTextViews();

                        } else {
                            // Handle the case where the server returned an error
                            Toast.makeText(ViewDetails.this, "Failed to delete details. Server returned an error.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Handle the case where an error occurred
                        Toast.makeText(ViewDetails.this, "Failed to delete details. An error occurred.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    private void clearTextViews() {
        textViewUserName.setText("");
        textViewId.setText("");
        textViewAdarPan.setText("");
        textViewName.setText("");
        textViewGender.setText("");
        textViewCountry.setText("");
        textViewAddress.setText("");
        textViewPhone.setText("");
        textViewEmail.setText("");
    }
}
