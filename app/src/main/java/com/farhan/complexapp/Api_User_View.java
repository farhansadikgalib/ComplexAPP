package com.farhan.complexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_User_View extends AppCompatActivity {

    private TextView textViewResult;
    private Button btn_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api__user__view);

        textViewResult = findViewById(R.id.text_view_result);
        btn_iv = findViewById(R.id.btn_show_img);



        btn_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), Grid_Image_View.class);
                startActivity(i);


            }
        });













        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://jsonplaceholder.typicode.com/");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder
                .build();



        Api jsonPlaceHolderApi = retrofit.create(Api.class);



        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "Name: " + post.getUsername() + "\n";
                    content += "Email: " + post.getEmail() + "\n";
                    content += "Phone: " + post.getPhone() + "\n";
                    content += "Company: " + post.getCompany().getBs()+ "\n";
                    content += "Address: " + post.getAddress().getCity() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}