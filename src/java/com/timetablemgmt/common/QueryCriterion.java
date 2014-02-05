/**
 *
 */
package com.timetablemgmt.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ninad
 *
 */
public class QueryCriterion {
	private String entityClassName = null;

	public static enum RESTRICTIONS {
		EQ,
		NE,
		LT,
		GT,
		LE,
		GE,
		START_WITH,
		ENDS_WITH,
		CONTAINS,
    IN,
    ISNULL,
    ISNOTNULL,
    BETWEEN
	};

	public static final Map<RESTRICTIONS, String> whereClauseTags = new HashMap<RESTRICTIONS, String>();

	static {
		whereClauseTags.put(RESTRICTIONS.EQ, "=");
		whereClauseTags.put(RESTRICTIONS.NE, "!=");
		whereClauseTags.put(RESTRICTIONS.LT, "<");
		whereClauseTags.put(RESTRICTIONS.GT, ">");
		whereClauseTags.put(RESTRICTIONS.LE, "<=");
		whereClauseTags.put(RESTRICTIONS.GE, ">=");
		whereClauseTags.put(RESTRICTIONS.START_WITH, "LIKE '$%'");
		whereClauseTags.put(RESTRICTIONS.ENDS_WITH, "LIKE '%$'");
		whereClauseTags.put(RESTRICTIONS.CONTAINS, "LIKE '%$%'");
		whereClauseTags.put(RESTRICTIONS.ISNULL, "IS NULL");
		whereClauseTags.put(RESTRICTIONS.ISNOTNULL, "IS NOT NULL");
		whereClauseTags.put(RESTRICTIONS.BETWEEN, "BETWEEN $ AND $");
	}

	public QueryCriterion() {
	}

	public QueryCriterion(String attrName, Object attrValue) {
		this.attrName = attrName;
		this.attrValue = attrValue;
	}

	private String attrName = null;
	private Object attrValue = null;
	private RESTRICTIONS restrictions = RESTRICTIONS.EQ;

	/**
	 * @return the restrictions
	 */
	public RESTRICTIONS getRestrictions() {
		return restrictions;
	}

	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(RESTRICTIONS restrictions) {
		this.restrictions = restrictions;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	/**
	 * @return the attrValue
	 */
	public Object getAttrValue() {
		return attrValue;
	}

	/**
	 * @param attrValue the attrValues to set
	 */
	public void setAttrValue(Object attrValue) {
		this.attrValue = attrValue;
	}

	public static QueryCriterion createCriterion(String fieldName, Object fieldValue) {
		return createCriterion(fieldName, fieldValue, QueryCriterion.RESTRICTIONS.EQ);
	}
		

	public static QueryCriterion createCriterion(String fieldName, Object fieldValue, QueryCriterion.RESTRICTIONS restriction) {
		QueryCriterion criterion = new QueryCriterion();		
		criterion.setRestrictions(restriction);		
        if(fieldName.contains(".")) {
        	criterion.entityClassName = fieldName.substring(0, fieldName.indexOf("."));
        }
        criterion.setAttrName(fieldName);
        criterion.setAttrValue(fieldValue);
        return criterion;
	}

	public String getEntityClassName() {
		return entityClassName;
	}
}