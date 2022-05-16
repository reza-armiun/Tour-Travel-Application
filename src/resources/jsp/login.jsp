<%@ page pageEncoding="utf-8" contentType="text/html; charset=UTF-8" %>
<style>
    <%@ include file="../css/login.css" %>
    <%@ include file="../css/app.css" %>
</style>
<html>
<head>
    <title>First JSP</title>

</head>

<body>



<div id="blue_segment" >
<div class="container">
    <form  action="${pageContext.request.contextPath}/login" method="post" >
        <h1>Login Form</h1>
        <hr>
        <label > Username: </label>
        <input  type="text" name="username" placeholder="username"  autocomplete="off" />
        <label > Password: </label>
        <input  type="password" name="password" placeholder="password" />
        <button type="submit">Login</button>
    </form>
</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>