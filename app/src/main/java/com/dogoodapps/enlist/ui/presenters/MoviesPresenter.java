package com.dogoodapps.enlist.ui.presenters;

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
			public void onLoad(MoviesResponse moviesResponse) {
				getView().displayResults(moviesResponse.getResults());
			}
		});
	}
}
