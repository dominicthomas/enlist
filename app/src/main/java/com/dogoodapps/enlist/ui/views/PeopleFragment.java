package com.dogoodapps.enlist.ui.views;

import android.widget.TextView;

import com.dogoodapps.enlist.R;
import com.dogoodapps.enlist.api.model.Person;
import com.dogoodapps.enlist.api.model.TvShow;
import com.dogoodapps.enlist.ui.BaseMVPFragment;
import com.dogoodapps.enlist.ui.mvp.PeopleMVP;
import com.dogoodapps.enlist.ui.mvp.TvShowMVP;
import com.dogoodapps.enlist.ui.presenters.PeoplePresenter;
import com.dogoodapps.enlist.ui.presenters.TvShowPresenter;

import java.util.List;

import butterknife.InjectView;

public class PeopleFragment extends BaseMVPFragment<PeoplePresenter> implements PeopleMVP.View {

	@InjectView(R.id.textView_results)
	TextView resultsTextView;

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_people;
	}

	@Override
	protected PeoplePresenter initialisePresenter() {
		return new PeoplePresenter(this);
	}

	@Override
	protected void init() {
		getPresenter().loadResults();
	}

	@Override
	public void displayResults(List<Person> people) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Person person : people) {
			stringBuilder.append(person.getName() + "\n");
		}
		resultsTextView.setText(stringBuilder.toString());
	}
}
