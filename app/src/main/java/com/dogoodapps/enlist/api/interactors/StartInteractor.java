package com.dogoodapps.enlist.api.interactors;

import android.content.Context;

import com.dogoodapps.enlist.api.RestClient;
import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.app.BaseInteractor;
import com.dogoodapps.enlist.utils.JsonHelper;
import com.dogoodapps.enlist.utils.PrefsHelper;

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

	public Observable<Configuration> loadConfiguration() {
		return Observable.create((Observable.OnSubscribe<Configuration>)
			new Observable.OnSubscribe<Configuration>() {
				@Override
				public void call(Subscriber<? super Configuration> subscriber) {
					if (prefsHelper.getConfiguration(context).isEmpty()) {
						RestClient.getService().getConfiguration()
							.observeOn(AndroidSchedulers.mainThread())
							.subscribeOn(Schedulers.io()).subscribe(new Subscriber<Configuration>() {
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
				}
			});
	}

}
