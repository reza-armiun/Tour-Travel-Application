
<div class="navbar" >
    <div class="navbar-left">
        <div class="navbar__item">
            <div class="header">HOME</div>
        </div>
    </div>
    <div class="navbar-right">
<%--        <div class="navbar__item">username</div>--%>
        <div class="navbar__item dropdown" onclick="dropdownClickHandler()">
            ${sessionScope.principal.username}
            <div   id="dropdown-arrow" ></div>

            <div class="dropdown-content" id="myDropdown">
                <a href="#">Profile</a>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </div>
        </div>
    </div>
</div>
<script>
    <%@ include file="../js/app.js"  %>
</script>