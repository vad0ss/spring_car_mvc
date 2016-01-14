package database.jdbc;

import org.junit.*;
import spring_car_mvc.database.DBException;
import spring_car_mvc.database.jdbc.EventDAOImpl;
import spring_car_mvc.domain.Event;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Dell on 10.01.2016.
 */
public class EventDAOImplTest {
    private static EventDAOImpl eventDAOImpl;
    private static UserDAOImplTest userDAOImpl;
    private static Event event;

    public static void init() {
        eventDAOImpl = new EventDAOImpl();
        userDAOImpl = new UserDAOImplTest();
        event = new Event();
    }

    @Test
    public void createEventTest() throws DBException {
        init();
        event.setEventName("testEvent");
        eventDAOImpl.createEvent(event);
        Event testEvent = eventDAOImpl.getById(3);
        assertEquals(testEvent.getEventName(),"testEvent");
    }

    @Test
    public void getListEventByUserIdTest() throws DBException {
        List<Event> events = new ArrayList<Event>();
        events = eventDAOImpl.getListEventByUserId(1);

        assertEquals(events.get(0).getEventName(),"testEvent");
        assertEquals(events.get(1).getEventName(),"websiteTestUserTest");
    }


    @Test
    public void modifyEventTest() throws DBException {
        init();
        event.setEventName("TestModify2");

        eventDAOImpl.modifyEvent(event,32);
        Event modifyEvent = null;
        try {
            modifyEvent = eventDAOImpl.getById(32);
        } catch (DBException e) {
            e.printStackTrace();
        }

        assertEquals(modifyEvent.getEventName(),"TestModify2");
    }
}