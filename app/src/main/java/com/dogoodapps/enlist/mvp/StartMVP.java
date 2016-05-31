package com.dogoodapps.enlist.mvp;

import com.dogoodapps.enlist.api.model.Configuration;

public class StartMVP {

	public interface View {
		void onLoaded(Configuration configuration);
	}

	public interface Presenter {
		void loadConfiguration();
	}

}
