package spring_car_mvc.servlet.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.EventDAOImpl;
import spring_car_mvc.domain.Event;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 11.01.2016.
 */
@Controller
@RequestMapping("/deleteEvent.jsp")
public class DeleteEventController implements MVCController {

    @Autowired
    private EventDAOImpl eventDAO;

    public MVCModel processRequest(HttpServletRequest req) {
        int eventId = Integer.valueOf(req.getParameter("eventID"));

        try {
            eventDAO.deleteEventById(eventId);
            return new MVCModel(null, "/deleteEvent.jsp");

        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }


}
