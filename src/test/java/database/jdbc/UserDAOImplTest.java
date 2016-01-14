package database.jdbc;

import org.junit.*;


import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.UserDAOImpl;
import spring_car_mvc.domain.User;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Prilepishev Vadim on 02.01.2016.
 */
public class UserDAOImplTest {

    @Test
    public void getByIdTest() throws DBException {
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        User user = userDAOImpl.getById(Long.valueOf(1));

        long userID = user.getUserId();
        String username = user.getUserName();
        String password = user.getPassword();

        assertEquals(userID,1);
        assertEquals(username,"test");
        assertEquals(password,"test");

    }

    @Test
    public void getByUserNameTest() throws DBException {
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        User user = userDAOImpl.getById(Long.valueOf(1));

        String username = user.getUserName();
        String password = user.getPassword();

        assertEquals(username,"test");
        assertEquals(password,"test");

    }
}
