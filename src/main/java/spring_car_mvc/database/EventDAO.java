package spring_car_mvc.database;

import spring_car_mvc.domain.Event;

import java.util.List;

/**
 * Created by Dell on 09.01.2016.
 */
public interface EventDAO {

    void createEvent(Event event) throws DBException;
    Event getById(int eventID) throws DBException;
    List<Event> getListEventByUserId(long userId) throws DBException;
    void deleteEventById(int event_id) throws DBException;
    void modifyEvent(Event event, int event_Id) throws DBException;

}
