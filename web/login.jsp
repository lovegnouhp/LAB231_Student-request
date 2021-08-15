<%--
    Document   : login
    Created on : Jul 1, 2021, 6:59:49 PM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="icon" href="images/favicon.ico" />
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="component/header.jsp"/>

            <div class="main">
                <jsp:include page="component/menu-bar.jsp"/>

                <div class="content login-page">
                    <h2>Member Login</h2>
                    <c:choose>
                        <c:when test="${sessionScope.account eq null}">
                            <div class="description">Using your username and password.</div>
                            <form name="login-form" action="login" method="POST">
                                <table>
                                    <tr class="account-info">
                                        <td>Username</td>
                                        <td><input type="text" name="username" required /></td>
                                        <td><span class="danger-text">(*)</span></td>
                                    </tr>
                                    <tr class="account-info">
                                        <td>Password</td>
                                        <td><input type="password" name="password" required /></td>
                                        <td><span class="danger-text">(*)</span></td>
                                    </tr>
                                    <tr <c:if test="${requestScope.loginFailed ne true}">hidden</c:if>>
                                            <td class="danger-text" colspan="3">Incorrect username or password</td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td align="left"><input class="button" type="submit" value="Log In" /></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>The field <span class="danger-text">(*)</span> is required.</td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </form>
                        </c:when>
                        <c:otherwise>You are already logged in.</c:otherwise>
                    </c:choose>
                </div>
            </div>

            <jsp:include page="component/footer.jsp"/>
        </div>
    </body>
</html>
