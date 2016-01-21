package spring_car_mvc.servlet.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.EventDAOImpl;
import spring_car_mvc.domain.Event;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dell on 12.01.2016.
 */
@Controller
@RequestMapping("/modifyevent")
public class ModifyEventController implements MVCController {

    @Autowired
    private EventDAOImpl eventDAO;

    public MVCModel processRequest(HttpServletRequest req) {
        Event event = new Event();
        int eventId = Integer.valueOf(req.getParameter("eventID"));
        if(req.getParameter("eventName") != null) {
            float latitude = Float.valueOf(req.getParameter("latitude"));
            float longitude = Float.valueOf(req.getParameter("longitude"));
            event.setEventName(req.getParameter("eventName"));
            event.setLatitude(latitude);
            event.setLongitude(longitude);
        }
        else {
            try {
                event.setEventName(eventDAO.getById(eventId).getEventName());
                event.setLatitude(eventDAO.getById(eventId).getLatitude());
                event.setLongitude(eventDAO.getById(eventId).getLongitude());
            } catch (DBException e) {
                e.printStackTrace();
            }
        }

        try {
            eventDAO.modifyEvent(event,eventId);
            return new MVCModel(eventDAO.getById(eventId), "/modifyEventById.jsp");

        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }

}
