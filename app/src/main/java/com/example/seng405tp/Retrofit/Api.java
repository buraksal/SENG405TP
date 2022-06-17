package com.example.seng405tp.Retrofit;

import com.example.seng405tp.models.SearchMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("{movieTitle}")
    Call<SearchMovie> getMovies(@Path("movieTitle") String movieTitle);
}
