package com.mojir.restful_core.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class for requests of search service.
 * They contain paging, sorting and some filters.
 * The implementor of this class should prepare where clauses of the filters. 
 * @author Navid
 *
 */
//TODO: add other utility methods like addLikeClause
public abstract class SearchRequestDto {
	private Paging paging;
	private Sorting sorting;
	
	private List<WhereClause> filtersWhereClauses;
	
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public Sorting getSorting() {
		return sorting;
	}
	public void setSorting(Sorting sorting) {
		this.sorting = sorting;
	}
	
	
	public List<WhereClause> getFiltersWhereClauses() {
		if(filtersWhereClauses == null)
			prepareFiltersWhereClauses();
		return filtersWhereClauses;
	}
	public abstract void prepareFiltersWhereClauses();

	protected void addLikeClause(String columnName, String value)
	{
		if(value != null)
			addWhereClause(new WhereClause(columnName, "like", "%" + value + "%"));
	}
	
	protected void addWhereClause(WhereClause whereClause)
	{
			if(this.filtersWhereClauses == null)
				this.filtersWhereClauses = new ArrayList<WhereClause>();
			this.filtersWhereClauses.add(whereClause);
	}
	
}
