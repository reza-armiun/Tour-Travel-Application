<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<style>
    <%@ include file="../css/app.css" %>
</style>
<html>
<head><title>Home Page</title>
</head>
<body>
<%
    String pageToShow = (String) request.getAttribute("pageToShow");
%>

<%@ include file="top-navbar.jsp"%>
<div class="content">
    <jsp:include page="<%=pageToShow%>" />
</div>
<%@ include file="footer.jsp"%>
</body>
</html>