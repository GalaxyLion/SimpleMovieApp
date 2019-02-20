package com.example.galax.simplemovieapp.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String overview;
    private String originalLanguage;
    private String title;
    private String posterPath;
    private String releaseDate;
    private double voteAverage;
    private double popularity;


    public Movie(String overview, String originalLanguage, String title, String posterPath, String releaseDate, double voteAverage, double popularity) {
        this.overview = overview;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.popularity = popularity;
    }


    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.title);
        dest.writeString(this.posterPath);
        dest.writeString(this.releaseDate);
        dest.writeDouble(this.voteAverage);
        dest.writeDouble(this.popularity);
    }

    protected Movie(Parcel in) {
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.title = in.readString();
        this.posterPath = in.readString();
        this.releaseDate = in.readString();
        this.voteAverage = in.readDouble();
        this.popularity = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
