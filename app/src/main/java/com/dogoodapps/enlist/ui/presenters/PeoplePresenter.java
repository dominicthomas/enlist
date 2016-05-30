package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.TheMovieDbInteractor;
import com.dogoodapps.enlist.api.response.PeopleResponse;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.ui.mvp.PeopleMVP;

public class PeoplePresenter extends BasePresenter<PeopleMVP.View> implements PeopleMVP.Presenter {

	public PeoplePresenter(PeopleMVP.View view) {
		super(view);
	}

	@Override
	public void loadResults() {
		TheMovieDbInteractor.getPeople(new MdbSubscriber<PeopleResponse>() {
			@Override
			public void onLoad(PeopleResponse peopleResponse) {
				getView().displayResults(peopleResponse.getResults());
			}
		});
	}
}
