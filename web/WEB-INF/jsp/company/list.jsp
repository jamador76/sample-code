<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css" />
        <title>Meetup</title>
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
                <h2>Companies</h2>
                <table class="data_table">
                    <tr><th>ID</th><th>Name</th></tr>
                    <c:forEach items="${list}" var="company">
                        <tr>
                            <td><c:out value="${company.companyId}" escapeXml="true" /></td>
                            <td><c:out value="${company.name}" escapeXml="true" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="footer"></div>
        </div>
    </body>
</html>
