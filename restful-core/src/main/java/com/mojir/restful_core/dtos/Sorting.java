package com.mojir.restful_core.dtos;

/**
 * Encapsulates values needed for sorting. used by dao and search service.
 * @author Navid
 *
 */
public class Sorting {
	private String sortField;
	private boolean ascending;
	
	public Sorting() {
	}
	
	public Sorting(String sortField, boolean ascending) {
		this.sortField = sortField;
		this.ascending = ascending;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public boolean isAscending() {
		return ascending;
	}
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}
	
	
}
