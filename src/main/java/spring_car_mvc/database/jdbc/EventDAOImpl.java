package spring_car_mvc.database.jdbc;

import org.springframework.stereotype.Component;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.EventDAO;
import spring_car_mvc.domain.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 09.01.2016.
 */
@Component
public class EventDAOImpl extends DAOImpl implements EventDAO {
    private Connection connection = null;

    public void createEvent(Event event) throws DBException {
         try {
             connection = getConnection();
             String query = " insert into events (event_name," +
                     "user_id," +
                     "latitude," +
                     "longitude)"
                     + " values (?,?,?,?)";
            PreparedStatement preparedStatement = connection
                    .prepareStatement(query);
             preparedStatement.setString(1,event.getEventName());
             preparedStatement.setLong(2,event.getUserId());
             preparedStatement.setFloat(3,event.getLatitude());
             preparedStatement.setFloat(4,event.getLongitude());
             preparedStatement.execute();
        } catch (Throwable e) {
            System.out.println("Exception while executing Create Event");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Event getById(int eventId) throws DBException {
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from events where event_id = ?");
            preparedStatement.setInt(1, eventId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Event event = null;
            if (resultSet.next()) {
                event = new Event();
                event.setEventId(resultSet.getInt("event_id"));
                event.setEventName(resultSet.getString("event_name"));
                event.setLatitude(resultSet.getFloat("latitude"));
                event.setLongitude(resultSet.getFloat("longitude"));
            }
            return event;
        } catch (Throwable e) {
            System.out.println("Exception while executing Event GetById");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Event> getListEventByUserId(long userId) throws DBException {
        Event event = null;

        connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement("select * from events where user_id = ?");
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Event> events = new ArrayList<Event>();
            while(resultSet.next()) {
                    event = new Event();
                    event.setEventId(resultSet.getInt("event_id"));
                    event.setEventName(resultSet.getString("event_name"));
                    event.setLatitude(resultSet.getFloat("latitude"));
                    event.setLongitude(resultSet.getFloat("longitude"));
                    events.add(event);
            }
            return events;
        } catch (Throwable e) {
            System.out.println("Exception while executing list Event GetById");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public void deleteEventById(int event_Id) throws DBException {
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from events where event_id = ?");
            preparedStatement.setInt(1, event_Id);
            preparedStatement.execute();
        } catch (Throwable e) {
            System.out.println("Exception while executing Event GetById");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void modifyEvent(Event event, int event_Id) throws DBException {
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update events set event_name = ? where event_id = ?");
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setInt(2, event_Id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while executing modify Event");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
