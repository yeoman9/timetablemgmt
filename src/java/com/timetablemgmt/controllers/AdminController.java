/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.domainobjects.TimeSlot;
import com.timetablemgmt.services.TimeSlotServiceIf;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sanket
 */
@Controller
public class AdminController {

    @Autowired
    private TimeSlotServiceIf timeSlotServiceIf;
    
    List<TimeSlot> timeSlotList;

    @RequestMapping("/timeSlot.htm")
    public ModelAndView timeSlotPage() {
        ModelAndView mav = new ModelAndView();
        timeSlotList = new ArrayList<>();
        timeSlotList = timeSlotServiceIf.getAllTimeSlots();
        mav.addObject("timeSlots", timeSlotList);
        mav.addObject("timeSlot", "active");
        mav.addObject("newTimeSlot", new TimeSlot());
        mav.setViewName("admin/sidebar/timeSlot");
        return mav;
    }

    @RequestMapping("/addTimeSlot.htm")
    public ModelAndView addTimeSlot(@ModelAttribute(value = "newTimeSlot") TimeSlot timeSlot) {
        ModelAndView mav = new ModelAndView();
        timeSlotServiceIf.saveOrUpdateTimeSlot(timeSlot);
        timeSlotList = new ArrayList<>();
        timeSlotList = timeSlotServiceIf.getAllTimeSlots();
        mav.addObject("timeSlots", timeSlotList);
        mav.addObject("newTimeSlot", new TimeSlot());
        mav.setViewName("admin/sidebar/timeSlot");
        return mav;
    }
}
