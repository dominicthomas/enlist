package com.dogoodapps.enlist.ui.views;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.interactors.StartInteractor;
import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.app.BaseMVPActivity;
import com.dogoodapps.enlist.mvp.StartMVP;
import com.dogoodapps.enlist.ui.presenters.StartPresenter;
import com.dogoodapps.enlist.utils.JsonHelper;
import com.dogoodapps.enlist.utils.PrefsHelper;

public class StartActivity extends BaseMVPActivity<StartPresenter> implements StartMVP.View {

	@Override
	protected int getLayoutId() {
		return R.layout.activity_launcher;
	}

	@Override
	protected StartPresenter initialisePresenter() {
		final StartInteractor startInteractor = new StartInteractor(this, new PrefsHelper(), new JsonHelper<>());
		return new StartPresenter(this, startInteractor);
	}

	@Override
	protected void init() {
		getPresenter().loadConfiguration();
	}

	@Override
	public void onLoaded(Configuration configuration) {
		// TODO: Parcel up the configuration and pass through to activity
		getPresenter().loadActivity(this, MainActivity.class);
	}

}
