/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.be;

/**
 *
 * @author PC
 */
public class Course {
    

    private int studentKey;
    private int subjectKey;
    private String dateHeld;
        
        
public Course(int studentKey, int subjectKey, String dateHeld){

    this.studentKey = studentKey;
    this.subjectKey = subjectKey;
    this.dateHeld = dateHeld;
}


    public int getStudentKey() {
        return studentKey;

    }
    
    public void setStudentKey(int studentKey) {
        this.studentKey = studentKey;

    }
        
    public int getSubjectKey() {
        return subjectKey;
    }

    
    public void setSubjectKey(int subjectKey) {
        this.subjectKey = subjectKey;
    }

    public String getDateHeld() {
        return dateHeld;

    }

    public void setDateHeld(String dateHeld) {
        this.dateHeld = dateHeld;
    }
        
        
}


