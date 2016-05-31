package com.dogoodapps.enlist.ui.presenters;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.interactors.MainInteractor;
import com.dogoodapps.enlist.app.BasePresenter;
import com.dogoodapps.enlist.ui.adapters.MainPagerAdapter;
import com.dogoodapps.enlist.mvp.MainMVP;
import com.dogoodapps.enlist.ui.views.MoviesFragment;
import com.dogoodapps.enlist.ui.views.PeopleFragment;
import com.dogoodapps.enlist.ui.views.TVShowFragment;

public class MainPresenter extends BasePresenter<MainMVP.View, MainInteractor> implements MainMVP.Presenter {

	public MainPresenter(MainMVP.View view) {
		super(view, null); // TODO: No interactor
	}

	@Override
	public void setupViewPager(Context context, FragmentManager supportFragmentManager) {
		final MainPagerAdapter adapter = new MainPagerAdapter(supportFragmentManager);
		adapter.addFragment(new MoviesFragment(), context.getString(R.string.movies_title));
		adapter.addFragment(new TVShowFragment(), context.getString(R.string.tvshows_title));
		adapter.addFragment(new PeopleFragment(), "People");
		getView().setAdapter(adapter);
	}
}
