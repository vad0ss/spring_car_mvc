<%@ page import="spring_car_mvc.domain.User" %>
<%@ page import="spring_car_mvc.domain.Event" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
  <title>Delete Event</title>
</head>
<body>
<%
  User user = (User)session.getAttribute("user");
  session.setAttribute("user",user);
  response.sendRedirect("eventuserlist?UserID="+user.getUserId());
%>
<a href=" %>">Back to User</a>
</body>
</html>