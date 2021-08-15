<%--
    Document   : newjsphome
    Created on : Jul 3, 2021, 5:11:43 PM
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
        <link rel="icon" href="images/favicon.ico" />
        <title>Home Page</title>
    </head>
    <body>
        <!--container start-->
        <div class="container">

            <jsp:include page="/component/header.jsp"/>

            <div class="main">
                <jsp:include page="/component/menu-bar.jsp"/>

                <div class="content home-page">
                    <div class="today">
                        <h3>Request received by today - <fmt:formatDate
                                pattern="MM/dd/yyyy" value="${sessionScope.today}"/></h3>
                        <table>
                            <thead>
                                <tr>
                                    <th>Department name</th>
                                    <th>Number of request</th>
                                    <th>View detail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="rq" items="${requestScope.reportsToday}">
                                    <tr>
                                        <td>${rq.department.name}</td>
                                        <td>${rq.numberOfRequest}</td>
                                        <td><a href="view-request?date=today&department-id=${rq.department.id}" >View</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="last2days">
                        <h3>Request received by last 2 days</h3>
                        <table>
                            <thead>
                                <tr>
                                    <th>Department name</th>
                                    <th>Number of request</th>
                                    <th>View detail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="rq2" items="${requestScope.reportsLast2Days}">
                                    <tr>
                                        <td>${rq2.department.name}</td>
                                        <td>${rq2.numberOfRequest}</td>
                                        <td><a href="view-request?date=last2d&department-id=${rq2.department.id}">View</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <jsp:include page="component/footer.jsp"/>
        </div>
        <!--container end-->
    </body>
</html>
