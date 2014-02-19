/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao.impl;

import com.timetablemgmt.dao.TimeSlotDAO;
import com.timetablemgmt.domainobjects.Teacher;
import com.timetablemgmt.domainobjects.TimeSlot;
import com.timetablemgmt.hibernateutils.BaseHibernateDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanket
 */
@Repository
public class TimeSlotDAOImpl extends BaseHibernateDAO<TimeSlot, Long>implements TimeSlotDAO{

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return getCurrentSession().createQuery("FROM TimeSlot").list();
    }

    @Override
    public TimeSlot saveOrUpdateTimeSlot(TimeSlot timeSlot) {
        return super.persist(timeSlot);
    }
    
}
