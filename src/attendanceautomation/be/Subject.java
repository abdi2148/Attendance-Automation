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


public class Subject {
    private int subjectKey;
    private String subjectName;
    private String associatedCourse;
    private String associatedTeacher;
    
    
    public Subject (int subjectKey, String subjectName,String associatedCourse, String associatedTeacher ){
    
        this.subjectKey = subjectKey;
        this.subjectName = subjectName;
        this.associatedCourse = associatedCourse;
        this.associatedTeacher = associatedTeacher;
        
    }

    public int getSubjectKey() {
        return subjectKey;
    }

    public void setSubjectKey(int subjectKey) {
        this.subjectKey = subjectKey;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setClassName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAssociatedCourse() {
        return associatedCourse;
    }

    public void setAssociatedCourse(String associatedCourse) {
        this.associatedCourse = associatedCourse;
    }

    public String getAssociatedTeacher() {
        return associatedTeacher;
    }

    public void setAssociatedTeacher(String associatedTeacher) {
        this.associatedTeacher = associatedTeacher;
    }
    
    
}
