package com.dogoodapps.enlist.api.interactors;

import android.content.Context;

import com.dogoodapps.enlist.api.RestClient;
import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.app.BaseInteractor;
import com.dogoodapps.enlist.utils.JsonHelper;
import com.dogoodapps.enlist.utils.PrefsHelper;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StartInteractor extends BaseInteractor {

	private final Context context;

	private final PrefsHelper prefsHelper;

	private final JsonHelper<Configuration> configurationJsonHelper;

	public StartInteractor(Context context, PrefsHelper prefsHelper, JsonHelper<Configuration> configurationJsonHelper) {
		this.context = context;
		this.prefsHelper = prefsHelper;
		this.configurationJsonHelper = configurationJsonHelper;
	}

	public void loadConfiguration(Subscriber<Configuration> subscriber) {
		if (prefsHelper.getConfiguration(context).isEmpty()) {
			loadFromApi(subscriber, prefsHelper);
		} else {
			loadFromPrefs(subscriber, prefsHelper);
		}
	}

	private void loadFromApi(Subscriber<Configuration> subscriber, PrefsHelper prefsHelper) {
		RestClient.getService().getConfiguration()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.subscribe(new Subscriber<Configuration>() {
				@Override
				public void onCompleted() {
					subscriber.onCompleted();
				}

				@Override
				public void onError(Throwable e) {
					subscriber.onError(e);
				}

				@Override
				public void onNext(Configuration configuration) {
					prefsHelper.setConfiguration(context, configurationJsonHelper.toJson(configuration, Configuration.class));
					subscriber.onNext(configuration);
				}
			});
	}

	private void loadFromPrefs(Subscriber<Configuration> subscriber, PrefsHelper prefsHelper) {
		// TODO: Create a task to delete the the configuration every few days
		Observable.create(new Observable.OnSubscribe<Configuration>() {
			@Override
			public void call(Subscriber<? super Configuration> subscriber) {
				try {
					final String configurationJson = prefsHelper.getConfiguration(context);
					final Configuration configuration = configurationJsonHelper.fromJson(configurationJson, Configuration.class);
					subscriber.onNext(configuration);
				} catch (IOException e) {
					e.printStackTrace();
					subscriber.onError(e);
				}
				subscriber.onCompleted();
			}
		}).observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io())
			.subscribe(subscriber);
	}

}

