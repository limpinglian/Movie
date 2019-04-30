package com.example.movie.ui;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.movie.Base.BaseActivity;
import com.example.movie.Model.Movie;
import com.example.movie.Model.Search;
import com.example.movie.MainMvpView.ViewInterface;
import com.example.movie.MyApplication;
import com.example.movie.Presenter.MainPresenter;
import com.example.movie.R;
import com.example.movie.Adapter.RecyclerViewAdapter;


import java.util.List;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements ViewInterface {
    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getAppComponent().inject(this);
        mainPresenter.attachView(this);

    }

    @OnClick(R.id.btnSearch)
    public void onClick(View view) {
        mainPresenter.searchMovies(etSearch.getText().toString());

    }

    @Override
    protected int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    private void generateMovieList(List<Movie> dataList) {

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(), dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setMovie(dataList);
        Log.d("datalist", dataList.size() + "");
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayMovie(Search search) {
        generateMovieList(search.getSearch());
    }

}

