package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.StartInteractor;
import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.mvp.StartMVP;

import rx.Subscriber;

public class StartPresenter extends BasePresenter<StartMVP.View, StartInteractor> implements StartMVP.Presenter {

	public StartPresenter(StartMVP.View view, StartInteractor interactor) {
		super(view, interactor);
	}

	@Override
	public void loadConfiguration() {
		getInteractor().loadConfiguration().subscribe(new Subscriber<Configuration>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {
				// TODO: Show error message
			}

			@Override
			public void onNext(Configuration configuration) {
				getView().onLoaded(configuration);
			}
		});
	}
}
