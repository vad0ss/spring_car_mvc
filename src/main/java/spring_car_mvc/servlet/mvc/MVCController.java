package spring_car_mvc.servlet.mvc;

/**
 * Created by Prilepishev Vadim on 31.12.2015.
 */
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface MVCController {

    MVCModel processRequest(HttpServletRequest req) throws ParseException;

}
