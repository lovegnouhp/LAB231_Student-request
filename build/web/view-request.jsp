<%--
    Document   : login
    Created on : Jul 1, 2021, 6:59:49 PM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link rel="icon" href="images/favicon.ico" />
    <title>View Requests</title>
</head>

<body>
    <div class="container">
        <jsp:include page="component/header.jsp" />

        <div class="main">
            <jsp:include page="component/menu-bar.jsp" />

            <div class="content view-request">
                <h2>View requests</h2>
                <div class="search-form">
                    <form name="search_department" action="view-request" method="POST">
                        Select department
                        <select name="department-id" onchange="document.search_department.submit()">
                            <option value="-1" <c:if test="${requestScope.selectedDepID eq -1}">selected</c:if> >---
                            </option>
                            <c:forEach var="d" items="${requestScope.departments}">
                                <option value="${d.id}" <c:if test="${requestScope.selectedDepID eq d.id}">selected
                                    </c:if>>${d.name}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="form-name" value="search_department" />
                    </form>
                    <form name="search_title" action="view-request" method="POST">
                        or Enter request title
                        <input type="text" name="txt-title" value="${requestScope.searchedTitle}" required />
                        <input type="hidden" name="form-name" value="search_title" />
                        <input type="submit" value="View" />
                    </form>
                </div>
                <c:choose>
                    <c:when test="${requestScope.requests ne null and not empty requestScope.requests}">
                        <table>
                            <thead>
                                <tr>
                                    <th>Request title</th>
                                    <th>Date created</th>
                                    <th>Close created</th>
                                    <th>Status</th>
                                    <th>Report to</th>
                                    <th>Detail</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="rq" items="${requestScope.requests}">
                                    <tr>
                                        <td>${rq.title}</td>
                                        <td>
                                            <fmt:formatDate pattern="MM/dd/yyyy" value="${rq.dateCreated}" />
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rq.closeDate ne null}">
                                                    <fmt:formatDate pattern="MM/dd/yyyy" value="${rq.closeDate}" />
                                                </c:when>
                                                <c:otherwise>N/A</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rq.state eq 1}">Approved</c:when>
                                                <c:when test="${rq.state eq 0}">Rejected</c:when>
                                                <c:when test="${rq.state eq -1}">In progress</c:when>
                                            </c:choose>
                                        </td>
                                        <td>${rq.department.name}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${rq.state eq -1}">
                                                    <a href="solve-request?id=${rq.id}">Solve</a>
                                                </c:when>
                                                <c:otherwise><a href="solve-request?id=${rq.id}">View</a></c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise></c:otherwise>
                </c:choose>
            </div>
        </div>

        <jsp:include page="component/footer.jsp" />
    </div>
</body>

</html>