/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.time.format.DateTimeFormatter;
import attendanceautomation.be.User;
import attendanceautomation.be.Course;
import attendanceautomation.be.Subject;
import attendanceautomation.be.Attendance;
import attendanceautomation.bll.BLLManager;




/**
 *
 * @author PC
 */


public class AttendanceDAO {
 
    private DBConnection dbc;
    public List<Course> attendance;
    public UserDAO newUserDao;
    
    
public AttendanceDAO() {

        newUserDao = new UserDAO();
        dbc = new DBConnection();
    }
    
     public List<Course> getAllAttendances() throws SQLException{
        List<Course> allAttendance = new ArrayList(); 
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT * FROM ATTENDANCE;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next()) 
            {
                int userKey = rs.getInt("UserKey");
                int subjectKey = rs.getInt("SubjectKey");
                String dateHeld =  rs.getString("DateHeld");
               allAttendance.add(new Course(userKey, subjectKey, dateHeld)); 
            }    
        }
        return allAttendance;
    }
     
    public List<Course> getStudentAttendanceForSubject(int studentKey, int subjectKey) throws SQLException {
        List<Course> allAttendances = getAllAttendances();
        List<Course> studentAttendanceInSubject = new ArrayList<>();
        Course testAttendance;
        for (int i = 0; i < allAttendances.size(); i++) {
            testAttendance = allAttendances.get(i);
            if (testAttendance.getStudentKey() == studentKey) {
                if (testAttendance.getSubjectKey() == subjectKey) {
                studentAttendanceInSubject.add(testAttendance);
                }
            }
        }
        return studentAttendanceInSubject;
    }

    public List<Course> getAllAttendanceForSubject(int subjectKey) throws SQLException {
        List<Course> allAttendances = getAllAttendances();
        List<Course> allAttendanceInSubject = new ArrayList<>();
        Course testAttendance;
        for (int i = 0; i < allAttendances.size(); i++) {
            testAttendance = allAttendances.get(i);
            if (testAttendance.getSubjectKey() == subjectKey) {
                allAttendanceInSubject.add(testAttendance);
            }
        }
        return allAttendanceInSubject;
    }

        
    public int[] listOfAttendanceToIntArrayOfDays(List<Course> attendanceList) {
        int[] dailyAttendanceIntArray = new int[5];
        int attendanceTotal = attendanceList.size();
            for (int i = 0; i < attendanceTotal; i++) {
                Course attendance = attendanceList.get(i);
                String dateHeldString = attendance.getDateHeld();
                LocalDate dateHeld = stringToLocalDate(dateHeldString);
                int dayOfWeek = (dateHeld.getDayOfWeek().getValue()) - 1; 
                dailyAttendanceIntArray[dayOfWeek] ++;
            }
        return dailyAttendanceIntArray;
    }
    
   
    public String dateNowToString() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateNowString = now.format(formatter);
        return dateNowString;
    } 
    
    
    public String localDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateString = date.format(formatter);
        return dateString;
    } 
    
    
     public LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }
    
     public String course() {
        String course = "English Course";
        return course;
    }      
}

