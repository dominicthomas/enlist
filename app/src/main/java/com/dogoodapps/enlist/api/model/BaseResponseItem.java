package com.dogoodapps.enlist.api.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseResponseItem {

	private String posterPath;

	private Boolean adult;

	private String overview;

	private String releaseDate;

	private List<Integer> genreIds = new ArrayList<>();

	private Integer id;

	private String originalTitle;

	private String originalLanguage;

	private String title;

	private String backdropPath;

	private Double popularity;

	private Integer voteCount;

	private Boolean video;

	private Integer voteAverage;

	public String getPosterPath() {
		return posterPath;
	}

	public Boolean getAdult() {
		return adult;
	}

	public String getOverview() {
		return overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public Integer getId() {
		return id;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getTitle() {
		return title;
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

	public Boolean getVideo() {
		return video;
	}

	public Integer getVoteAverage() {
		return voteAverage;
	}

}

