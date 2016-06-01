package com.dogoodapps.enlist.mvp;

import android.content.Context;

import com.dogoodapps.enlist.api.model.Configuration;

public class StartMVP {

	public interface View {
		void onLoaded(Configuration configuration);
	}

	public interface Presenter {
		void loadConfiguration();

		void loadActivity(Context context, Class<?> cls);
	}

}
