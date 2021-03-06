package com.example.movie.Presenter;

import android.util.Log;
import android.view.View;

import com.example.movie.Base.BasePresenter;
import com.example.movie.Model.Search;
import com.example.movie.MainMvpView.ViewInterface;
import com.example.movie.Retrofit.RetrofitInterface;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter extends BasePresenter<ViewInterface> {
    String searchText;
    ViewInterface viewInterface;

    @Inject
    public MainPresenter() {


    }

    public void attachView(ViewInterface viewInterface) {
        super.attachView(viewInterface);
    }


    public void searchMovies(String serachText) {
        RetrofitInterface service = getRetrofitInstance().create(RetrofitInterface.class);
        service.getMovieResponse(serachText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<Search>() {
                    @Override
                    public void onNext(Search search) {
                        if (search != null) {
                            getMvpView().displayMovie(search);
                            Log.d("Search size", search + "");
                        } else {
                            Log.d("error", "is null");
                        }

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
