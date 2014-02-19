/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.TimeSlotDAO;
import com.timetablemgmt.domainobjects.TimeSlot;
import com.timetablemgmt.services.TimeSlotServiceIf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanket
 */
@Service
public class TimeSlotServiceImpl implements TimeSlotServiceIf{

    @Autowired
    private TimeSlotDAO timeSlotDAO;
    
    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotDAO.getAllTimeSlots();
    }

    @Override
    public TimeSlot saveOrUpdateTimeSlot(TimeSlot timeSlot) {
        return timeSlotDAO.saveOrUpdateTimeSlot(timeSlot);
    }
    
}
