package com.farhan.complexapp.network;

import com.farhan.complexapp.model.Photos;
import com.farhan.complexapp.model.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("photos")
    Call<List<Photos>> getPhotos();


}
