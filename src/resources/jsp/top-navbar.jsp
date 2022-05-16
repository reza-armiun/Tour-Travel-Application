<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<style>
    <%@ include file="../css/top-navbar.css"%>
</style>
<%
    boolean isAuth = session.getAttribute("principal") != null;
%>
<div class="navbar" >
    <div class="navbar-left">
        <div>
            <div class="hamburger navbar__item"  onclick="showSidebar(event)">
                <div ></div>
                <div ></div>
                <div ></div>
            </div>
            <%@ include file="sidebar.jsp"%>
        </div>
        <a class="navbar__item" href="${pageContext.request.contextPath}/home">
            <div id="home">HOME</div>
        </a>
    </div>
    <div class="navbar-right">
        <c:choose>
            <c:when test="<%=isAuth%>">
                <div class="navbar__item dropdown"  onclick="dropdownClickHandler()">
                        ${sessionScope.principal.username}
                    <div id="dropdown-arrow" ></div>
                    <div class="dropdown-content" id="myDropdown">
                        <a href="#">Profile</a>
                        <a href="${pageContext.request.contextPath}/logout">Logout</a>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="navbar__item">Register</div>
                <a class="navbar__item" href="${pageContext.request.contextPath}/login">
                    Sign in
                </a>
            </c:otherwise>
        </c:choose>

    </div>
</div>
<script  defer>
    <%@ include  file="../js/top-navbar.js"  %>
</script>