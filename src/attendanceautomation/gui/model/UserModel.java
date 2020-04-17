/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.model;

import attendanceautomation.bll.BLLManager;

/**
 *
 * @author PC
 */
public class UserModel {
    private BLLManager bllManager;

    public UserModel() {
        bllManager = new BLLManager();
    }
    

    public int CheckUser(String email, String password ){
        int loginstate = bllManager.checkUserLogin(email, password); 

        return loginstate;     
    }
}
