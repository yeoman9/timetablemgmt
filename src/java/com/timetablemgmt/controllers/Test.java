/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.controllers;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author sanket
 */
@Configuration
//@PropertySource("Props/HomePage.properties")
public class Test {
    @Value("${ROLE_ADMIN}")
    public static String propertyValue;
}