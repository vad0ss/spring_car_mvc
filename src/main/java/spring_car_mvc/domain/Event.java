package spring_car_mvc.domain;

/**
 * Created by Dell on 09.01.2016.
 */
public class Event {
    private int eventId;
    private String eventName;
    private long userId;
    private float latitude;
    private float longitude;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }



    public int getEventId() { return eventId; }

    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getEventName() { return eventName; }

    public void setEventName(String eventName) { this.eventName = eventName; }

    public long getUserId() { return userId; }

    public void setUserId(long userId) { this.userId = userId; }
}
