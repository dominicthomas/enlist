package com.dogoodapps.enlist.api.response;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMdbResponse<T> {

	private Integer page;

	private List<T> results = new ArrayList<>();

	private Integer totalResults;

	private Integer totalPages;

	public Integer getPage() {
		return page;
	}

	public List<T> getResults() {
		return results;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

}