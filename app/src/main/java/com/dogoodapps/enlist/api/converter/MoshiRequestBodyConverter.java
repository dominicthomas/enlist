package com.dogoodapps.enlist.api.converter;

import com.squareup.moshi.JsonAdapter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 * Source: https://github.com/square/retrofit/tree/master/retrofit-converters/moshi
 */
final class MoshiRequestBodyConverter<T> implements Converter<T, RequestBody> {
	private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

	private final JsonAdapter<T> adapter;

	MoshiRequestBodyConverter(JsonAdapter<T> adapter) {
		this.adapter = adapter;
	}

	@Override public RequestBody convert(T value) throws IOException {
		Buffer buffer = new Buffer();
		adapter.toJson(buffer, value);
		return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
	}
}
