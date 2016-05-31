package com.dogoodapps.enlist.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

// TODO: Tests
public abstract class BaseMVPActivity<P extends BasePresenter> extends AppCompatActivity {

	private P presenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.inject(this);
		this.presenter = initialisePresenter();
	}

	@Override
	protected void onStart() {
		super.onStart();
		init();
	}

	protected abstract int getLayoutId();

	protected abstract P initialisePresenter();

	protected abstract void init();

	public P getPresenter() {
		return presenter;
	}
}
