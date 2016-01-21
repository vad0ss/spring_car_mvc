package spring_car_mvc.servlet.mvc;


import org.springframework.stereotype.Controller;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.EventDAOImpl;
import spring_car_mvc.database.jdbc.UserDAOImpl;
import spring_car_mvc.domain.Event;
import spring_car_mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by on 08/09/2015.
 */

@Controller
@RequestMapping("/userPage.jsp")
public class UserPage implements MVCController {

    @Autowired
    private EventDAOImpl eventDAO;

    public MVCModel processRequest(HttpServletRequest req) {

        try {
            List<Event> events = eventDAO.getListEvent();

            if (events != null) {
                return new MVCModel(events, "/userPage.jsp");
            } else {
                return new MVCModel(null, "/noUserFound.jsp");
           }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
