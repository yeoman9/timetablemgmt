/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetablemgmt.services.impl;

import com.timetablemgmt.dao.PrincipalDAO;
import com.timetablemgmt.domainobjects.Principal;
import com.timetablemgmt.services.PrincipalServiceIf;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mayur
 */
@Service
public class PrincipalServiceImpl implements PrincipalServiceIf{

    @Autowired
    private PrincipalDAO principalDAO = null;
    @Override
    public List<Principal> getPrincipalList() {
        return principalDAO.getPrincipalList();
    }
}
