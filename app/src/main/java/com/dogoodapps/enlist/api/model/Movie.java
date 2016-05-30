package com.dogoodapps.enlist.api.model;

import com.squareup.moshi.Json;

public class Movie extends BaseMdbItem {

	private String title;

	@Json(name = "original_title")
	private String originalTitle;

	@Json(name = "release_date")
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
