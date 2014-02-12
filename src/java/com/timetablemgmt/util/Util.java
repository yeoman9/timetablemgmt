/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sanket
 */
public class Util {
    final static HashMap<String, String > homePageMapping = new HashMap<String, String>(){{
        put("ROLE_ADMIN","admin/home");
        put("ROLE_TEACHER","teacher/home");
        put("ROLE_HOD","hod/home");
        put("ROLE_CLERK","clerk/home");
        put("ROLE_PRINCIPAL","principal/home");
    }};
    
    public static String getHomePageMappingFor(String userRole){
        return homePageMapping.get(userRole);
    }
    
//    public static Map<String,Object> getObjectsForThisPage(String pageName){
//        Map<String,Object> objects = new HashMap<>();
//        objects.put("","");
//        return objects;
//    }
    
}