package com.mojir.sample_rest;

import com.mojir.restful_core.dtos.SearchRequestDto;

/**
 * Search request object for student entity
 * @author Navid
 *
 */
public class StudentSearchReqDto extends SearchRequestDto {

	public class Filters{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	private Filters filters;

	@Override
	public void prepareFiltersWhereClauses() {
		if(filters != null)
		{
			addLikeClause("name", filters.getName());
		}		
	}

	public Filters getFilters() {
		return filters;
	}

	public void setFilters(Filters filters) {
		this.filters = filters;
	}
	
	

}
