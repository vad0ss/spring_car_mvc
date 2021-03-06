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
  <title>Add Event</title>
  <style type="text/css">
    #map {
      width: 450px;
      height: 500px;
    }
  </style>
  <link rel="stylesheet" type="text/css" href="/bootstrap/css/jquery.datetimepicker.css">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
  <script src="/bootstrap/js/jquery.js"></script>
  <script src="/bootstrap/js/build/jquery.datetimepicker.full.min.js"></script>

</head>
<body>
<%
  User user = (User)session.getAttribute("user");
%>
<script type="text/javascript">

  var marker;
  function initMap(location) {
    console.log(location);
    var currentLocation = {lat: location.coords.latitude, lng: location.coords.longitude};

    var map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: location.coords.latitude, lng: location.coords.longitude},
      zoom: 12
    });

    marker = new google.maps.Marker({
      position: currentLocation,
      map: map,
      title: "My Location"
    });

    map.addListener('click', function(e) {
      marker.setMap(null);
      var myLatLng = e.latLng;
      document.addevent.latitude.value = myLatLng.lat();
      document.addevent.longitude.value = myLatLng.lng();
      placeMarkerAndPanTo(e.latLng, map);
    });
  }

  function placeMarkerAndPanTo(latLng, map) {
    marker = new google.maps.Marker({
      position: latLng,
      map: map
    });
    map.panTo(latLng);
  }


  $(document).ready(function()
  {
    navigator.geolocation.getCurrentPosition(initMap);
  });

</script>
Add Event:
<form name="addevent" method="get" action="addevent">
  Event Name:
  <input type="text" id="eventName" name="eventName" value="" />
  User Id:
  <input type="text" id="userID" name="userID" value="<%=user.getUserId() %>" readonly/>
  <br />
  Latitude:
  <input type="text" id="latitude" name="latitude" value="" readonly/>
  Longtitude:
  <input type="text" id="longitude" name="longitude" value="" readonly/>
  <input type="text" id="datetimepicker" name="datetimepicker" value="" >
  <input type="submit" />
</form>
<script>
  jQuery('#datetimepicker').datetimepicker();

</script>
<div id="map"></div>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUpMRaMT_QeweKFcoI59XGpstCWF8qfIQ&callback=initMap">
</script>

<% session.setAttribute("user",user); %>
<a href="usr?UserID=<%=user.getUserId() %>">Back to User</a>
</body>
</html>                                