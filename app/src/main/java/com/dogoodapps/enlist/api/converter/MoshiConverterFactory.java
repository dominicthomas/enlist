package com.dogoodapps.enlist.api.converter;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Source: https://github.com/square/retrofit/tree/master/retrofit-converters/moshi
 */
public final class MoshiConverterFactory extends Converter.Factory {

	/** Create an instance using a default {@link Moshi} instance for conversion. */
	public static MoshiConverterFactory create() {
		return create(new Moshi.Builder().build());
	}

	/** Create an instance using {@code moshi} for conversion. */
	public static MoshiConverterFactory create(Moshi moshi) {
		return new MoshiConverterFactory(moshi, false);
	}

	private final Moshi moshi;
	private final boolean lenient;

	private MoshiConverterFactory(Moshi moshi, boolean lenient) {
		if (moshi == null) throw new NullPointerException("moshi == null");
		this.moshi = moshi;
		this.lenient = lenient;
	}

	/** Return a new factory which uses {@linkplain JsonAdapter#lenient() lenient} adapters. */
	public MoshiConverterFactory asLenient() {
		return new MoshiConverterFactory(moshi, true);
	}

	@Override
	public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
	                                                        Retrofit retrofit) {
		JsonAdapter<?> adapter = moshi.adapter(type);
		if (lenient) {
			adapter = adapter.lenient();
		}
		return new MoshiResponseBodyConverter<>(adapter);
	}

	@Override
	public Converter<?, RequestBody> requestBodyConverter(Type type,
	                                                      Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
		JsonAdapter<?> adapter = moshi.adapter(type);
		if (lenient) {
			adapter = adapter.lenient();
		}
		return new MoshiRequestBodyConverter<>(adapter);
	}
}