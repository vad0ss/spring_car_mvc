package spring_car_mvc.servlet.mvc;

/**
 * Created by Prilepishev Vadim on 31.12.2015.
 */
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

public interface MVCController {

    MVCModel processRequest(HttpServletRequest req);

}
