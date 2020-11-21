package com.earsnot.moviematch.apis;

import com.android.volley.RequestQueue;

public class JustWatchAPI {

    private RequestQueue q;
    public JustWatchAPI(){};
    private static final String HEADER = "'User-Agent':'JustWatch client (github.com/dawoudt/JustWatchAPI)'";
    private final String API_BASE_URL = "apis.justwatch.com/";
    private StringBuilder sb = new StringBuilder(API_BASE_URL);



}
