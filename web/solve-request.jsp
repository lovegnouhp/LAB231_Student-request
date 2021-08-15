<%--
    Document   : solve-request
    Created on : Jul 12, 2021, 2:52:54 AM
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
    <link rel="icon" href="images/favicon.ico" />
    <title>Solve Request</title>
</head>

<body>
    <div class="container">
        <jsp:include page="/component/header.jsp" />

        <div class="main">
            <jsp:include page="/component/menu-bar.jsp" />

            <div class="content solve-request">
                <form action="solve-request" method="POST">
                    <h2>Request ID: ${requestScope.rq.id}</h2>
                    <table>
                        <tbody>
                            <tr>
                                <td>Request to department</td>
                                <td><input type="text" name="department-name" value="${requestScope.rq.department.name}"
                                        readonly /></td>
                            </tr>
                            <tr>
                                <td>Student ID</td>
                                <td><input type="text" name="student-id" value="${requestScope.rq.student.id}"
                                        readonly /></td>
                            </tr>
                            <tr>
                                <td>Student name</td>
                                <td><input type="text" name="student-name" value="${requestScope.rq.student.name}"
                                        readonly /></td>
                            </tr>
                            <tr>
                                <td>Date created</td>
                                <td><input type="text" name="date-created" value="<fmt:formatDate pattern=" MM/dd/yyyy"
                                        value="${requestScope.rq.dateCreated}" />" readonly/></td>
                            </tr>
                            <tr>
                                <td>Request title</td>
                                <td><input type="text" name="title" value="${requestScope.rq.title}" readonly /></td>
                            </tr>
                            <tr>
                                <td>Request content</td>
                                <td>
                                    <textarea name="content" rows="5" cols="50"
                                        readonly>${requestScope.rq.content}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>Request state</td>
                                <td>
                                    <input type="radio" id="approved" name="state" value="1" <c:if
                                        test="${requestScope.rq.state ne -1}">disabled</c:if>
                                    <c:if test="${requestScope.rq.state eq 1}">checked</c:if>
                                    onclick="setRequestState()">
                                    <label class="approved" for="approved">Approved</label>
                                    <input type="radio" id="rejected" name="state" value="0" <c:if
                                        test="${requestScope.rq.state ne -1}">disabled</c:if>
                                    <c:if test="${requestScope.rq.state eq 0}">checked</c:if>
                                    onclick="setRequestState()">
                                    <label class="rejected" for="rejected">Rejected</label>
                                </td>
                            </tr>
                            <tr>
                                <td>Close date</td>
                                <td><input type="text" id="close_date" name="close-date"
                                        value="<fmt:formatDate pattern=" MM/dd/yyyy"
                                        value="${requestScope.rq.closeDate}" />" readonly/></td>
                            </tr>
                            <tr>
                                <td>Solved by</td>
                                <td><input type="text" id="solved_by" name="solved-by"
                                        value="${requestScope.rq.solvedBy.username}" readonly /></td>
                            </tr>
                            <tr>
                                <td>Attached (if any)</td>
                                <td><a href="${requestScope.rq.attachedURL}" download>
                                        <button class="button" name="download-attached" type="button" <c:if
                                            test="${empty requestScope.rq.attachedURL}">disabled</c:if>
                                            >Download</button>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>School's solution</td>
                                <td>
                                    <textarea name="solution" rows="5" cols="50" <c:if
                                        test="${requestScope.rq.state ne -1}">readonly</c:if>
                                            >${requestScope.rq.solution}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input id="save_btn" class="button" type="submit" value="Save" disabled /></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" name="request-id" value="${requestScope.rq.id}" />
                    <input type="hidden" id="username" value="${sessionScope.account.username}" />
                </form>
            </div>
        </div>

        <jsp:include page="component/footer.jsp" />
    </div>
</body>

</html>