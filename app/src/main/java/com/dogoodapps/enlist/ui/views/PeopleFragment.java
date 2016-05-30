package com.dogoodapps.enlist.ui.views;

import com.dogoodapps.enlist.api.model.Person;
import com.dogoodapps.enlist.ui.BaseMVPListFragment;
import com.dogoodapps.enlist.ui.adapters.MoviesAdapter;
import com.dogoodapps.enlist.ui.mvp.PeopleMVP;
import com.dogoodapps.enlist.ui.presenters.PeoplePresenter;

import java.util.List;

public class PeopleFragment extends BaseMVPListFragment<PeoplePresenter, MoviesAdapter> implements PeopleMVP.View {

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	protected MoviesAdapter initialiseAdapter() {
		return new MoviesAdapter(getActivity());
	}

	@Override
	protected PeoplePresenter initialisePresenter() {
		return new PeoplePresenter(this);
	}


	@Override
	public void displayResults(List<Person> people) {

	}
}
