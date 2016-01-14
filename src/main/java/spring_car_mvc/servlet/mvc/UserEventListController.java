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
@RequestMapping("/userEventList.jsp")
public class UserEventListController implements MVCController {

    @Autowired
    private EventDAOImpl eventDAO;

    public MVCModel processRequest(HttpServletRequest req) {
        Long userId = Long.valueOf(req.getParameter("UserID"));
        List<Event> events = new ArrayList<Event>();

        try {
            events = eventDAO.getListEventByUserId(userId);
            return new MVCModel(events, "/userEventList.jsp");

        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }

    }

}