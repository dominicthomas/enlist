package com.dogoodapps.enlist.api.subscribers;

import rx.Subscriber;

public abstract class MdbSubscriber<T> extends Subscriber<T> {

	@Override
	public void onCompleted() {

	}

	@Override
	public void onError(Throwable e) {

	}

	@Override
	public void onNext(T t) {
		onLoad(t);
	}

	public abstract void onLoad(T t);
}
