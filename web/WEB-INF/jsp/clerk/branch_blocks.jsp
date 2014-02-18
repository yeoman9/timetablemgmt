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
        <c:if test="${count == 0}">
            <div>
            </c:if>
            <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                <div class="dashboard-stat ${color[count]}">
                    <div class="visual">
                        <!--<img src="assets/branch/ce.png" alt="ce"/>-->
                        <div class="branch-text">${branch.shortName}</div>
                    </div>
                    <div class="details" >
                        <div class="desc" style="width: 110px;padding-top: 13px;">                           
                            ${branch.name}
                        </div>
                        <div class="number" style="padding-top: 10px; " >
                            <div class="desc" style="display:inline;">                           
                            Total : 
                        </div>
                            ${branch.total}
                        </div>
                        
                    </div>
                    <a class="more" href="clerk_teacherList.htm?branch=${branch.shortName}">
                        View more <i class="m-icon-swapright m-icon-white"></i>
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
