<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css" />
        <title>Upload Page</title>
    </head>
    <body>
        <div id="container">
            <div id="header"><h1>Meetup</h1></div>
            <div id="navigation">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/data/upload">Upload CSV</a></li>
                    <li><a href="<%=request.getContextPath()%>/company/list">Companies</a></li>
                    <li><a href="<%=request.getContextPath()%>/contact/list">Contacts</a></li>
                </ul>
            </div>
            <div id="content">
                <h2>Upload CSV</h2>
                <form:form method="post" enctype="multipart/form-data" action="upload/csv">
                    <div>
                        <span>upload file: <input type="file" name="file" /></span>
                        <form:errors path="file" />
                        <br />
                        <input type="submit" value="Upload" />
                    </div>
                    <div>
                        <ul>
                            <c:forEach items="${invalidRecords}" var="record">
                                <li><c:out value="${record}" /></li>
                            </c:forEach>
                        </ul>
                    </div>
                </form:form>
            </div>
            <div id="footer"></div>
        </div>
    </body>
</html>
