# Student-Organization-Event-and-Attendance-System_Manalang_SantiagoRafael

Key Components
LoginFrame: The secure entry point requiring admin authentication.

DashboardFrame: The central navigation hub managing the administrative tabs.

StudentTab: Form and data grid handling student registrations.

OrganizationTab: Handles registering different student groups and hosting configurations.

EventsAndAttendance: Frame used to organize event names, scheduling, and host allocations.

RecordAttendance: A specialized junction window linking events to student rosters with custom participation status tracking (Present, Absent, Late).

## Before launching the Java application, you must configure the database backend. Open MySQL Workbench or your preferred SQL terminal and execute the script below to build the relational schema:

-- 1. Create and select the database cluster
CREATE DATABASE IF NOT EXISTS eventattendancedb;
USE eventattendancedb;

-- 2. Build the Organizations registry table
CREATE TABLE IF NOT EXISTS organizations (
    org_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

-- 3. Build the Student profile table
CREATE TABLE IF NOT EXISTS students (
    student_id VARCHAR(20) PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    course VARCHAR(50) NOT NULL
);

-- 4. Build the Events ledger table (linked to Organizations)
CREATE TABLE IF NOT EXISTS events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    org_id INT NOT NULL,
    event_name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    FOREIGN KEY (org_id) REFERENCES organizations(org_id) ON DELETE RESTRICT
);

-- 5. Build the Attendance transaction junction table (linked to both Events and Students)
CREATE TABLE IF NOT EXISTS attendances (
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    student_id VARCHAR(20) NOT NULL,
    status VARCHAR(20) DEFAULT 'Present',
    FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE
);

-- 6. Seed initial Admin login account credentials
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) DEFAULT 'Admin'
);

INSERT INTO users (username, password, role) 
VALUES ('admin', 'admin123', 'Admin')
ON DUPLICATE KEY UPDATE username=username;

1. Library Dependencies
The application relies on the JDBC connector driver to communicate with your local database engine.

Ensure mysql-connector-j-9.6.0.jar (or your active version) is explicitly added under the Libraries node inside your NetBeans project sidebar.

2. Database Connection Check
Open the DBConnection.java file and verify the connection string match parameters:

3. Launching the App
*Set the application entry point inside your project's main class (e.g., StudentOrg.java) using this code template:
*Alternatively, right-click LoginFrame.java or Login.java in your project explorer and choose Run File (or press Shift + F6).
*Log in using the system default administrative access:
Username: admin
Password: admin123
