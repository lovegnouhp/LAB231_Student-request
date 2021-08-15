<%--
    Document   : error
    Created on : Jun 30, 2021, 9:18:50 AM
    Author     : phuon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="component/header.jsp"/>
            <div class="main">
                <jsp:include page="component/menu-bar.jsp"/>
                <div class="content error-page">
                    Error: ${requestScope.error}
                </div>
            </div>
            <jsp:include page="component/footer.jsp"/>
        </div>
    </body>
</html>
