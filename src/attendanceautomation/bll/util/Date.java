/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll.util;

import attendanceautomation.bll.BLLManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import attendanceautomation.bll.IBLL;

/**
 *
 * @author PC
 */


public class Date {
    
    public String dateNowToString() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dateNowString = now.format(formatter);
        return dateNowString;
    } 
   
    
    public LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDate dateNow = LocalDate.parse(dateString, formatter);
        return dateNow;
    }

}
