package com.dogoodapps.enlist.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsHelper {

	private static final String PREFS = "prefs";

	private class Keys {
		private static final String CONFIGURATION = "configuration";
	}

	public PrefsHelper() {
	}

	private SharedPreferences getPrefs(Context context) {
		return context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
	}

	private SharedPreferences.Editor getEditor(SharedPreferences sharedPreferences) {
		return sharedPreferences.edit();
	}

	public void setConfiguration(Context context, String configurationJson) {
		getEditor(getPrefs(context)).putString(Keys.CONFIGURATION, configurationJson).commit();
	}

	public String getConfiguration(Context context) {
		return getPrefs(context).getString(Keys.CONFIGURATION, "");
	}

}
