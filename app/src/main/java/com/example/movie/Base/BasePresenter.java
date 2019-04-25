package com.example.movie.Base;

import com.example.movie.MainMvpView.PresenterInterface;
import com.example.movie.MainMvpView.ViewInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BasePresenter<T extends ViewInterface>implements PresenterInterface<T> {
    private T vInterface;
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://www.omdbapi.com/";

public void attachView(T vInterface) {
       this.vInterface = vInterface;
   }
    public T getMvpView() {
        //this method is to get the attached view u declare at the above ,
        // since this class is parent to all the presenter class,
        // use this method to get the view
        return vInterface;
    }
    public static Retrofit getRetrofitInstance() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);


        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



}
