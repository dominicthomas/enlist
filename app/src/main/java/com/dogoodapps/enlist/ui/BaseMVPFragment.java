package com.dogoodapps.enlist.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dogoodapps.enlist.ui.presenters.BasePresenter;

import butterknife.ButterKnife;


public abstract class BaseMVPFragment<P extends BasePresenter> extends Fragment {

	private P presenter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.presenter = initialisePresenter();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(getLayoutId(), container, false);
		ButterKnife.inject(this, view);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		init();
	}

	protected abstract int getLayoutId();

	protected abstract P initialisePresenter();

	protected abstract void init();

	public P getPresenter() {
		return presenter;
	}

}
