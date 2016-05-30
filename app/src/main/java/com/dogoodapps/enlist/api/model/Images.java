package com.dogoodapps.enlist.api.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class Images {

	@Json(name = "base_url")
	private String baseUrl;

	@Json(name = "secure_base_url")
	private String secureBaseUrl;

	@Json(name = "backdrop_sizes")
	private List<String> backdropSizes = new ArrayList<>();

	@Json(name = "logo_sizes")
	private List<String> logoSizes = new ArrayList<>();

	@Json(name = "poster_sizes")
	private List<String> posterSizes = new ArrayList<>();

	@Json(name = "profile_sizes")
	private List<String> profileSizes = new ArrayList<>();

	@Json(name = "still_sizes")
	private List<String> stillSizes = new ArrayList<>();

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getSecureBaseUrl() {
		return secureBaseUrl;
	}

	public List<String> getBackdropSizes() {
		return backdropSizes;
	}

	public List<String> getLogoSizes() {
		return logoSizes;
	}

	public List<String> getPosterSizes() {
		return posterSizes;
	}

	public List<String> getProfileSizes() {
		return profileSizes;
	}

	public List<String> getStillSizes() {
		return stillSizes;
	}

}
