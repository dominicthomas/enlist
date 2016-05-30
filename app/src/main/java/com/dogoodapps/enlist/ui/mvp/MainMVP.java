package com.dogoodapps.enlist.ui.mvp;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.dogoodapps.enlist.ui.adapters.MainPagerAdapter;

public class MainMVP {

	public interface View {
		void setAdapter(MainPagerAdapter adapter);
	}

	public interface Presenter {
		void setupViewPager(Context context, FragmentManager supportFragmentManager);
	}

}
