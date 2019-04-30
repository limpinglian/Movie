package com.example.movie.Base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public abstract class BaseActivity extends AppCompatActivity  {


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResourceId());



    }
    protected abstract int setLayoutResourceId();

}
