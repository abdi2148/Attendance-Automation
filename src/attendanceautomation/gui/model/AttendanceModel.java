/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.model;

import attendanceautomation.bll.BLLManager;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public class AttendanceModel {
    private BLLManager bllManager;
    private ObservableList<String> course;
    

    public AttendanceModel() {
        bllManager = new BLLManager();
        
    }

}
