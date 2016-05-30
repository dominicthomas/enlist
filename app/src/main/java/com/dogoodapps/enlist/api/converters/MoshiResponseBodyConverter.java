package com.dogoodapps.enlist.api.converters;

import com.squareup.moshi.JsonAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Source: https://github.com/square/retrofit/tree/master/retrofit-converters/moshi
 */
final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {

	private final JsonAdapter<T> adapter;

	MoshiResponseBodyConverter(JsonAdapter<T> adapter) {
		this.adapter = adapter;
	}

	@Override public T convert(ResponseBody value) throws IOException {
		try {
			return adapter.fromJson(value.source());
		} finally {
			value.close();
		}
	}
}
