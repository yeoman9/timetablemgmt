<%-- 
    Document   : branch_blocks
    Created on : 27 Jan, 2014, 9:49:53 AM
    Author     : mayur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN DASHBOARD STATS -->
<div class="row-fluid">
    <c:forEach  items="${branches}" var="branch">
        <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
            <div class="dashboard-stat blue">
                <div class="visual">
                    <!--<img src="assets/branch/ce.png" alt="ce"/>-->
                    <div class="branch-text">${branch.shortName}</div>
                </div>

                <div class="details" style=" margin-top: -80px">
                    
                        <div class="number">
                            ${total}
                        </div>
                        <div class="desc">                           
                            ${branch.name}
                        </div>
                    </div>
                <a class="more" href="clerk_teacherList.htm?branch=CE">
                    View more <i class="m-icon-swapright m-icon-white"></i>
                </a>                 
            </div>
        </div>
    </c:forEach>
    <!--        <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                <div class="dashboard-stat green">
                    <div class="visual">
                        <i class="icon-shopping-cart"></i>
                        <img src="assets/branch/ec.png" alt="ec"/>
                    </div>
                    <div class="details">
                        <div class="number">549</div>
                        <div class="desc">New Orders</div>
                    </div>
                    <a class="more" href="clerk_teacherList.htm?branch=EC">
                        View more <i class="m-icon-swapright m-icon-white"></i>
                    </a>                 
                </div>
            </div>
            <div class="span3 responsive" data-tablet="span6  fix-offset" data-desktop="span3">
                <div class="dashboard-stat purple">
                    <div class="visual">
                                                                                            <i class="icon-globe"></i>
                        <img src="assets/branch/me.png" alt="me"/>
                    </div>
                    <div class="details">
                        <div class="number">+89%</div>
                        <div class="desc">Brand Popularity</div>
                    </div>
                    <a class="more" href="clerk_teacherList.htm?branch=ME">
                        View more <i class="m-icon-swapright m-icon-white"></i>
                    </a>                 
                </div>
            </div>
            <div class="span3 responsive" data-tablet="span6" data-desktop="span3">
                <div class="dashboard-stat yellow">
                    <div class="visual">
                                                                                            <i class="icon-bar-chart"></i>
                        <img src="assets/branch/ee.png" alt="ee"/>
                    </div>
                    <div class="details">
                        <div class="number">12,5M$</div>
                        <div class="desc">Total Profit</div>
                    </div>
                    <a class="more" href="clerk_teacherList.htm?branch=EE">
                        View more <i class="m-icon-swapright m-icon-white"></i>
                    </a>                 
                </div>
            </div>-->
</div>