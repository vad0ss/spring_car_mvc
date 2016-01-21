package spring_car_mvc.servlet.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.EventDAOImpl;
import spring_car_mvc.domain.Event;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 09.01.2016.
 */
@Controller
@RequestMapping("/addEvent.jsp")
public class AddEventController implements MVCController {

    @Autowired
    private EventDAOImpl eventDAO;

    public MVCModel processRequest(HttpServletRequest req) throws ParseException {
        String eventName = req.getParameter("eventName");
        Long userId = Long.valueOf(req.getParameter("userID"));
        Float latitude = Float.valueOf(req.getParameter("latitude"));
        Float longitude = Float.valueOf(req.getParameter("longitude"));
        String strDatetime = req.getParameter("datetimepicker");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(strDatetime); // mysql datetime format
        Event event = new Event();
        event.setEventName(eventName);
        event.setUserId(userId);
        event.setLatitude(latitude);
        event.setLongitude(longitude);
        event.setDate(date);

        try {
            eventDAO.createEvent(event);
            List<Event> events = eventDAO.getListEvent();
            return new MVCModel(events, "/userPage.jsp");
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }

    }
}