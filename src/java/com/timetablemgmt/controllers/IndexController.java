/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import com.timetablemgmt.hibernateutils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mayur
 */
@Controller
public class IndexController {
    @RequestMapping("/index.htm")
    public String indexHandler(){
        HibernateUtil.getSessionFactory();
        return "index";
    }
}
