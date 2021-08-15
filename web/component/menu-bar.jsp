<%--
    Document   : nav-bar
    Created on : Jul 3, 2021, 5:20:19 PM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script src="js/javascript.js" type="text/javascript"></script>
        <title>Navigation bar</title>
    </head>
    <body onload="getDateToday()">
        <div class="menu-bar">
            <div class="option">
                <p>
                    <c:choose>
                        <c:when test="${sessionScope.account eq null}">
                            <a href="login">Login</a>
                        </c:when>
                        <c:otherwise>
                            <a href="logout">Welcome ${sessionScope.account.name}, Logout</a>
                        </c:otherwise>
                    </c:choose>
                </p>
            </div>
            <div class="option">
                <p class="home"><a href="home">Home</a></p>
            </div>
            <div class="option">
                <p class="view-request"><a href="view-request">View requests</a></p>
            </div>
            <div class="option">
                <p class="solve-request"><a href="solve-request">Solve requests</a></p>
            </div>
            <div class="option">
                <p class="today">Today is: <span id="today"></span></p>
            </div>
        </div>
    </body>
</html>
