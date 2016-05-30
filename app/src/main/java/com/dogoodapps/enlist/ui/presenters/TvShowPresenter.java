package com.dogoodapps.enlist.ui.presenters;

import android.util.Log;

import com.dogoodapps.enlist.api.interactors.TheMovieDbInteractor;
import com.dogoodapps.enlist.api.model.MoviesResponse;
import com.dogoodapps.enlist.api.model.TvResponse;
import com.dogoodapps.enlist.ui.mvp.MoviesMVP;
import com.dogoodapps.enlist.ui.mvp.TvShowMVP;

import rx.Subscriber;

public class TvShowPresenter extends BasePresenter<TvShowMVP.View> implements TvShowMVP.Presenter {

	public TvShowPresenter(TvShowMVP.View view) {
		super(view);
	}

	@Override
	public void loadResults() {
		// TODO: Show loading?
		TheMovieDbInteractor.getTvShows(new Subscriber<TvResponse>() {
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
			public void onNext(TvResponse tvResponse) {
				getView().displayResults(tvResponse.getResults());
			}
		});
	}
}
