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
  <title>Modify Event</title>
  <style type="text/css">
    #map {
      width: 450px;
      height: 500px;
    }
  </style>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
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
  <br />
  Latitude:
  <input type="text" id="latitude" name="latitude" value="<%=event.getLatitude()%>" readonly/>
  Longtitude:
  <input type="text" id="longitude" name="longitude" value="<%=event.getLongitude()%>" readonly/>
  <input type="submit" />
</form>
<div id="map"></div>
<script type="text/javascript">

  var marker;
  function initMap() {
    var myLat = parseFloat(document.getElementById("latitude").value);
    var myLng = parseFloat(document.getElementById("longitude").value);
    var myTitleEvent = document.getElementById("eventName").innerHTML;
    var eventLocation = {lat: myLat, lng: myLng};

    var map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: myLat, lng: myLng},
      zoom: 12
    });

      marker = new google.maps.Marker({
        position: eventLocation,
        map: map,
        title: myTitleEvent
      });

    map.addListener('click', function(e) {
      marker.setMap(null);
      eventLocation = e.latLng;
      document.modifyevent.latitude.value = eventLocation.lat();
      document.modifyevent.longitude.value = eventLocation.lng();
      placeMarkerAndPanTo(e.latLng, map);
    });

  }

  function placeMarkerAndPanTo(eventLocation, map) {
    marker = new google.maps.Marker({
      position: eventLocation,
      map: map
    });

    map.panTo(eventLocation);

  }


</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUpMRaMT_QeweKFcoI59XGpstCWF8qfIQ&callback=initMap">
</script>
<% session.setAttribute("user",user); %>
<a href="eventuserlist?UserID=<%=user.getUserId() %>">Back to Event List</a>
</body>
</html>