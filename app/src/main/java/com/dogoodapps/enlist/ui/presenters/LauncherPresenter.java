package com.dogoodapps.enlist.ui.presenters;

import com.dogoodapps.enlist.api.interactors.LauncherInteractor;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.ui.mvp.LauncherMVP;

public class LauncherPresenter extends BasePresenter<LauncherMVP.View, LauncherInteractor> implements LauncherMVP.Presenter {
    public LauncherPresenter(LauncherMVP.View view, LauncherInteractor interactor) {
        super(view, interactor);
    }

}
