package com.dogoodapps.enlist.api.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMdbItem {

	@Json(name = "poster_path")
	private String posterPath;

	private String overview;

	@Json(name = "genre_ids")
	private List<Integer> genreIds = new ArrayList<>();

	private Integer id;

	@Json(name = "original_language")
	private String originalLanguage;

	@Json(name = "backdrop_path")
	private String backdropPath;

	private Double popularity;

	@Json(name = "vote_count")
	private Integer voteCount;

	@Json(name = "vote_average")
	private Float voteAverage;

	public String getPosterPath() {
		return posterPath;
	}

	public String getOverview() {
		return overview;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public Integer getId() {
		return id;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public Double getPopularity() {
		return popularity;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public Float getVoteAverage() {
		return voteAverage;
	}

}

