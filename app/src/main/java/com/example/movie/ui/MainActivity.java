package com.example.movie.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movie.Base.BaseActivity;
import com.example.movie.Model.Movie;
import com.example.movie.Model.Search;
import com.example.movie.MainMvpView.ViewInterface;
import com.example.movie.Presenter.MainPresenter;
import com.example.movie.R;
import com.example.movie.Adapter.RecyclerViewAdapter;


import java.util.List;


import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity implements ViewInterface  {
    List<Movie> movieList;
    private CompositeDisposable mCompositeDisposable;
    MainPresenter mainPresenter=new MainPresenter();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSearch = findViewById(R.id.btnSearch);
        mCompositeDisposable = new CompositeDisposable();

        mainPresenter.attachView(this);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etSearch = findViewById(R.id.etSearch);
                mainPresenter.searchMovies(etSearch.getText().toString());
            }
        });
    }


//    @Override
//    public void displayMovie(Search search) {
//
//    }

    private void generateMovieList(List<Movie> dataList) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(), dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        if(dataList==null){
            Toast.makeText(this,"Movie does not exist",Toast.LENGTH_SHORT).show();
        }else{
            adapter.setMovie(dataList);
            recyclerView.setAdapter(adapter);
        }
    }
    @Override protected int setLayoutResourceId() {
        return R.layout.activity_main;
    }


    @Override
    public void displayMovie(Search search) {
        generateMovieList(search.getSearch());
    }
}

