<%@ page import="spring_car_mvc.domain.User" %>
<%@ page import="spring_car_mvc.servlet.mvc.MVCModel" %>
<%@ page import="spring_car_mvc.database.jdbc.UserDAOImpl" %>
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
  User user = (User) request.getAttribute("model");
  if(user != null) {
%>
<h1>User your were looking for is found:</h1>
<ul>
  <li><%=user.getUserName()%></li>
  <li><%=user.getUserId()%></li>
  <li><%=user.getPassword()%></li>
</ul>
<%}
else
{%>
<h1>User stored by entered ID is not found!</h1><%
  }
%>
</body>
</html>                     