package com.earsnot.moviematch.Views.Fragments.FriendsFragment;

public class FriendsItem {
    private String name, email;
    private int movieMatches, seriesMatches;
    private boolean hasNetflix, hasHBO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMovieMatches() {
        return movieMatches;
    }

    public void setMovieMatches(int movieMatches) {
        this.movieMatches = movieMatches;
    }

    public int getSeriesMatches() {
        return seriesMatches;
    }

    public void setSeriesMatches(int seriesMatches) {
        this.seriesMatches = seriesMatches;
    }

    public boolean isHasHBO() {
        return hasHBO;
    }

    public void setHasHBO(boolean hasHBO) {
        this.hasHBO = hasHBO;
    }

    public boolean isHasNetflix() {
        return hasNetflix;
    }

    public void setHasNetflix(boolean hasNetflix) {
        this.hasNetflix = hasNetflix;
    }
}
