package com.dogoodapps.enlist.api.model;

import com.squareup.moshi.Json;

public class KnownFor extends Movie {

	@Json(name = "media_type")
	private String mediaType;

	public String getMediaType() {
		return mediaType;
	}
}
