package com.example.movie;

import android.app.Application;

import com.example.movie.Component.AppComponent;
import com.example.movie.Component.DaggerAppComponent;
import com.example.movie.Module.AppModule;
import com.example.movie.Module.NetworkModule;

public class MyApplication extends Application {
    private AppComponent appComponent;

    public void onCreate(){
        super.onCreate();
         appComponent = (DaggerAppComponent) DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();

    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}

