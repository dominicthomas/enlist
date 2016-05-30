package com.dogoodapps.enlist.ui.views;

import android.widget.TextView;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.model.TvShow;
import com.dogoodapps.enlist.ui.BaseMVPFragment;
import com.dogoodapps.enlist.ui.mvp.TvShowMVP;
import com.dogoodapps.enlist.ui.presenters.TvShowPresenter;

import java.util.List;

import butterknife.InjectView;

public class TVShowFragment extends BaseMVPFragment<TvShowPresenter> implements TvShowMVP.View {

	// TODO: Need a base recycler list fragment to display results

	// TODO: Parcelor will send to a details screen

	@InjectView(R.id.textView_results)
	TextView resultsTextView;

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_tvshows;
	}

	@Override
	protected TvShowPresenter initialisePresenter() {
		return new TvShowPresenter(this);
	}

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	public void displayResults(List<TvShow> tvShows) {
		resultsTextView.setText("TvShows:" + tvShows.size());
	}
}
