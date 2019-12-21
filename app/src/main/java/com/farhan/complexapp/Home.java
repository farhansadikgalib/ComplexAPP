package com.farhan.complexapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.farhan.complexapp.Movie.MovieAdapter;
import com.farhan.complexapp.Movie.MovieListFragment;


public class Home extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        MovieListFragment movileListFragment = new MovieListFragment();
        ft.add(R.id.fragmentContainer, movileListFragment);
        ft.commit();



    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.toolbar_search_menu, menu);
            MenuItem menuItem1 = menu.findItem(R.id.action_search);

            android.widget.SearchView searchView = (android.widget.SearchView) menuItem1.getActionView();
            searchView.setQueryHint("Search Movie");
            searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {


                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    //adapter.getFilter().filter(newText);

                    return true;
                }
            });


            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){


//            Switch myswitch = findViewById(R.id.myswitch);
//
//            if (sharedpref.loadNightModeState()==true) {
//                myswitch.setChecked(true);
//            }
//            myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if (isChecked) {
//                        sharedpref.setNightModeState(true);
//                        restartApp();
//                    }
//                    else {
//                        sharedpref.setNightModeState(false);
//                        restartApp();
//                    }
//                }
//            });
//


            switch (item.getItemId()) {
                case R.id.about_us:
                    Dialog dialog = new Dialog(Home.this);
                    dialog.setContentView(R.layout.alartdialog);
                    dialog.show();
                    break;

                case R.id.logout:

                    Toast.makeText(this, "Singout", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(Home.this,MainActivity.class);
                    startActivity(i);


            }
            return super.onOptionsItemSelected(item);

        }



    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you really want to Logout from MovieFlix ??").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }







    public void facebook (View view){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.facebook.com/farhansadikgalib"));
            startActivity(i);
            return;

        }

        public void github (View view){

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://github.com/farhansadikgalib"));
            startActivity(i);
            return;
        }

        public void aboutme (View view){

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://about.me/farhansadikgalib"));
            startActivity(i);
            return;
        }


    }





