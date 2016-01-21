<%@ page import="spring_car_mvc.domain.User" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>My Monaco index page</title>
        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/style.css" rel="stylesheet">
    </head>  
    <body>
        <h1>Index Page</h1>
        <br />
     <%
         User user = (User)request.getAttribute("model");
         if(user == null)
         {
             response.sendRedirect("login.jsp");
         }
         else
         {
             session.setAttribute("user",user);
             response.sendRedirect("usr?UserID=" + user.getUserId());
         }

     %>
    </body>
</html>