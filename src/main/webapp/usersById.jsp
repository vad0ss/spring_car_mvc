<%@ page import="spring_car_mvc.domain.User" %>
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
    <title>User ID</title>
</head>
<body>
<%
  User user = (User)session.getAttribute("user");

  if(user == null) {
    user = (User) request.getAttribute("model");
    session.setAttribute("user",user);
  }

  if(user != null) {
%>
<h1>User your were looking for is found:</h1>
  Welcome User <strong><%=user.getUserName()%></strong>
<br />
   <a href="addEvent.jsp?UserID=<%=user.getUserId()%>">Add Event</a>
   <a href="eventuserlist?UserID=<%=user.getUserId()%>">User Event list</a>
<br />
<br />
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d139178.8864220672!2d23.989079180519653!3d56.97158333493548!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46eecfb0e5073ded%3A0x400cfcd68f2fe30!2z0KDQuNCz0LAsINCb0LDRgtCy0LjRjw!5e0!3m2!1sru!2sde!4v1452337680113" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
<%}
else
{%>
<h1>User stored by entered ID is not found!</h1><%
  }
%>
</body>
</html>                     