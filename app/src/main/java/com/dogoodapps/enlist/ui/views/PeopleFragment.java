package com.dogoodapps.enlist.ui.views;

import com.dogoodapps.enlist.api.interactors.MdbInteractor;
import com.dogoodapps.enlist.api.model.Person;
import com.dogoodapps.enlist.app.BaseMVPListFragment;
import com.dogoodapps.enlist.ui.adapters.PeopleAdapter;
import com.dogoodapps.enlist.ui.mvp.PeopleMVP;
import com.dogoodapps.enlist.ui.presenters.PeoplePresenter;

import java.util.List;

public class PeopleFragment extends BaseMVPListFragment<PeoplePresenter, PeopleAdapter> implements PeopleMVP.View {

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	protected PeopleAdapter initialiseAdapter() {
		return new PeopleAdapter(getActivity());
	}

	@Override
	protected PeoplePresenter initialisePresenter() {
		return new PeoplePresenter(this, new MdbInteractor());
	}

	@Override
	public void displayResults(List<Person> people) {
		getAdapter().setList(people);
		getAdapter().refresh();
	}
}
