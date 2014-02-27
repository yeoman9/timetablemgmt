<%-- 
    Document   : sidebar
    Created on : 23 Jan, 2014, 10:08:17 AM
    Author     : mayur
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-sidebar nav-collapse collapse">
    <!-- BEGIN SIDEBAR MENU -->        
    <ul class="page-sidebar-menu">
        <li>
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            <div class="sidebar-toggler hidden-phone"></div>
            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
        </li>
        <li>
            <!--BEGIN RESPONSIVE QUICK SEARCH FORM--> 
            <form class="sidebar-search">
                <!--						<div class="input-box">
                                                                        <a href="javascript:;" class="remove"></a>
                                                                        <input type="text" placeholder="Search..." />
                                                                        <input type="button" class="submit" value=" " />
                                                                </div>-->
            </form>
            <!--END RESPONSIVE QUICK SEARCH FORM--> 
        </li>
        <li class="start ${semester}">
            <a href="LoginAuth.htm">
                <i class="icon-sitemap"></i> 
                <span class="title">Semester</span>
                <c:if test="${semester == 'active'}">
                    <span class="selected"></span>
                </c:if>
            </a>
        </li>
    </ul>
    <!-- END SIDEBAR MENU -->
</div>