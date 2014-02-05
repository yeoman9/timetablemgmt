/**
 *
 */
package com.timetablemgmt.common;

import java.util.List;

/**
 * @author ninad
 *
 */
public class QueryResults<E> {

	private QueryCriteria queryCriteria;
	List<E> results;


	public QueryResults(QueryCriteria qc){
		queryCriteria = qc;
	}

	public QueryCriteria getCurrentCriteria() {
		return queryCriteria;
	}

	public QueryCriteria getNextPageCriteria() {
		int currentStartRow = queryCriteria.getStartRow();
		int batchSize = queryCriteria.getBatchSize();
		queryCriteria.setStartRow(currentStartRow+batchSize);
		queryCriteria.setNeedTotalCount(false);
		return queryCriteria;
	}

	public List<E> getResults() {
		return results;
	}

	public void setResults(List<E> results) {
		this.results = results;
	}
}
