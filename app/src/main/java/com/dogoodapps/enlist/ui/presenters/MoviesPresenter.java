package com.dogoodapps.enlist.ui.presenters;

import android.util.Log;

import com.dogoodapps.enlist.api.interactors.TheMovieDbInteractor;
import com.dogoodapps.enlist.api.response.MoviesResponse;
import com.dogoodapps.enlist.ui.mvp.MoviesMVP;

import rx.Subscriber;

public class MoviesPresenter extends BasePresenter<MoviesMVP.View> implements MoviesMVP.Presenter {

	public MoviesPresenter(MoviesMVP.View view) {
		super(view);
	}

	@Override
	public void loadResults() {
		// TODO: Show loading?
		TheMovieDbInteractor.getMovies(new Subscriber<MoviesResponse>() {
			@Override
			public void onCompleted() {
				Log.d("enList", "Completed");
				// TODO: Hide loading?
			}

			@Override
			public void onError(Throwable e) {
				// TODO: onError - show error screen / message!
				Log.d("enList", e.getMessage());
			}

			@Override
			public void onNext(MoviesResponse moviesResponse) {
				getView().displayResults(moviesResponse.getResults());
			}
		});
	}
}
