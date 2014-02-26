<%-- 
    Document   : teacherList
    Created on : 22 Jan, 2014, 5:04:22 PM
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
                <div class="caption"><i class="icon-list"></i>TimeSlots</div>
                <div class="actions">
                    <a href="#responsive" class="btn green" data-toggle="modal"><i class="icon-plus"></i> Add</a>
                    <a href="#" class="btn yellow"><i class="icon-print"></i> Print</a>
                </div>
            </div>
            <div class="portlet-body">
                <table class="table table-striped table-bordered table-hover" id="sample_3">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>StartTime</th>
                            <th>EndTime</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${timeSlots}" var="timeSlot">
                            <tr>
                                <td>${timeSlot.slotName}</td>
                                <td>${timeSlot.startTime}</td>
                                <td>${timeSlot.endTime}</td>
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
                <h3>Add new TimeSlot</h3>
            </div>
            <!-- BEGIN FORM-->
            <form:form action="addTimeSlot.htm" modelAttribute="newTimeSlot" class="form-horizontal">
                <div class="modal-body">
                    <div class="control-group">
                        <label class="control-label">Name<span class="required">*</span></label>
                        <div class="controls">
                            <form:input path="slotName" type="text" placeholder="name" class="m-wrap medium"></form:input>
                                <span class="help-inline">Some hint here</span>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">StartTime<span class="required">*</span></label>
                            <div class="controls">
                                <div class="input-append bootstrap-timepicker-component">
                                <form:input path="startTime" class="m-wrap m-ctrl-small timepicker-24" type="text" ></form:input>
                                    <span class="add-on"><i class="icon-time"></i></span>
                                </div>
                            </div>
                        </div>


                        <div class="control-group">
                            <label class="control-label">EndTime<span class="required">*</span></label>
                            <div class="controls">
                                <div class="input-append bootstrap-timepicker-component">
                                <form:input path="endTime" class="m-wrap m-ctrl-small timepicker-24" type="text" ></form:input>
                                    <span class="add-on"><i class="icon-time"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--                        <div class="control-group">
                                                <label class="control-label">24hr Timepicker</label>
                                                <div class="controls">
                                                    <div class="input-append bootstrap-timepicker-component">
                                                        <input class="m-wrap m-ctrl-small timepicker-24" type="text" />
                                                        <span class="add-on"><i class="icon-time"></i></span>
                                                    </div>
                                                </div>
                                            </div>        -->


                    <div class="modal-footer">
                        <!--                    <button type="button" data-dismiss="modal" class="btn">Close</button>
                                                <button type="button" class="btn blue">Save</button>-->
                        <!--                    <div class="form-actions">-->
                        <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                        <button type="button" data-dismiss="modal" class="btn">Close</button><!--
                        <!--</div>-->
                    </div>

                <%--<form:hidden path="currentBranch" value="${branchShortName}" />--%>
            </form:form>
        </div> 
    </div>
</div>
<!-- END ADD NEW TEACHER MODAL -->
