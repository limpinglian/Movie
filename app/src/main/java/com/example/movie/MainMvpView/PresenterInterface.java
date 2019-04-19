package com.example.movie.MainMvpView;

public interface PresenterInterface<V extends ViewInterface> {
    //void searchMovies(String serachText);
    void attachView(V viewInterface);
}
