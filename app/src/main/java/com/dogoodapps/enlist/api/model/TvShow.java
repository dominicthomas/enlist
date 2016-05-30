package com.dogoodapps.enlist.api.model;

import java.util.List;

public class TvShow extends BaseMdbItem {

	private String name;

	private String originalName;

	private String firstAirDate;

	private List<String> originCountry;

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public String getName() {
		return name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public List<String> getOriginCountry() {
		return originCountry;
	}
}
