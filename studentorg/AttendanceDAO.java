/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentorg;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author easterPC
 */
public class AttendanceDAO {
    public boolean addAttendance(Attendance attendance) {
        String sql = "INSERT INTO attendances (event_id, student_id, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, attendance.getEventId());
            pstmt.setString(2, attendance.getStudentId());
            pstmt.setString(3, attendance.getStatus());
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error recording attendance: " + e.getMessage());
            return false;
        }
    }

    public List<Attendance> getAttendanceByEvent(int eventId) {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendances WHERE event_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, eventId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getInt("event_id"),
                        rs.getString("student_id"),
                        rs.getString("status")
                    ));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading attendance: " + e.getMessage());
        }
        return list;
    }
    public List<Attendance> getAllAttendance() {
        List<Attendance> list = new ArrayList<>();
        String query = "SELECT * FROM attendances";         
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Attendance a = new Attendance(
                    rs.getInt("attendance_id"),
                    rs.getInt("event_id"),
                    rs.getString("student_id"),
                    rs.getString("status")
                );
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
