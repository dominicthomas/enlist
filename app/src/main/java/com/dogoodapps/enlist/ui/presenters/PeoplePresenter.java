package com.dogoodapps.enlist.ui.presenters;

import android.util.Log;

import com.dogoodapps.enlist.api.interactors.TheMovieDbInteractor;
import com.dogoodapps.enlist.api.response.PeopleResponse;
import com.dogoodapps.enlist.ui.mvp.PeopleMVP;

import rx.Subscriber;

public class PeoplePresenter extends BasePresenter<PeopleMVP.View> implements PeopleMVP.Presenter {

	public PeoplePresenter(PeopleMVP.View view) {
		super(view);
	}

	@Override
	public void loadResults() {
		// TODO: Show loading?
		TheMovieDbInteractor.getPeople(new Subscriber<PeopleResponse>() {
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
			public void onNext(PeopleResponse peopleResponse) {
				getView().displayResults(peopleResponse.getResults());
			}
		});
	}
}
