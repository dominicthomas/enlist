package com.dogoodapps.enlist.ui.presenters;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.dogoodapps.enlist.api.interactors.StartInteractor;
import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.api.subscribers.MdbSubscriber;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.mvp.StartMVP;
import com.dogoodapps.enlist.ui.views.MainActivity;

public class StartPresenter extends BasePresenter<StartMVP.View, StartInteractor> implements StartMVP.Presenter {

	private static final int LOADING_DELAY = 1000;

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
	public void loadActivity(Context context, Class<?> cls) {
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(context, cls);
				context.startActivity(intent);
			}
		}, LOADING_DELAY);
	}
}
