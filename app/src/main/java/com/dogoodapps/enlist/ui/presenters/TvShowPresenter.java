package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.MdbInteractor;
import com.dogoodapps.enlist.api.response.TvShowResponse;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.mvp.TvShowMVP;

public class TvShowPresenter extends BasePresenter<TvShowMVP.View, MdbInteractor> implements TvShowMVP.Presenter {

	public TvShowPresenter(TvShowMVP.View view, MdbInteractor interactor) {
		super(view, interactor);
	}

	@Override
	public void loadResults() {
		getInteractor().getTvShows(new MdbSubscriber<TvShowResponse>() {
			@Override
			public void onLoad(TvShowResponse tvShowResponse) {
				getView().displayResults(tvShowResponse.getResults());
			}
		});
	}
}
