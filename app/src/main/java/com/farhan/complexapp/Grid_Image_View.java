package com.farhan.complexapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.net.DnsResolver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.farhan.complexapp.model.Photos;
import com.farhan.complexapp.network.ApiClient;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Grid_Image_View extends AppCompatActivity {


    GridView gridView;
    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image_view);

        gridView = findViewById(R.id.gridview);


        Call<List<Photos>> listCall = ApiClient.apiInterface().getPhotos();

        listCall.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {

                if (response.isSuccessful()){

                    customAdapter = new CustomAdapter(response.body(),Grid_Image_View.this);
                    gridView.setAdapter(customAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


//        Call<List<Photos>> call = ApiClient.apiInterface().getPhotos();
//
//        call.enqueue(new DnsResolver.Callback<List<Photos>>() {
//            @Override
//            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
//
//                if (response.isSuccessful()){
//
//                    customAdapter = new CustomAdapter(response.body(),MainActivity.this);
//
//                    gridView.setAdapter(customAdapter);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Photos>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });





    }

    public class CustomAdapter extends BaseAdapter {


        public List<Photos> photosList;
        public Context context;

        public CustomAdapter(List<Photos> photosList, Context context) {
            this.photosList = photosList;
            this.context = context;
        }




        @Override
        public int getCount() {
            return photosList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(context).inflate(R.layout.row_data,null);


            TextView title = view.findViewById(R.id.text_data);
            ImageView imageView = view.findViewById(R.id.image_data);

            title.setText(photosList.get(position).getTitle());
            Glide.with(context).load(photosList.get(position).getThumbnailUrl()).into(imageView);


            return view;



        }
    }


}
