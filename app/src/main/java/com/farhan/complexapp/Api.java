package com.farhan.complexapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

     String Base_Url = "https://jsonplaceholder.typicode.com/";
    @GET("users")
    Call<List<Post>> getPosts();

    @GET("photos")

    Call<List<Photo>> getPhotos();



}
