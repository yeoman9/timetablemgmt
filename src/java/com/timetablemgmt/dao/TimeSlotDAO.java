/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.dao;

import com.timetablemgmt.domainobjects.TimeSlot;
import java.util.List;

/**
 *
 * @author sanket
 */
public interface TimeSlotDAO {
    public List<TimeSlot> getAllTimeSlots();
    public TimeSlot saveOrUpdateTimeSlot(TimeSlot timeSlot);
}
