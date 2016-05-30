package com.dogoodapps.enlist.ui.presenters;

public abstract class BasePresenter<V> {

	V view;

	public BasePresenter(V view) {
		this.view = view;
	}

	public V getView(){
		return view;
	}

}
