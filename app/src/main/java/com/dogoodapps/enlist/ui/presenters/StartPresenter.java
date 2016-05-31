package com.dogoodapps.enlist.ui.presenters;

import android.content.Context;
import android.content.Intent;

import com.dogoodapps.enlist.api.interactors.StartInteractor;
import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.mvp.StartMVP;
import com.dogoodapps.enlist.ui.views.MainActivity;

import rx.Subscriber;

public class StartPresenter extends BasePresenter<StartMVP.View, StartInteractor> implements StartMVP.Presenter {

	public StartPresenter(StartMVP.View view, StartInteractor interactor) {
		super(view, interactor);
	}

	@Override
	public void loadConfiguration() {
		getInteractor().loadConfiguration(new MdbSubscriber<Configuration>() {
			@Override
			public void onLoad(Configuration configuration) {
				getView().onLoaded(configuration);
			}
		});
	}

	@Override
	public void loadMainActivity(Context context) {
		Intent intent = new Intent(context, MainActivity.class);
		context.startActivity(intent);
	}
}
