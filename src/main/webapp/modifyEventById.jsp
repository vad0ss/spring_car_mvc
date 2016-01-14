<%@ page import="spring_car_mvc.domain.User" %>
<%@ page import="spring_car_mvc.domain.Event" %>

<%--
  Created by IntelliJ IDEA.
  User: XidenT
  Date: 08/09/2015
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Modify Event</title>
</head>
<body>
<%
  User user = (User)session.getAttribute("user");
  Event event = (Event)request.getAttribute("model");
  if(event == null){
    event = new Event();
    event.setEventName(request.getParameter("eventName"));
  }
%>
<form name="modifyevent" method="get" action="modifyevent">
  Event Name:
  <input type="text" id="eventName" name="eventName" value="<%=event.getEventName()%>" />
  <input type="text" id="eventID" name="eventID" value="<%=event.getEventId()%>" readonly />
  <input type="submit" />
</form>
<% session.setAttribute("user",user); %>
<a href="eventuserlist?UserID=<%=user.getUserId() %>">Back to Event List</a>
</body>
</html>