package com.farhan.complexapp.Movie;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.complexapp.R;

import java.util.List;
import java.util.Optional;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_row, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int i) {
        final Movie movie = movieList.get(i);
        holder.imageView.setImageResource(movie.getImage());
        holder.nameTV.setText(movie.getName());
        holder.categoryTV.setText(movie.getCategory());
        holder.yearTV.setText(movie.getYear());
        holder.menuTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.movie_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.iem_details:
                                Toast.makeText(context, movie.getName(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.iem_delete:

                                break;
                            case R.id.iem_edit:

                                break;
                        }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public Optional getFilter() {
        return null;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView nameTV, yearTV, menuTV,categoryTV;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.row_imeageview);
            nameTV = itemView.findViewById(R.id.row_name);
            yearTV = itemView.findViewById(R.id.row_year);
            menuTV = itemView.findViewById(R.id.row_menu);
            categoryTV= itemView.findViewById(R.id.row_category);

        }
    }
}

