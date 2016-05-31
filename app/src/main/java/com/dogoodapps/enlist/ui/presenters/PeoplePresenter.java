package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.MdbInteractor;
import com.dogoodapps.enlist.api.response.PeopleResponse;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.mvp.PeopleMVP;

public class PeoplePresenter extends BasePresenter<PeopleMVP.View, MdbInteractor> implements PeopleMVP.Presenter {

	public PeoplePresenter(PeopleMVP.View view, MdbInteractor interactor) {
		super(view, interactor);
	}

	@Override
	public void loadResults() {
		getInteractor().getPeople(new MdbSubscriber<PeopleResponse>() {
			@Override
			public void onLoad(PeopleResponse peopleResponse) {
				getView().displayResults(peopleResponse.getResults());
			}
		});
	}
}
