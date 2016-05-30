package com.dogoodapps.enlist.api.interactors;

import com.dogoodapps.enlist.api.RestClient;
import com.dogoodapps.enlist.api.response.MoviesResponse;
import com.dogoodapps.enlist.api.response.PeopleResponse;
import com.dogoodapps.enlist.api.response.TvShowResponse;
import com.dogoodapps.enlist.app.BaseInteractor;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MdbInteractor extends BaseInteractor {

	public Subscription getMovies(Subscriber<MoviesResponse> subscriber) {
		return RestClient.getService().getTopRatedMovies()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io()).subscribe(subscriber);
	}

	public Subscription getTvShows(Subscriber<TvShowResponse> subscriber) {
		return RestClient.getService().getTopRatedTvShows()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io()).subscribe(subscriber);
	}

	public Subscription getPeople(Subscriber<PeopleResponse> subscriber) {
		return RestClient.getService().getPopularPeople()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io()).subscribe(subscriber);
	}

}
