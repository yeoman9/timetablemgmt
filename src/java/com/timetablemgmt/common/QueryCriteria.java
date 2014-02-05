/**
 *
 */
package com.timetablemgmt.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ninad
 *
 */
public class QueryCriteria {

    private boolean needTotalCount = true;
    private int totalCount = 0;
    private int startRow = 0;
    private int batchSize = -1;
    private boolean or = false;
    private Map<String, Boolean> orderBy = new LinkedHashMap<String, Boolean>();
    private List<String> groupBy = new ArrayList<String>();    
    private Map<String, QueryCriterion> queryCriterias = new LinkedHashMap<String, QueryCriterion>();
    private List<QueryCriteria> subQueryCriteria = null;

    public Map<String, Boolean> getOrderBy() {
        return orderBy;
    }

    public void addOrderBy(String fieldName, boolean ascending) {
        orderBy.put(fieldName, Boolean.valueOf(ascending));
    }

    public List<String> getGroupBy() {
        return groupBy;
    }

    public void addGroupBy(String fieldName) {
        groupBy.add(fieldName);
    }

    public List<QueryCriteria> getSubQueryCriteria() {
        return subQueryCriteria;
    }

    public void addSubQueryCriteria(QueryCriteria subQueryCriteria) {
    	if(this.subQueryCriteria== null) {
    		this.subQueryCriteria = new ArrayList<QueryCriteria>();
    	}
        this.subQueryCriteria.add(subQueryCriteria);
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public Map<String, QueryCriterion> getqueryCriterias() {
        return queryCriterias;
    }

    public void addQueryCriteria(String propertyName, QueryCriterion criteria) {
        queryCriterias.put(propertyName, criteria);
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String toWhereClause() {
        if (queryCriterias == null || queryCriterias.size() == 0) {
            return null;
        }
        String[] keys = queryCriterias.keySet().toArray(new String[queryCriterias.size()]);
        QueryCriterion criterion = null;
        String whereClauseTag = "";
        StringBuffer sb = null;
        String andOr = " OR ";
        if (!isOr()) {
            andOr = " AND ";
        }

        for (String key : keys) {
            criterion = queryCriterias.get(key);
            criterion.getAttrName();
            criterion.getAttrValue();
            whereClauseTag = QueryCriterion.whereClauseTags.get(criterion.getRestrictions());
            whereClauseTag = whereClauseTag.replaceAll("$", criterion.getAttrValue().toString());
            if (sb == null) {
                sb = new StringBuffer();
                sb.append(" (" + whereClauseTag);
            } else {
                sb.append(andOr + whereClauseTag);
            }
        }
        return null;
    }

    /**
     * @return the or
     */
    public boolean isOr() {
        return or;
    }

    /**
     * @param or the or to set
     */
    public void setOr(boolean or) {
        this.or = or;
    }
}
