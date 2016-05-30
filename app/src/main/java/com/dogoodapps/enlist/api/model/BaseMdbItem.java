package com.dogoodapps.enlist.api.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMdbItem {

	private String posterPath;

	private String overview;

	private List<Integer> genreIds = new ArrayList<>();

	private Integer id;

	private String originalLanguage;

	private String backdropPath;

	private Double popularity;

	private Integer voteCount;

	private Integer voteAverage;

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

	public Integer getVoteAverage() {
		return voteAverage;
	}

}

