<%@ page import="spring_car_mvc.domain.User" %>
<%@ page import="spring_car_mvc.database.jdbc.UserDAOImpl" %>
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
        <form name="usr" method="get" action="usr">
            <input type="text" id="UserID" name="UserID" value="" />
            <input type="submit" />
        </form>
    </body>
</html>