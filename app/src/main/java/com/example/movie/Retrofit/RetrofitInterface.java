package com.example.movie.Retrofit;

import com.example.movie.Model.Search;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface  {

    @POST("?apikey=e03c50d")
    Observable<Search> getMovieResponse(@Query("s")String title);


}
