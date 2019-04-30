package com.example.movie.Component;

import android.app.Application;

import com.example.movie.Base.BasePresenter;
import com.example.movie.MainMvpView.ViewInterface;
import com.example.movie.Module.AppModule;
import com.example.movie.Module.NetworkModule;
import com.example.movie.MyApplication;
import com.example.movie.Presenter.MainPresenter;
import com.example.movie.ui.MainActivity;

import dagger.Component;

@Component(modules = {NetworkModule.class,AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

}
