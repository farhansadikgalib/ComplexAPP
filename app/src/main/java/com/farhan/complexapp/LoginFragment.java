package com.farhan.complexapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText emailET,passET;
    private Button login_btn,reg_btn;

    public LoginFragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailET = view.findViewById(R.id.emailET);
        passET = view.findViewById(R.id.passwordET);
        login_btn = view.findViewById(R.id.login_btn);
        reg_btn= view.findViewById(R.id.registration_btn);








        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment);

            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String username =  emailET.getText().toString();

                if(emailET.getText().toString().equals("farhansadikgalib@gmail.com") && passET.getText().toString().equals("1234")){

                    Toast.makeText(getActivity(), "welcome "+username, Toast.LENGTH_LONG).show();


                    Intent i = new Intent(getContext(),Home.class);
                    startActivity(i);

                    //correcct password
                }else{
                    //wrong password
                    Toast.makeText(getActivity().getApplicationContext(), "Username & Password is Wrong ", Toast.LENGTH_SHORT).show();
                }


            }
        });





    }





}
