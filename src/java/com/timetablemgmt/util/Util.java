/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sanket
 */
public class Util {
    final static HashMap<String, String > homePageMapping = new HashMap<String, String>(){{
        put("ROLE_ADMIN","admin/sidebar/principal");
        put("ROLE_TEACHER","teacher/home");
        put("ROLE_HOD","hod/sidebar/coordinator");
        put("ROLE_CLERK","clerk/home");
        put("ROLE_PRINCIPAL","principal/sidebar/branches");
    }};
    
    public static String getHomePageMappingFor(String userRole){
        return homePageMapping.get(userRole);
    }
    public final static List<String> colors = Arrays.asList("blue","red","green","purple");
    
    public static Map<String,Object> getObjectsForThisPage(String pageName){
        Map<String,Object> objects = new HashMap<>();
        objects.put("","");
        return objects;
    }
    
}
