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
<%
  User user = (User)session.getAttribute("user");
  List<Event> events = (ArrayList)request.getAttribute("model");
%>
<html>
<head>
    <title>User <%=user.getUserName()%></title>
  <style type="text/css">
    #map {
      width: 450px;
      height: 500px;
    }
  </style>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<h1>User your were looking for is found:</h1>
  Welcome User <strong><%=user.getUserName()%></strong>
<br />
   <a href="addEvent.jsp?UserID=<%=user.getUserId()%>">Add Event</a>
   <a href="eventuserlist?UserID=<%=user.getUserId()%>">User Event list</a>
<br />
<br />
Events:
<ul>
  <table cellpadding="0" cellspacing="0">
    <% for(int eventCount = 0; eventCount < events.size(); eventCount++) { %>
    <tr>
      <td>
        <li>
          <a href="modifyevent?eventID=<%=events.get(eventCount).getEventId()%>">
            <div id="eventname<%=events.get(eventCount).getEventId()%>"><%=events.get(eventCount).getEventName()%></div>
          </a>
          <input type="hidden" id="eventId" name="eventId" value="<%=events.get(eventCount).getEventId()%>" />
          <input type="hidden" id="latitude<%=events.get(eventCount).getEventId()%>" value="<%=events.get(eventCount).getLatitude()%>" />
          <input type="hidden" id="longitude<%=events.get(eventCount).getEventId()%>" value="<%=events.get(eventCount).getLongitude()%>" />
      </td>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td>
        <a href="deleteEvent?eventID=<%=events.get(eventCount).getEventId()%>">
          Delete Event
        </a>
        </li>
      </td>
    </tr>
    <%  } %>
  </table>
</ul>

<div id="map"></div>
<script type="text/javascript">

  var marker;
  function initMap() {
    var eventsCounter = document.getElementsByName("eventId").length;
    var eventId = [eventsCounter];
    eventId[0] = document.getElementsByName("eventId")[0].value;
    var myLat = parseFloat(document.getElementById("latitude"+eventId[0]).value);
    var myLng = parseFloat(document.getElementById("longitude"+eventId[0]).value);

    var map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: myLat, lng: myLng},
      zoom: 12
    });

    for (var i = 0; i < eventsCounter; i++) {
      eventId[i] = document.getElementsByName("eventId")[i].value;
      myLat = parseFloat(document.getElementById("latitude"+eventId[i]).value);
      myLng = parseFloat(document.getElementById("longitude"+eventId[i]).value);
      var myTitleEvent = document.getElementById("eventname"+eventId[i]).innerHTML;
      var eventLocation = {lat: myLat, lng: myLng};
      var marker = new google.maps.Marker({
        position: eventLocation,
        map: map,
        title: myTitleEvent
      });
    }
  }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCUpMRaMT_QeweKFcoI59XGpstCWF8qfIQ&callback=initMap">
</script>
<% session.setAttribute("user",user); %>
</body>
</html>