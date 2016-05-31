package com.dogoodapps.enlist.utils;

import com.dogoodapps.enlist.api.model.Configuration;
import com.dogoodapps.enlist.api.model.Images;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class JsonHelperTest {

	JsonHelper<Configuration> configurationJsonHelper;

	Configuration configuration;

	final String json = "{\"change_keys\":[\"String1\",\"String2\",\"String3\"]," +
		"\"images\":{\"backdrop_sizes\":[],\"logo_sizes\":[],\"poster_sizes\":[]," +
		"\"profile_sizes\":[],\"still_sizes\":[]}}";

	@Before
	public void setup() {
		configurationJsonHelper = new JsonHelper<>();
		final List<String> changeKeys = new ArrayList<>();
		changeKeys.add("String1");
		changeKeys.add("String2");
		changeKeys.add("String3");
		configuration = new Configuration(new Images(), changeKeys);
	}

	@Test
	public void testToJson() {
		final String toJson = configurationJsonHelper.toJson(configuration, Configuration.class);
		assertEquals(json, toJson);
	}

	@Test
	public void testFromJson() throws IOException {
		final Configuration configurationFromJson = configurationJsonHelper.fromJson(json, Configuration.class);
		configurationFromJson.getChangeKeys();
		boolean containsAll = configurationFromJson.getChangeKeys()
			.containsAll(configuration.getChangeKeys());
		assertTrue(containsAll);
	}

}
