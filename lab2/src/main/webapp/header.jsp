<jsp:useBean id="user" scope="session" class="beans.User"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
    <span>LOGO</span>
    <c:if test="${user.role == 'ADMIN'}">
        <div class="links-section">
            <a href="#">New trade </a>
            <a href="#">User list </a>
            <a href="check_requests">Check requests</a>
        </div>
    </c:if>
    <c:if test="${user.role == 'USER'}">
        <div class="links-section">
            <a href="#"> Catalog</a>
            <a href="make_request">New request</a>
        </div>
    </c:if>
    <div class="button-section">
        <button class="btn-signin" onclick="location.href='./sign_in'">Sign In</button>
        <button class="btn-login" onclick="location.href='./login'">Log In</button>
    </div>
</nav>
