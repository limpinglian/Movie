package com.example.movie.Base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.movie.MainMvpView.ViewInterface;
import com.example.movie.Presenter.MainPresenter;
import com.example.movie.R;
import com.example.movie.ui.MainActivity;

public abstract class BaseActivity extends AppCompatActivity {
    MainActivity mainActivity;
    MainPresenter mainPresenter;
    ViewInterface viewInterface;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResourceId());

    }
    protected abstract int setLayoutResourceId();
}
