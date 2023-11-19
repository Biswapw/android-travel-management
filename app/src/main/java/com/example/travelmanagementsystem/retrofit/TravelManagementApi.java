package com.example.travelmanagementsystem.retrofit;

import com.example.travelmanagementsystem.model.TravelManagement;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TravelManagementApi {
    @GET("/travel-management/view/{id}")
    Call<TravelManagement> getTravelManagementById(@Path("id") Long userId);


    @POST("/travel-management/create")
    Call<TravelManagement> createTravelManagement(@Body TravelManagement travelManagement);

    @PUT("/travel-management/update/{id}")
    Call<TravelManagement> updateTravelManagement(@Path("id") Long id, @Body TravelManagement travelManagement);

    @DELETE("/travel-management/delete/{id}")
    Call<Void> deleteTravelManagement(@Path("id") Long id);


}
