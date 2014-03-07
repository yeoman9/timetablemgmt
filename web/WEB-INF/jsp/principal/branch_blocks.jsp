<%-- 
    Document   : branch_blocks
    Created on : 27 Jan, 2014, 9:49:53 AM
    Author     : mayur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN DASHBOARD STATS -->
<c:set var="count" value="0" scope="page" />
<div class="row-fluid">
    <c:forEach  items="${branches}" var="branch">
        <c:set var="b" value="" />
        <c:if test="${count == 0}">
            <div>
            </c:if>
            <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                <div class="dashboard-stat ${color[count]}">
                    <div class="visual">
                        <img src="assets/img/photo1.jpg" alt="ce"/>
                        
                            <div class="hodname" > ${hods[branch.id].name}
                                </div>
                        
                    </div>
                    <div class="details" >
                        <div class="branch-text" style="float: right; padding-bottom: 10px;">${branch.shortName}</div>
                        
                        <div class="desc" style="width: 110px; padding-bottom: 15px;">                           
                            ${branch.name} 
                        </div>
                        
                        
                    </div>
                    <a class="more" href="teachers.htm?branch=${branch.shortName}">
                        Add/Upadte <i class="m-icon-swapright m-icon-white"></i>
                    </a>                 
                </div>
            </div>
            <c:if test="${count == 0}">
            </div>
        </c:if>
        <c:choose>
            <c:when test="${count >= 3}">
                <c:set var="count" value="0" scope="page" /> 
            </c:when>
            <c:otherwise>
                <c:set var="count" value="${count + 1}" scope="page" />
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
