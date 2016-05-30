package com.dogoodapps.enlist.api.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String profilePath;

	private Integer id;

	private List<KnownFor> knownFor = new ArrayList<>();

	private String name;

	private Double popularity;

	public String getProfilePath() {
		return profilePath;
	}

	public Integer getId() {
		return id;
	}

	public List<KnownFor> getKnownFor() {
		return knownFor;
	}

	public String getName() {
		return name;
	}

	public Double getPopularity() {
		return popularity;
	}

}