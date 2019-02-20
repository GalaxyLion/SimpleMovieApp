package com.example.galax.simplemovieapp.screens.movie.grid_movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.grid_movie.event.ClickGridEvent;
import com.example.galax.simplemovieapp.screens.movie.list_movie.event.ClickListEvent;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridMovieAdapter extends RecyclerView.Adapter<GridMovieAdapter.ViewHolder>{

    List<Movie> movieList;
    Bus bus;

    public GridMovieAdapter(List<Movie> movieList, Bus bus) {
        this.movieList = movieList;
        this.bus = bus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Picasso.get()
                .load(movie.getPosterPath())
                .into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.releaseDate.setText(movie.getReleaseDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.post(new ClickGridEvent(movie));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView poster;
        TextView title;
        TextView releaseDate;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title);
            releaseDate = itemView.findViewById(R.id.release_date);
        }
    }
}
