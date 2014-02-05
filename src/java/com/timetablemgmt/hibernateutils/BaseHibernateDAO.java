package com.timetablemgmt.hibernateutils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.timetablemgmt.common.QueryCriteria;
import com.timetablemgmt.common.QueryCriterion;
import com.timetablemgmt.common.QueryResults;
import com.timetablemgmt.common.SearchCriteria;
import com.timetablemgmt.exceptions.DuplicateEntryException;

import java.util.Collection;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Abstract implementation of BaseDAO interface.
 * 
 * Business DAO classes should extend this class.
 * 
 * @author ninad solutions
 * 
 * @param <T>
 * @param <ID>
 */
@Transactional
public abstract class BaseHibernateDAO<T, ID extends Serializable> extends HibernateUtil
		 implements BaseDAO<T, ID> {

	private Class<T> entityClass;
	private static final Logger logger = Logger
			.getLogger(BaseHibernateDAO.class);

	@SuppressWarnings("unchecked")
	public BaseHibernateDAO() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

        @Override
	public void clear() {
		getCurrentSession().clear();
	}

	@SuppressWarnings("unchecked")
        @Override
	public T findById(ID id) {
		if(id == null) {
			return null;
		}
		T entity = (T) getCurrentSession().get(getEntityClass(), id);
		return entity;
	}

        @Override
	public void flush() {
		getCurrentSession().flush();
	}

        @Override
	public void delete(T entity) {
            getCurrentSession().delete(entity);
	}

        @Override
	public T persist(T entity) {
            try {
                Session session = getCurrentSession();
                Transaction tx = session.beginTransaction();
                session.saveOrUpdate(entity);
                tx.commit();
            } catch (ConstraintViolationException e) {
                throw new DuplicateEntryException(e);
            }
            return entity;
	}

	@SuppressWarnings("unchecked")
	public T findUniqueEntity(SearchCriteria searchCriteria) {
		Criteria criteria = buildCriteria(searchCriteria);
		return (T) criteria.uniqueResult();
	}

	public T findUniqueEntity(QueryCriteria searchCriteria,
			boolean allParameters) {
		Criteria criteria = buildCriteria(searchCriteria);
		T obj = (T) criteria.uniqueResult();
		if (allParameters) {
			Hibernate.initialize(obj);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<T> findEntities(SearchCriteria searchCriteria) {
		return findEntities(searchCriteria, false);
	}

	@SuppressWarnings("unchecked")
	public List<T> findEntities(SearchCriteria searchCriteria, boolean distinct) {
		Criteria criteria = buildCriteria(searchCriteria);
		if (searchCriteria.getBatchSize() != -1) {
			criteria.setFirstResult(searchCriteria.getStartRow());
			criteria.setFetchSize(searchCriteria.getBatchSize());
		}

		if (distinct) {
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		return criteria.list();
	}

	public QueryResults<T> findEntities(QueryCriteria searchCriteria,
			String hql, String countQuery) {
		Query query = getCurrentSession().createQuery(hql);
		if (searchCriteria.getBatchSize() != -1) {
			query.setFirstResult(searchCriteria.getStartRow());
			query.setMaxResults(searchCriteria.getBatchSize());
		}

		List<T> objs = query.list();

		if (searchCriteria.isNeedTotalCount()) {
			query = getCurrentSession().createQuery(countQuery);
			Long totalCount = (Long) query.list().get(0);
			searchCriteria.setTotalCount(totalCount.intValue());
			searchCriteria.setNeedTotalCount(false);
		}
		QueryResults<T> results = new QueryResults<T>(searchCriteria);
		results.setResults(objs);
                
		return results;
	}

	public QueryResults<T> findEntities(QueryCriteria searchCriteria,
			boolean allParameters) {
		Criteria criteria = buildCriteria(searchCriteria);
		@SuppressWarnings("unchecked")
		List<T> objs = criteria.list();
                
		if (allParameters) {
                    for(T obj: objs) {
                        Hibernate.initialize(obj);
                    }
		}
		if (searchCriteria.isNeedTotalCount()) {
			criteria.setProjection(Projections.rowCount());
			int totalCount = 0;
			if(criteria.uniqueResult() !=null){
				totalCount = ((Integer) criteria.uniqueResult()).intValue();
			}
			searchCriteria.setTotalCount(totalCount);
			searchCriteria.setNeedTotalCount(false);
		}

		QueryResults<T> results = new QueryResults<T>(searchCriteria);
		results.setResults(objs);
		return results;
	}

	private Criteria buildCriteria(SearchCriteria searchCriteria) {
		Criteria criteria = getCurrentSession()
				.createCriteria(getEntityClass());
		Map<String, Object> searchValueMap = searchCriteria
				.getSearhParamValues();
		Set<Entry<String, Object>> entrySet = searchValueMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return criteria;
	}

	private Criteria buildCriteria(QueryCriteria searchCriteria) {
		Criteria criteria = getCurrentSession()
				.createCriteria(getEntityClass());
		criteria = createCriteria(searchCriteria, criteria, null,
				new HashSet<String>());
		Map<String, Boolean> orderBy = searchCriteria.getOrderBy();
		List<String> groupBy = searchCriteria.getGroupBy();
		
		if (orderBy != null && orderBy.size() != 0) {
			String[] keys = orderBy.keySet()
					.toArray(new String[orderBy.size()]);
			for (String key : keys) {
				if (orderBy.get(key).booleanValue() == true) {
					criteria.addOrder(org.hibernate.criterion.Order.asc(key));
				} else {
					criteria.addOrder(org.hibernate.criterion.Order.desc(key));
				}
			}
		}
		
		if (groupBy != null && groupBy.size() != 0) {
			ProjectionList projectionList = Projections.projectionList();

			for (String key : groupBy) {
		        projectionList.add(Projections.groupProperty(key));
			}
	        criteria.setProjection(projectionList);
		}
		
		if (searchCriteria.getBatchSize() != -1) {
			criteria.setFirstResult(searchCriteria.getStartRow());
			criteria.setMaxResults(searchCriteria.getBatchSize());
		}
		
		return criteria;
	}

	private Criteria createCriteria(QueryCriteria searchCriteria,
			Criteria criteria, Junction junction, Set<String> aliases) {
		Map<String, QueryCriterion> searchValueMap = null;
		Set<Entry<String, QueryCriterion>> entrySet = null;

		searchValueMap = searchCriteria.getqueryCriterias();
		entrySet = searchValueMap.entrySet();
		for (Entry<String, QueryCriterion> entry : entrySet) {
			if (searchCriteria.isOr()) {
				junction = createJunction(junction,
						createCriterion(entry.getValue()));
			} else {
				criteria.add(createCriterion(entry.getValue()));
			}

			if (entry.getValue().getEntityClassName() != null
					&& !aliases.contains(entry.getValue().getEntityClassName())) {
				criteria.createAlias(entry.getValue().getEntityClassName(),
						entry.getValue().getEntityClassName());
				aliases.add(entry.getValue().getEntityClassName());
			}
		}

		if (searchCriteria.getSubQueryCriteria() != null
				&& searchCriteria.getSubQueryCriteria().size() != 0) {
			for (QueryCriteria subQueryCriteria : searchCriteria
					.getSubQueryCriteria()) {
				criteria = createCriteria(subQueryCriteria, criteria, junction,
						aliases);
			}
		}
		if (junction != null) {
			criteria.add(junction);
		}

		return criteria;
	}

	private Junction createJunction(Junction junction, Criterion criterion) {
		if (junction == null) {
			junction = Restrictions.disjunction();
		}
		junction.add(criterion);

		return junction;
	}

	/**
	 * Method to get reference to current hibernate session
	 * 
	 * @return hibernate session object
	 */
	protected Session getCurrentSession() {
//            System.out.println("yesss seisssss..");
            return getSessionFactory().openSession();
//            if(getSessionFactory().isClosed()) {
//                System.out.println("yesss seisssss..");
//                return getSessionFactory().openSession();
//            } else {
//                System.out.println("yesss else seisssss..");
//                return getSessionFactory().getCurrentSession();
//            }
            
	}

	protected void batchDelete(List<T> entities) {
		try {

			// Transaction tx = getCurrentSession().beginTransaction();
			// tx.begin();
			for (T entity : entities) {
				delete(entity);
			}
			// tx.commit();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	protected List<T> batchUpdate(List<T> entities) {
		Transaction tx = getCurrentSession().getTransaction();
		HibernateTransactionManager tm = new HibernateTransactionManager(getCurrentSession().getSessionFactory());
		try {
			//synchronized (tx) {
			//	tx.begin();
				for (T entity : entities) {
					//entity = persist(entity);
					logger.debug("LIST ::"+entity);
					if(entity!=null){
						getCurrentSession().saveOrUpdate(entity);
					}
				}
				//getCurrentSession().flush();
				//tx.commit();
				//tx.notifyAll();
				DefaultTransactionStatus status = new DefaultTransactionStatus(tx, false, false, false, false, null);
				tm.commit(status);
				return entities;
			//}
		} catch (Exception e) {
			tx.rollback();
			logger.error(e.getMessage(), e);
		}
		return entities;
	}

	@SuppressWarnings("rawtypes")
	private org.hibernate.criterion.Criterion createCriterion(
			QueryCriterion searchCriterion) {
		if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.ENDS_WITH) {
			return Restrictions.ilike(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue().toString().trim(),
					MatchMode.END);
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.START_WITH) {
			return Restrictions.ilike(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue().toString().trim(),
					MatchMode.START);
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.CONTAINS) {
			return Restrictions.ilike(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue().toString().trim(),
					MatchMode.ANYWHERE);
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.NE) {
			return Restrictions.ne(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.GE) {
			return Restrictions.ge(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.GT) {
			return Restrictions.gt(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.LE) {
			return Restrictions.le(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.LT) {
			return Restrictions.lt(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.IN) {
			return Restrictions.in(searchCriterion.getAttrName(),
					(Collection) searchCriterion.getAttrValue());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.ISNULL) {
			return Restrictions.isNull(searchCriterion.getAttrName());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.ISNOTNULL) {
			return Restrictions.isNotNull(searchCriterion.getAttrName());
		} else if (searchCriterion.getRestrictions() == QueryCriterion.RESTRICTIONS.BETWEEN) {
			@SuppressWarnings("unchecked")
			List<String> dateList = (List<String>) searchCriterion
					.getAttrValue();
			return Restrictions.between(searchCriterion.getAttrName(),
					dateList.get(0), dateList.get(1));
		} else if (searchCriterion.getAttrName() != null) {
			return Restrictions.eq(searchCriterion.getAttrName(),
					searchCriterion.getAttrValue());
		}

		return null;
	}

	protected String[] escapeSQLSpecials(String[] strInputs) {
		List<String> strInputsList = new ArrayList<String>();
		for (String strInput : strInputs) {
			strInput = escapeSQLSpecials(strInput);
			strInputsList.add(strInput);
		}
		return strInputsList.toArray(new String[strInputsList.size()]);
	}

	protected String escapeSQLSpecials(String strInput) {
		if (strInput == null || strInput.trim().equals("")) {
			return null;
		}

		// now replace all "'" with "''"
		String strReturn = strInput.replaceAll("'", "''");
		// now replace all "*" with "%" (note it is double escaped cos its a
		// RegExp)
		strReturn = strReturn.replaceAll("\\\\", "\\\\\\\\");

		strReturn = strReturn.replaceAll("%", "\\\\%%");
		// strReturn = strReturn.replaceAll("\\*", "%");

		// now replace all "?" with "_" (note it is double escaped cos its a
		// RegExp)
		// strReturn = strReturn.replaceAll("\\?", "_");
		strReturn = strReturn.replaceAll("_", "\\\\_%");
		strReturn = strReturn.replaceAll("\\[", "\\\\[");
		strReturn = strReturn.replaceAll("\\]", "\\\\]");
		strReturn = strReturn.replaceAll("\\*", "%\\\\*%");
		return strReturn;
	}

	public String getSearchStrClause(String[] searchKey, String fieldName,
			String connectedCondition, boolean isSearchKeysAndCondition) {
		String searchString = "";

		if (fieldName == null && connectedCondition == null) {
			if ((searchKey[0].startsWith("'") && searchKey[searchKey.length - 1]
					.endsWith("'"))
					|| (searchKey[0].startsWith("\"") && searchKey[searchKey.length - 1]
							.endsWith("\""))) {
				int strLength = searchKey.length;

				if (searchKey[0].length() > 1) {
					searchKey[0] = searchKey[0].substring(1);
				}
				if (searchKey[strLength - 1].length() > 1) {
					searchKey[strLength - 1] = searchKey[strLength - 1]
							.substring(0, searchKey[strLength - 1].length() - 1);
				}

				for (int i = 0; i < searchKey.length; i++) {
					searchString = searchString + searchKey[i] + " ";
				}
				searchString = searchString.trim();
			}
			return searchString;
		} else {
			if (searchKey != null && searchKey.length > 0) {
				for (int i = 0; i < searchKey.length; i++)
					searchString = searchString + searchKey[i] + " ";
			}
		}
		return getSearchStrClause(searchString, fieldName, connectedCondition,
				isSearchKeysAndCondition);
	}

	public String getSearchStrClause(String[] searchKey) {
		return getSearchStrClause(searchKey, null, null, true);
	}

	public String getSearchStrClause(String[] searchKey, String fieldName) {
		return getSearchStrClause(searchKey, fieldName, null, true);
	}

	public String getSearchStrClause(String[] searchKey, String fieldName,
			String connectedCondition) {
		return getSearchStrClause(searchKey, fieldName, connectedCondition,
				true);
	}

	public String getSearchStrClause(String searchKey, String fieldName,
			String connectedCondition) {
		return getSearchStrClause(searchKey, fieldName, connectedCondition,
				true);
	}

	/**
	 * This method prepares WHERE Clause based on searchKey. If searchKey is
	 * enclosed with either "" or '' then it will consider single word.
	 * Otherwise it will split the string at spaces and prepare where clause to
	 * search each token.
	 * 
	 * @param searchKey
	 * @param fieldName
	 * @return
	 */
	public String getSearchStrClause(String searchKey, String fieldName,
			String connectedCondition, boolean isSearchKeysAndCondition) {

		String whereClause = "";
		String[] searchStrings = null;
		int searchStrLen = 0;

		if (searchKey == null) {
			return "";
		}
		if (connectedCondition == null) {
			connectedCondition = "";
		}

		searchKey = searchKey.trim();
		if (!searchKey.equals("")) {
			searchStrLen = searchKey.length();
			if ((searchKey.startsWith("'") && searchKey.endsWith("'"))
					|| (searchKey.startsWith("\"") && searchKey.endsWith("\""))) {
				if (searchStrLen > 2) {
					searchKey = searchKey.substring(1, searchKey.length() - 1);
				}

				whereClause = " " + connectedCondition + " " + fieldName
						+ " LIKE '%" + escapeSQLSpecials(searchKey) + "%' ";
			} else {
				searchStrings = searchKey.trim().split("[ ]");
				if (searchStrings.length > 0) {
					whereClause = " " + connectedCondition + " (";
					for (int i = 0; i < searchStrings.length; i++) {
						whereClause += " " + fieldName + " LIKE '%"
								+ escapeSQLSpecials(searchStrings[i]) + "%' ";
						if (i < searchStrings.length - 1) {
							if (isSearchKeysAndCondition) {
								whereClause += " AND ";
							} else {
								whereClause += " OR ";
							}
						}
					}
					whereClause += " )";
				}
			}
		}

		return whereClause;
	}
}
