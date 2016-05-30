package com.dogoodapps.enlist.ui.presenters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.ui.mvp.MainMVP;
import com.dogoodapps.enlist.ui.adapters.MainPagerAdapter;
import com.dogoodapps.enlist.ui.views.MoviesFragment;
import com.dogoodapps.enlist.ui.views.TVShowFragment;

public class MainPresenter extends BasePresenter<MainMVP.View> implements MainMVP.Presenter {

	public MainPresenter(MainMVP.View view) {
		super(view);
	}

	@Override
	public void setupViewPager(Context context, FragmentManager supportFragmentManager, ViewPager viewPager) {
		final MainPagerAdapter adapter = new MainPagerAdapter(supportFragmentManager);
		adapter.addFragment(new MoviesFragment(), context.getString(R.string.movies_title));
		adapter.addFragment(new TVShowFragment(), context.getString(R.string.tvshows_title));
		adapter.addFragment(new Fragment(), "People");
		viewPager.setAdapter(adapter);
	}
}
