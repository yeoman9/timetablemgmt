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
                <div class="caption"><i class="icon-list"></i>Branch List</div>
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
                            <th>Short Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${branches}" var="branch">
                            <tr>
                                <td>${branch.name}</td>
                                <td>${branch.shortName}</td>
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
                <h3>Add new Branch</h3>
            </div>
            <!-- BEGIN FORM-->
            <form:form action="addBranch.htm" modelAttribute="newBranch" class="form-horizontal">
                <div class="modal-body">
                    <div class="control-group">
                        <label class="control-label">Name<span class="required">*</span></label>
                        <div class="controls">
                            <form:input path="name" type="text" placeholder="name" class="m-wrap medium"></form:input>
                                <span class="help-inline">Some hint here</span>
                            </div>
                        </div>
                       
                        <div class="control-group">
                            <label class="control-label">Short Name<span class="required">*</span></label>
                            <div class="controls">
                            <form:input path="shortName" type="text" placeholder="alias" class="m-wrap small"></form:input>
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
                         <%--<form:hidden path="currentBranch" value="${branchShortName}" />--%>
            </form:form>
        </div>
        <!-- END ADD NEW TEACHER MODAL -->

    </div>
</div>
