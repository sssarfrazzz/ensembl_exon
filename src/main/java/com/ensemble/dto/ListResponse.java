package com.ensemble.dto;

import java.util.List;
import java.util.Set;

public class ListResponse {

	private long totalResults;
	
	private int startIndex;
	
	private int itemsPerPage;
	
	private  List<?> resources;

	public ListResponse(long totalResults, int startIndex, int itemsPerPage, List<?> resources) {
		super();
		this.totalResults = totalResults;
		this.startIndex = startIndex;
		this.itemsPerPage = itemsPerPage;
		this.resources = resources;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public List<?> getResources() {
		return resources;
	}

	public void setResources(List<?> resources) {
		this.resources = resources;
	}
	
	
}
