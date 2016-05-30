package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.TheMovieDbInteractor;
import com.dogoodapps.enlist.api.response.MoviesResponse;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.ui.mvp.MoviesMVP;

public class MoviesPresenter extends BasePresenter<MoviesMVP.View> implements MoviesMVP.Presenter {

	public MoviesPresenter(MoviesMVP.View view) {
		super(view);
	}

	@Override
	public void loadResults() {
		TheMovieDbInteractor.getMovies(new MdbSubscriber<MoviesResponse>() {
			@Override
			public void onLoad(MoviesResponse moviesResponse) {
				getView().displayResults(moviesResponse.getResults());
			}
		});
	}
}
