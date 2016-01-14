package spring_car_mvc.servlet.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.UserDAOImpl;
import spring_car_mvc.domain.User;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by Dell on 08.01.2016.
 */

@Controller
@RequestMapping("/login.jsp")
public class AuthorizationController implements MVCController {

    @Autowired
    private UserDAOImpl userDAO;

    public MVCModel processRequest(HttpServletRequest req) {

        String username = req.getParameter("user");
        String password = req.getParameter("pass");

        try {
            User user = userDAO.getByUserName(username);
            if(user == null) return new MVCModel(null, "/login.jsp");

            if (user.getPassword().equals(password)) {
                return new MVCModel(user, "/usersById.jsp");
            } else {
                return new MVCModel(null, "/login.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/errorpage.jsp");
        }
    }
}
