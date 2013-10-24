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
                <h2>Contacts</h2>
                <table class="data_table">
                    <tr>
                        <th>ID</th><th>Name</th><th>User ID</th><th>Title</th><th>Member ID</th>
                        <th>Joined On</th><th>Last Visited</th><th>Last Attended</th>
                        <th>Total Rspvs</th><th>RSVPed Yes</th><th>RSVPed Maybe</th><th>RSVPed No</th>
                        <th>Meetups Attended</th><th>No Shows</th><th>Intro</th><th>Photo</th>
                        <th>Assistant Organizer</th><th>Mailing List</th><th>Member Profile URL</th>
                    </tr>
                    <c:forEach items="${list}" var="contact">
                        <tr>
                            <td><c:out value="${contact.contactId}" /></td>
                            <td><c:out value="${contact.name}" /></td>
                            <td><c:out value="${contact.userId}" /></td>
                            <td><c:out value="${contact.title}" /></td>
                            <td><c:out value="${contact.memberId}" /></td>
                            <td><c:out value="${contact.joinedGroupOn}" /></td>
                            <td><c:out value="${contact.lastVisitedGroupOn}" /></td>
                            <td><c:out value="${contact.lastAttended}" /></td>
                            <td><c:out value="${contact.totalRsvps}" /></td>
                            <td><c:out value="${contact.rsvpedYes}" /></td>
                            <td><c:out value="${contact.rsvpedMaybe}" /></td>
                            <td><c:out value="${contact.rsvpedNo}" /></td>
                            <td><c:out value="${contact.meetupsAttended}" /></td>
                            <td><c:out value="${contact.noShows}" /></td>
                            <td><c:out value="${contact.intro}" /></td>
                            <td><c:out value="${contact.photo}" /></td>
                            <td><c:out value="${contact.assistantOrganizer}" /></td>
                            <td><c:out value="${contact.mailingList}" /></td>
                            <td><c:out value="${contact.memberProfileUrl}" /></td>
                            <td><c:out value="${contact.phone}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="footer"></div>
        </div>
    </body>
</html>
