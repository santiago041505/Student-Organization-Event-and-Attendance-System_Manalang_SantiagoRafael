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
public class EventDAO {
    public boolean addEvent(Event event) {
        String sql = "INSERT INTO events (org_id, event_name, event_date) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, event.getOrgId());
            pstmt.setString(2, event.getEventName());
            pstmt.setDate(3, event.getEventDate());
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding event: " + e.getMessage());
            return false;
        }
    }

    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Event(
                    rs.getInt("event_id"),
                    rs.getInt("org_id"),
                    rs.getString("event_name"),
                    rs.getDate("event_date")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading events: " + e.getMessage());
        }
        return list;
    }
}
