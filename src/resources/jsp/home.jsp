
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<style>
    <%@ include file="../css/app.css" %>
</style>
<html>
<head><title>Home Page</title>
</head>
<body>

<%@ include file="top-navbar.jsp"%>
<div class="content">
    <%@ include file="tour/tour-list.jsp"%>
</div>

<%@ include file="footer.jsp"%>
</body>
</html>