package com.farhan.complexapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.farhan.complexapp.Movie.MovieListFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeXFragment extends Fragment {
    FragmentManager fragmentManager;
    public HomeXFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_x, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        fragmentManager =  getChildFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        MovieListFragment movileListFragment = new MovieListFragment();
//        ft.replace(R.id.fragmentContainer, movileListFragment);
//        ft.commit();

    }



}
