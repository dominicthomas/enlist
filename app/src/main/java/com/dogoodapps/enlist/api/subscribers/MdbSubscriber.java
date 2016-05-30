package com.dogoodapps.enlist.api.subscribers;

import android.util.Log;

import rx.Subscriber;

public abstract class MdbSubscriber<T> extends Subscriber<T> {

	private static final String TAG = MdbSubscriber.class.getSimpleName();

	@Override
	public void onCompleted() {
		Log.d(TAG, "Complete!");
	}

	@Override
	public void onError(Throwable e) {
		Log.d(TAG, e.getMessage());
	}

	@Override
	public void onNext(T t) {
		onLoad(t);
	}

	public abstract void onLoad(T t);
}
