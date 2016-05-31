package com.dogoodapps.enlist.ui.views;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.interactors.LauncherInteractor;
import com.dogoodapps.enlist.app.BaseMVPActivity;
import com.dogoodapps.enlist.ui.mvp.LauncherMVP;
import com.dogoodapps.enlist.ui.presenters.LauncherPresenter;

public class LauncherActivity extends BaseMVPActivity<LauncherPresenter> implements LauncherMVP.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected LauncherPresenter initialisePresenter() {
        return new LauncherPresenter(this, new LauncherInteractor());
    }

    @Override
    protected void init() {
        // TODO: This will need to load and save the configuration - Pass onto the main activity
    }

}
