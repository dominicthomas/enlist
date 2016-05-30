package com.dogoodapps.enlist.ui.views;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.ui.adapters.MainPagerAdapter;
import com.dogoodapps.enlist.ui.mvp.MainMVP;
import com.dogoodapps.enlist.ui.BaseMVPActivity;
import com.dogoodapps.enlist.ui.presenters.MainPresenter;

import butterknife.InjectView;

public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainMVP.View {

	@InjectView(R.id.toolbar)
	public Toolbar toolbar;

	@InjectView(R.id.tabs)
	public TabLayout tabLayout;

	@InjectView(R.id.viewpager)
	public ViewPager viewPager;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void init() {
		setSupportActionBar(toolbar);
		getPresenter().setupViewPager(this, getSupportFragmentManager());
		tabLayout.setupWithViewPager(viewPager);
	}

	@Override
	protected MainPresenter initialisePresenter() {
		return new MainPresenter(this);
	}

	@Override
	public void setAdapter(MainPagerAdapter adapter) {
		viewPager.setAdapter(adapter);
	}

}
