/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services;

import com.timetablemgmt.domainobjects.TimeSlot;
import java.util.List;

/**
 *
 * @author sanket
 */
public interface TimeSlotServiceIf {
    public List<TimeSlot> getAllTimeSlots();
    public TimeSlot saveOrUpdateTimeSlot(TimeSlot timeSlot);
}
