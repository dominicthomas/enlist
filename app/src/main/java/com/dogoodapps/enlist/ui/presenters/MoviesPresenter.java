package com.dogoodapps.enlist.ui.presenters;

import android.util.Log;

import com.dogoodapps.enlist.api.interactors.MdbInteractor;
import com.dogoodapps.enlist.api.response.MoviesResponse;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.ui.mvp.MoviesMVP;

public class MoviesPresenter extends BasePresenter<MoviesMVP.View, MdbInteractor> implements MoviesMVP.Presenter {

	public MoviesPresenter(MoviesMVP.View view, MdbInteractor interactor) {
		super(view, interactor);
	}

	@Override
	public void loadResults() {
		getInteractor().getMovies(new MdbSubscriber<MoviesResponse>() {

			@Override
			public void onError(Throwable e) {
				super.onError(e);
				Log.d("TAG", e.getMessage()); // TODO: Update view with error!
			}

			@Override
			public void onLoad(MoviesResponse moviesResponse) {
				getView().displayResults(moviesResponse.getResults());
			}
		});
	}
}
