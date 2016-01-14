package spring_car_mvc.database.jdbc;

import spring_car_mvc.database.DBException;
import spring_car_mvc.database.UserDAO;
import spring_car_mvc.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Prilepishev Vadim.
 */

@Component
public class UserDAOImpl extends DAOImpl implements UserDAO {
    private Connection connection = null;


    public User getById(Long id) throws DBException {

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from user where ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("ID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public User getByUserName(String username) throws DBException {

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from user where username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("ID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("Password"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while executing UserDAOImpl.getByUserName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
