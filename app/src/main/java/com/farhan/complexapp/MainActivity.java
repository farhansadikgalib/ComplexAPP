package com.farhan.complexapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;


import com.farhan.complexapp.NightMode.SharedPref;


public class MainActivity extends AppCompatActivity {


    String[] nameList = {"farhan","kodu","dhaka","dinajpur","Chaina","modu"};
    //ArrayAdapter adapter;
        ArrayAdapter adapter;
        SharedPref sharedpref;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.darktheme);
        }
        else  setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nameList);

    }

    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
    }







