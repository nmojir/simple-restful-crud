package com.mojir.restful_core.dtos;

import java.util.List;

/**
 * The results of the web service is encapsulated in this object and meta info
 * like totalResultCount is added.
 * @author Navid
 *
 * @param <T>
 */
//TODO: It's more standard to return list of entities here and return the total count
// in a HTTP header like X-TOTAL-COUNT
public class ResultsCapsule <T>{
	private long totalResultCount;
    private List<T> results;
    
    
	public ResultsCapsule(long totalResultCount, List<T> results) {
		super();
		this.totalResultCount = totalResultCount;
		this.results = results;
	}
	
	
	public ResultsCapsule() {
		super();
	}


	public long getTotalResultCount() {
		return totalResultCount;
	}
	public void setTotalResultCount(long totalResultCount) {
		this.totalResultCount = totalResultCount;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
    
    
}
