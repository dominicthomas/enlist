package com.dogoodapps.enlist.api;

import com.dogoodapps.enlist.api.converters.MoshiConverterFactory;
import com.dogoodapps.enlist.api.response.MoviesResponse;
import com.dogoodapps.enlist.api.response.PeopleResponse;
import com.dogoodapps.enlist.api.response.TvResponse;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.schedulers.Schedulers;

public final class RestClient {

	private static final String API_URL = "https://api.themoviedb.org/";

	private static final String API_KEY = "0a08e38b874d0aa2d426ffc04357069d";

	private static final String VERSION = "3";

	private static final String API_KEY_PARAM = "api_key";

	private static TheMovieDbService theMovieDbService;

	public static TheMovieDbService getService() {

		if (theMovieDbService == null) {

			final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
			httpClient.addInterceptor(new Interceptor() {
				@Override
				public okhttp3.Response intercept(Chain chain) throws IOException {
					Request request = chain.request();
					final HttpUrl url = request.url().newBuilder()
						.addQueryParameter(API_KEY_PARAM, API_KEY).build();
					request = request.newBuilder().url(url).build();
					return chain.proceed(request);
				}
			});

			final Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(API_URL)
				.client(httpClient.build())
				.addConverterFactory(MoshiConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
				.build();

			theMovieDbService = retrofit.create(TheMovieDbService.class);
		}
		return theMovieDbService;
	}

	// TODO: Add a version path segment!
	public interface TheMovieDbService {

		@GET(VERSION + "/movie/top_rated")
		Observable<MoviesResponse> getTopRatedMovies();

		@GET(VERSION + "/tv/top_rated")
		Observable<TvResponse> getTopRatedTvShows();

		@GET(VERSION + "/person/popular")
		Observable<PeopleResponse> getPopularPeople();

	}

}