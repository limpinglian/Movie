package com.example.movie.Module;

import com.example.movie.Retrofit.RetrofitInterface;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {
    @Provides
    RetrofitInterface getApiInterface(Retrofit retrofit){
        return retrofit.create(RetrofitInterface.class);
    }

}
