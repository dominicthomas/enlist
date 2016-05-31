package com.dogoodapps.enlist.ui.views;

import com.dogoodapps.enlist.api.interactors.MdbInteractor;
import com.dogoodapps.enlist.api.model.Movie;
import com.dogoodapps.enlist.app.BaseMVPListFragment;
import com.dogoodapps.enlist.ui.adapters.MoviesAdapter;
import com.dogoodapps.enlist.mvp.MoviesMVP;
import com.dogoodapps.enlist.ui.presenters.MoviesPresenter;

import java.util.List;

public class MoviesFragment extends BaseMVPListFragment<MoviesPresenter, MoviesAdapter> implements MoviesMVP.View {

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	protected MoviesAdapter initialiseAdapter() {
		return new MoviesAdapter(getActivity());
	}

	@Override
	protected MoviesPresenter initialisePresenter() {
		return new MoviesPresenter(this, new MdbInteractor());
	}

	@Override
	public void displayResults(List<Movie> movies) {
		getAdapter().setList(movies);
		getAdapter().refresh();
	}
}
