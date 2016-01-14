package spring_car_mvc.servlet.mvc;


import org.springframework.stereotype.Controller;
import spring_car_mvc.database.jdbc.UserDAOImpl;
import spring_car_mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import spring_car_mvc.database.DBException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by on 08/09/2015.
 */

@Controller
@RequestMapping("/")
public class UserGetByIdController implements MVCController {

  @Autowired
    private UserDAOImpl userDAO;

    String username;

    public MVCModel processRequest(HttpServletRequest req) {

        String sid = req.getParameter("UserID");
        Long id = Long.valueOf(sid);
        try {
            User user = userDAO.getById(id);

            if (user.getUserId() == id) {
                return new MVCModel(user, "/usersById.jsp");
            } else {
                return new MVCModel(null, "/noUserFound.jsp");
           }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
