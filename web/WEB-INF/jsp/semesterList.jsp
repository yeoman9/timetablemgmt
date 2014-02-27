<%-- 
    Document   : semesterList
    Created on : 26 Feb, 2014, 4:58:42 PM
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${semesters}" var="semester">
                            <tr>
                                <td>${semester}</td>
                                <td>${semester}</td>
                                <td>${semester}</td>
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
            <form:form action="#" modelAttribute="newSemester" class="form-horizontal">
                <div class="modal-body">
                    <div class="control-group">
                        <label class="control-label">Semester No<span class="required">*</span></label>
                        <div class="controls">
                            <form:input path="semesterNo" type="text" placeholder="number" class="m-wrap medium"></form:input>
                                <span class="help-inline">Some hint here</span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Division<span class="required">*</span></label>
                            <div class="controls">
                            <form:input path="division" type="text" placeholder="division" class="m-wrap medium"></form:input>
                                <span class="help-inline">Some hint here</span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Class CoOrdinator<span class="required">*</span></label>
                            <div class="controls">
                            <form:select path="coOrdinator.name" items="${coOrdinatorNames}" class="m-wrap medium" tabindex="1">

                            </form:select>
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
