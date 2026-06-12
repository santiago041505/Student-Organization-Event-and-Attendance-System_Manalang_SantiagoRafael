/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentorg;

/**
 *
 * @author easterPC
 */
public class Attendance {
    private int attendanceId;
    private int eventId;
    private String studentId;
    private String status;

    
    public Attendance(int attendanceId, int eventId, String studentId, String status) {
        this.attendanceId = attendanceId;
        this.eventId = eventId;
        this.studentId = studentId;
        this.status = status;
    }

    public int getAttendanceId() { return attendanceId; }
    public void setAttendanceId(int attendanceId) { this.attendanceId = attendanceId; }
    
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }
    
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
