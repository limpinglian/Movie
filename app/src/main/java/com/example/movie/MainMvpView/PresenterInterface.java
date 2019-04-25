package com.example.movie.MainMvpView;

public interface PresenterInterface<V extends ViewInterface> {
    void attachView(V viewInterface);
}
