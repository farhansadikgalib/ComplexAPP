package com.farhan.complexapp;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.farhan.complexapp.Movie.MovieListFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetails extends Fragment {

    TextView name,email,phone ,gender,address;

    Button home_btn,api_view;

    CheckBox checkBox;


    public UserDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {



        name = view.findViewById(R.id.nameTV);
        email = view.findViewById(R.id.emailTV);
        phone = view.findViewById(R.id.phoneTv);
        gender = view.findViewById(R.id.genTV);
       address = view.findViewById(R.id.addTV);
        home_btn = view.findViewById(R.id.home_btn);

        api_view = view.findViewById(R.id.api_view);

        checkBox = view.findViewById(R.id.Checkboxx);


        name.setText(getArguments().getString("name"));
        email.setText(getArguments().getString("email"));
        phone.setText(getArguments().getString("phone"));
        gender.setText(getArguments().getString("gender"));
        address.setText(getArguments().getString("address"));
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()){
                    Navigation.findNavController(view).navigate(R.id.action_userDetails_to_home2);
                }
                else {

                    Toast.makeText(getActivity().getApplicationContext(), "You're not agree with our terms & condition", Toast.LENGTH_LONG).show();
                } }
        });

        api_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(),Api_User_View.class);
                startActivity(i);

            }
        });

    }

}