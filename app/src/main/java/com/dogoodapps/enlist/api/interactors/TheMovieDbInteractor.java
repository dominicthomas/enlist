package com.dogoodapps.enlist.api.interactors;

import com.dogoodapps.enlist.api.RestClient;
import com.dogoodapps.enlist.api.model.MoviesResponse;
import com.dogoodapps.enlist.api.model.TvResponse;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TheMovieDbInteractor {

	public static Subscription getMovies(Subscriber<MoviesResponse> subscriber) {
		return RestClient.getService().getTopRatedMovies()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io()).subscribe(subscriber);
	}

	public static Subscription getTvShows(Subscriber<TvResponse> subscriber) {
		return RestClient.getService().getTopRatedTvShows()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribeOn(Schedulers.io()).subscribe(subscriber);
	}
}
