package com.dogoodapps.enlist.api.model;

public class Movie extends BaseMdbItem {

	private String title;

	private String originalTitle;

	private String releaseDate;

	private Boolean video;

	private Boolean adult;

	public String getTitle() {
		return title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Boolean getVideo() {
		return video;
	}

	public Boolean getAdult() {
		return adult;
	}
}
