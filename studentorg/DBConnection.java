/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentorg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author easterPC
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EventAttendanceDB";
    private static final String USER = "root"; // Change if needed
    private static final String PASS = "kissmuna123";     // Change if needed

   public static Connection getConnection() {
        try {
            // THIS IS THE LINE FIXING YOUR ERROR:
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed: " + e.getMessage());
            return null;
        }
    }
}
