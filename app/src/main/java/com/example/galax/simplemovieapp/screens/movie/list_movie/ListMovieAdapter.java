package com.example.galax.simplemovieapp.screens.movie.list_movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.list_movie.event.ClickListEvent;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolder>  {


    List<Movie> movieList;
    Bus bus;

    public ListMovieAdapter(List<Movie> movieList, Bus bus) {
        this.movieList = movieList;
        this.bus = bus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Picasso.get()
                .load(movie.getPosterPath())
                .into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.overView.setText(movie.getOverview());
        holder.rating.setText(Double.toString(movie.getVoteAverage()));
        holder.releaseDate.setText(movie.getReleaseDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bus.post(new ClickListEvent(movie));
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
        TextView overView;
        TextView rating;
        TextView releaseDate;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title);
            overView = itemView.findViewById(R.id.synopsis);
            rating = itemView.findViewById(R.id.rating);
            releaseDate = itemView.findViewById(R.id.release_date);
        }
    }
}
