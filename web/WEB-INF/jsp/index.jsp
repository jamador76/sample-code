<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meetup</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css" />
    </head>
    <body>
        <c:redirect url="/data/upload" />
    </body>
</html>