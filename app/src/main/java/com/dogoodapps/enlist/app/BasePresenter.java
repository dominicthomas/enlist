package com.dogoodapps.enlist.app;

public abstract class BasePresenter<V, I extends BaseInteractor> {

	V view;

	I interactor;

	public BasePresenter(V view, I interactor) {
		this.view = view;
		this.interactor = interactor;
	}

	public V getView(){
		return view;
	}

	public I getInteractor(){
		return interactor;
	}
}
