package com.earsnot.moviematch.Views.Fragments.MovieListFragment;

import java.util.ArrayList;

public class Movie {

    private String movieTitle;
    private String releaseYear;
    private String rating;
    private String summary;
    private String genre;
    private String platform;


    public Movie(){}

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Movie(String movieTitle, String releaseYear, String rating, String summary, String genre, String platform) {
        this.movieTitle = movieTitle;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.summary = summary;
        this.genre = genre;
        this.platform = platform;
    }
}
