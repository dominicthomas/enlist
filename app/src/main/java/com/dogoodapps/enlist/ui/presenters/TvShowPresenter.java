package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.TheMovieDbInteractor;
import com.dogoodapps.enlist.api.response.TvShowResponse;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.ui.mvp.TvShowMVP;

public class TvShowPresenter extends BasePresenter<TvShowMVP.View> implements TvShowMVP.Presenter {

	public TvShowPresenter(TvShowMVP.View view) {
		super(view);
	}

	@Override
	public void loadResults() {
		TheMovieDbInteractor.getTvShows(new MdbSubscriber<TvShowResponse>() {
			@Override
			public void onLoad(TvShowResponse tvShowResponse) {
				getView().displayResults(tvShowResponse.getResults());
			}
		});
	}
}
