/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TeacherDAO {
     private DBConnection db;
      public List<Subject> getSubjects() throws SQLException 
    {
        db = new DBConnection();
        List<Subject> allSubjects = new ArrayList();
           
        try(Connection con = db.getConnection()){
            String SQLStmt = "SELECT * FROM SUBJECTS;";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            
            while(rs.next()) 
            {  
                int subjectKey = rs.getInt("SubjectKey");
                String subjectName = rs.getString("SubjectName");
                String associatedCourse = rs.getString("AssociatedCourse");
                String associatedTeacher = rs.getString("AssociatedTeacher");
                Subject p = new Subject(subjectKey,subjectName,associatedCourse,associatedTeacher);
                allSubjects.add(p);
            }    
        }
       return allSubjects;
    }
     public Subject assignTeacherClass(Subject subject, String teacher) throws SQLException 
    {
        db = new DBConnection();
        
        try(Connection con = db.getConnection()){
            String SQLStmt = "UPDATE SUBJECTS SET AssociatedTeacher = ? WHERE id = ?;";
            
            PreparedStatement pstmt = con.prepareStatement(SQLStmt);
             pstmt.setString(1,teacher);
            pstmt.setInt(2,subject.getSubjectKey());
        }
        return new Subject(subject.getSubjectKey(),subject.getSubjectName(),subject.getAssociatedCourse(),teacher);
}
}
