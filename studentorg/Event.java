/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentorg;
import java.sql.Date;
/**
 *
 * @author easterPC
 */
public class Event {
    private int eventId;
    private int orgId;
    private String eventName;
    private Date eventDate; // Using java.sql.Date to easily match the MySQL DATE format

    // Constructor
    public Event(int eventId, int orgId, String eventName, Date eventDate) {
        this.eventId = eventId;
        this.orgId = orgId;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    // Getters and Setters
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }
    
    public int getOrgId() { return orgId; }
    public void setOrgId(int orgId) { this.orgId = orgId; }
    
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    
    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }
}
