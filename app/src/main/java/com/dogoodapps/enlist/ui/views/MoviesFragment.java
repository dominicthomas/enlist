package com.dogoodapps.enlist.ui.views;

import android.widget.TextView;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.model.Movie;
import com.dogoodapps.enlist.ui.BaseMVPFragment;
import com.dogoodapps.enlist.ui.mvp.MoviesMVP;
import com.dogoodapps.enlist.ui.presenters.MoviesPresenter;

import java.util.List;

import butterknife.InjectView;

public class MoviesFragment extends BaseMVPFragment<MoviesPresenter> implements MoviesMVP.View {

	// TODO: Need a base recycler list fragment to display results

	// TODO: Parcelor will send to a details screen

	@InjectView(R.id.textView_results)
	TextView resultsTextView;

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_movies;
	}

	@Override
	protected MoviesPresenter initialisePresenter() {
		return new MoviesPresenter(this);
	}

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	public void displayResults(List<Movie> movies) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Movie movie : movies){
			stringBuilder.append(movie.getTitle() + "\n");
		}
		resultsTextView.setText(stringBuilder.toString());
	}
}
