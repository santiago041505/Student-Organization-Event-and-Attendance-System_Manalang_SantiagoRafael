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
public class StudentDAO {
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (student_id, full_name, course) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getFullName()); // Inherited from Person!
            pstmt.setString(3, student.getCourse());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding student: " + e.getMessage());
            return false;
        }
    }

    // 2. READ: Get a list of all students for your JTable
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student(
                    rs.getString("student_id"),
                    rs.getString("full_name"),
                    rs.getString("course")
                );
                list.add(student);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading students: " + e.getMessage());
        }
        return list;
    }

    // 3. UPDATE: Modify an existing student's info
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET full_name = ?, course = ? WHERE student_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, student.getFullName());
            pstmt.setString(2, student.getCourse());
            pstmt.setString(3, student.getStudentId());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating student: " + e.getMessage());
            return false;
        }
    }

    // 4. DELETE: Remove a student safely
    public boolean deleteStudent(String studentId) {
        String sql = "DELETE FROM students WHERE student_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, studentId);
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting student: " + e.getMessage());
            return false;
        }
    }

    // 5. SEARCH: Find students by ID or Name
    public List<Student> searchStudents(String keyword) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE student_id LIKE ? OR full_name LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student(
                        rs.getString("student_id"),
                        rs.getString("full_name"),
                        rs.getString("course")
                    );
                    list.add(student);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error searching students: " + e.getMessage());
        }
        return list;
    }
}
