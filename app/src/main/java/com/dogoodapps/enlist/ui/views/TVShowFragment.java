package com.dogoodapps.enlist.ui.views;

import com.dogoodapps.enlist.api.model.TvShow;
import com.dogoodapps.enlist.ui.BaseMVPListFragment;
import com.dogoodapps.enlist.ui.adapters.TvShowAdapter;
import com.dogoodapps.enlist.ui.mvp.TvShowMVP;
import com.dogoodapps.enlist.ui.presenters.TvShowPresenter;

import java.util.List;

public class TVShowFragment extends BaseMVPListFragment<TvShowPresenter, TvShowAdapter> implements TvShowMVP.View {

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	protected TvShowAdapter initialiseAdapter() {
		return new TvShowAdapter(getActivity());
	}

	@Override
	protected TvShowPresenter initialisePresenter() {
		return new TvShowPresenter(this);
	}

	@Override
	public void displayResults(List<TvShow> tvShows) {
		getAdapter().setList(tvShows);
		getAdapter().refresh();
	}
}
