package com.dogoodapps.enlist.ui.mvp;

import com.dogoodapps.enlist.api.model.TvShow;

import java.util.List;

public class TvShowMVP {

	public interface View {
		void displayResults(List<TvShow> tvShows);
	}

	public interface Presenter {
		void loadResults();
	}
}
