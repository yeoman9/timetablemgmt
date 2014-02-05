package com.timetablemgmt.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @deprecated deprecated by QueryCriterion
 * @author ninad
 *
 */
public class SearchCriteria {

	boolean needTotalCount;
	int totalCount;
	int startRow;
	int batchSize;
	Map<String, Object> searchParamValues;

	public SearchCriteria() {
		needTotalCount = true;
		startRow = 0;
		totalCount = 0;
		batchSize = 20;
		searchParamValues = new HashMap<String, Object>();
	}

	public boolean isNeedTotalCount() {
		return needTotalCount;
	}

	public void setNeedTotalCount(boolean needTotalCount) {
		this.needTotalCount = needTotalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public void addSearchParamValue(String propertyName, Object value) {
		searchParamValues.put(propertyName, value);
	}

	public Map<String, Object> getSearhParamValues() {
		return this.searchParamValues;
	}

}
