package com.mojir.restful_core.dtos;

/**
 * Paging capsulations used by dao and search services
 * @author Navid
 *
 */
public class Paging {
	private int pageSize;
	private int currentPage;
	private long totalCount;
	
	public Paging() {
		pageSize = 10;
		currentPage = 0;
		totalCount = 0;
	}
	
	public Paging(int pageSize, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
