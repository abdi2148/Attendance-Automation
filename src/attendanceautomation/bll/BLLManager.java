/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.bll;

import attendanceautomation.be.Course;
import attendanceautomation.be.User;
import attendanceautomation.dal.DALManager;
import java.util.List;


/**
 *
 * @author PC
 */


public class BLLManager implements IBLL {
    private DALManager dalManager = new DALManager();

    
    
    @Override
    public List<User> getAllUsers() {
        return dalManager.getAllUsers();
        }

    
    @Override
    public User getUser(int userKey) {
            return dalManager.getUser(userKey);
    }

    
    @Override
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher) {
        return dalManager.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher) {
        return dalManager.editUser(userToEdit, userName, password, email, phoneNr, address, postCode, city, teacher);
    }

    
    @Override
    public void removeUserFromDB(User userToDelete) {
        dalManager.removeUserFromDB(userToDelete);
    }

    
    @Override
    public int checkUserLogin (String email, String password) {
        return dalManager.checkUserLogin(email,password);
    }

   
    @Override
    public boolean checkIfTeacher(String email) {
        return dalManager.checkIfTeacher(email);
    }

    
    @Override
    public List<Course> getAllAttendances() {
        return dalManager.getAllAttendances();
        }
    
}
