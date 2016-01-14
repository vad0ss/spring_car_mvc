package spring_car_mvc.servlet.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.EventDAOImpl;
import spring_car_mvc.domain.Event;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dell on 09.01.2016.
 */
@Controller
@RequestMapping("/addEvent.jsp")
public class AddEventController implements MVCController {

    @Autowired
    private EventDAOImpl eventDAO;

    public MVCModel processRequest(HttpServletRequest req) {
        String eventName = req.getParameter("eventName");
        Long userId = Long.valueOf(req.getParameter("userID"));
        Float latitude = Float.valueOf(req.getParameter("latitude"));
        Float longitude = Float.valueOf(req.getParameter("longitude"));
        Event event = new Event();
        event.setEventName(eventName);
        event.setUserId(userId);
        event.setLatitude(latitude);
        event.setLongitude(longitude);

        try {
            eventDAO.createEvent(event);
            return new MVCModel(null, "/usersById.jsp");
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }

    }
}