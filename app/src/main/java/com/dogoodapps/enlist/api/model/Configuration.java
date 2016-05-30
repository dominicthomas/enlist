package com.dogoodapps.enlist.api.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

	private Images images;

	@Json(name = "change_keys")
	private List<String> changeKeys = new ArrayList<>();

	public Images getImages() {
		return images;
	}

	public List<String> getChangeKeys() {
		return changeKeys;
	}

}