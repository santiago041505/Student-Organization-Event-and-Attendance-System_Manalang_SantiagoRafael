/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentorg;

/**
 *
 * @author easterPC
 */
public class Student extends Person{
   private String studentId;
    private String course;

    public Student(String studentId, String fullName, String course) {
        super(fullName); 
        this.studentId = studentId;
        this.course = course;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}
