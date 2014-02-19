<%-- 
    Document   : principalList
    Created on : 19 Feb, 2014, 10:37:13 AM
    Author     : mayur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<div class="row-fluid">
    <div class="span12">
        <!-- BEGIN EXAMPLE TABLE PORTLET-->
        <div class="portlet box purple">
            <div class="portlet-title">
                <div class="caption"><i class="icon-list"></i>Principal</div>
                <div class="actions">
                    <a href="#responsive" class="btn green" data-toggle="modal"><i class="icon-plus"></i> Add</a>
                    <a href="#" class="btn yellow"><i class="icon-print"></i> Print</a>
                </div>
            </div>
            <div class="portlet-body">
                <table class="table table-striped table-bordered table-hover" id="sample_3">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Profile</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${principals}" var="principal">
                            <tr>
                                <td>${principal.loginId.username}</td>
                                <td>${principal.name}</td>
                                <td>${principal.loginId.email}</td>

                                <c:choose>
                                    <c:when test="${principal.loginId.status == 'A'}">
                                        <td><span class="label label-success">Active</span></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><span class="label label-inverse">Blocked</span></td>
                                    </c:otherwise>
                                </c:choose>

                                <td><a href="profile.htm">View</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

            </div>
        </div>
        <!-- END EXAMPLE TABLE PORTLET-->

        <!-- START ADD NEW TEACHER MODAL  -->
        <div id="responsive" class="modal hide fade" tabindex="-1" data-width="760">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h3>Add new Principal</h3>
            </div>
            <!-- BEGIN FORM-->
            <form:form action="#" modelAttribute="newPrincipal" class="form-horizontal">
                <div class="modal-body">
                    <div class="control-group">
                        <label class="control-label">Name<span class="required">*</span></label>
                        <div class="controls">
                            <form:input path="name" type="text" placeholder="name" class="m-wrap medium"></form:input>
                                <span class="help-inline">Some hint here</span>
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <!--                    <button type="button" data-dismiss="modal" class="btn">Close</button>
                                            <button type="button" class="btn blue">Save</button>-->
                    <!--                    <div class="form-actions">-->
                    <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                    <button type="button" data-dismiss="modal" class="btn">Close</button><!--
                    <!--</div>-->
                </div>
            </form:form>
        </div>
        <!-- END ADD NEW TEACHER MODAL -->

    </div>
</div>

