package com.dogoodapps.enlist.mvp;

import com.dogoodapps.enlist.api.model.Person;

import java.util.List;

public class PeopleMVP {

	public interface View {
		void displayResults(List<Person> people);
	}

	public interface Presenter {
		void loadResults();
	}
}
