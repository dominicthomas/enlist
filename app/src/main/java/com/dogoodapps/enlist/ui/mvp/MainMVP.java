package com.dogoodapps.enlist.ui.mvp;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

public class MainMVP  {

	public interface View {

	}

	public interface Presenter {
		void setupViewPager(Context context, FragmentManager supportFragmentManager, ViewPager viewPager);
	}

}
