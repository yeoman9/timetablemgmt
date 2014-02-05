package com.timetablemgmt.hibernateutils;

import java.util.List;

import com.timetablemgmt.common.SearchCriteria;

/**
 * This interface contains generic definitions of various
 * common method of Data access Objects
 * 
 * @author ninad
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseDAO<T, ID extends java.io.Serializable> {

	/**
	 * Method that find the entity for the given identifier
	 * 
	 * @param id identifier of the entity.
	 * @return persistent entity
	 */
	public T findById(ID id);
	/**
	 * Method to save the entity in the database
	 * 
	 * @param entity 
	 * @return reference to the given entity
	 */
	public T persist(T entity);
	/**
	 * Flushes the objects in the current session.
	 */
	public void flush();
	/**
	 * Clears all the entities that are loaded in the
	 * current sessions.
	 */
	public void clear();
	/**
	 * Deletes the given persistent entity from database
	 * @param entity that needs to be deleted from database
	 */
	public void delete(T entity);
	/**
	 * Finds unique entity based on the given searchCriteria
	 * @param searchCriteria
	 * @return unique entity found in the dataabse
	 */
//	public T findUniqueEntity(SearchCriteria searchCriteria);
//	/**
//	 * Returns all matching entities as per the given
//	 * search criteria
//	 * @param searchCriteria
//	 * @return list of objects
//	 */
//	public List<T> findEntities(SearchCriteria searchCriteria);
}
