package com.dogoodapps.enlist;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dogoodapps.enlist.mvp.MainMVP;

import butterknife.InjectView;

public class MainActivity extends BaseActivity implements MainMVP.View {

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
		setupViewPager(viewPager);
		tabLayout.setupWithViewPager(viewPager);
	}

	private void setupViewPager(ViewPager viewPager) {
		final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new MoviesFragment(), "ONE");
		adapter.addFragment(new MoviesFragment(), "TWO");
		adapter.addFragment(new MoviesFragment(), "THREE");
		viewPager.setAdapter(adapter);
	}

}
