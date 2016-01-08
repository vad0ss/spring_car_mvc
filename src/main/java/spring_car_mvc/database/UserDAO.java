package spring_car_mvc.database;

import spring_car_mvc.domain.User;

/**
 * Created by on 06/09/2015.
 */
public interface UserDAO {

    User getById(Long id) throws DBException;

}

