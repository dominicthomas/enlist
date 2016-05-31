package com.dogoodapps.enlist.mvp;

import com.dogoodapps.enlist.api.model.Movie;

import java.util.List;

public class MoviesMVP {

	public interface View {
		void displayResults(List<Movie> movies);
	}

	public interface Presenter {
		void loadResults();
	}
}
