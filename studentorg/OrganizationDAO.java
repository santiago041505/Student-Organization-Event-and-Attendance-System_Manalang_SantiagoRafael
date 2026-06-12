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
public class OrganizationDAO {
    public boolean addOrganization(Organization org) {
        String sql = "INSERT INTO organizations (org_name, description) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, org.getOrgName());
            pstmt.setString(2, org.getDescription());
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding org: " + e.getMessage());
            return false;
        }
    }

    public List<Organization> getAllOrganizations() {
        List<Organization> list = new ArrayList<>();
        String sql = "SELECT * FROM organizations";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Organization(
                    rs.getInt("org_id"),
                    rs.getString("org_name"),
                    rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading orgs: " + e.getMessage());
        }
        return list;
    }
}
