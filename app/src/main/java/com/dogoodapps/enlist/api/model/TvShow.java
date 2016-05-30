package com.dogoodapps.enlist.api.model;

import com.squareup.moshi.Json;

import java.util.List;

public class TvShow extends BaseMdbItem {

	private String name;

	@Json(name = "original_name")
	private String originalName;

	@Json(name = "first_air_date")
	private String firstAirDate;

	@Json(name = "origin_country")
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
