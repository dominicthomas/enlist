package com.dogoodapps.enlist.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.lang.reflect.Type;

public class JsonHelper<T> {

	public String toJson(T clazz, Type type) {
		final Moshi moshi = new Moshi.Builder().build();
		final JsonAdapter<T> jsonAdapter = moshi.adapter(type);
		return jsonAdapter.toJson(clazz);
	}

	public T fromJson(String json, Type type) throws IOException {
		final Moshi moshi = new Moshi.Builder().build();
		final JsonAdapter<T> jsonAdapter = moshi.adapter(type);
		return jsonAdapter.fromJson(json);
	}

}
