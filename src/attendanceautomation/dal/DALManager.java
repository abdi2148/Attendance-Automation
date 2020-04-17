/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import attendanceautomation.be.Attendance;
import attendanceautomation.be.User;
import attendanceautomation.be.Course;
import attendanceautomation.bll.BLLManager;
import attendanceautomation.be.Subject;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */


public class DALManager implements IDAL {
    private AttendanceDAO attendanceDao;
    private UserDAO userDao;
    
    
    public DALManager() {
          attendanceDao = new AttendanceDAO();
          userDao = new UserDAO();
    } 
 
    @Override
    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public User getUser(int userKey) {
        try {
            return userDao.getUser(userKey);
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher) {
        return userDao.addNewUserToDB(userName, password, email, phoneNr, address, postCode, city, teacher);
    }
    

    @Override
    public User editUser(User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher) {
        return userDao.editUser(userToEdit, userName, password, email, phoneNr, address, postCode, city, teacher);
    }

    
    @Override
    public void removeUserFromDB(User userToDelete) {
        userDao.removeUserFromDB(userToDelete);
    }

   
     @Override
    public int checkUserLogin (String email, String password) { try {
        return userDao.checkUserLogin(email,password);
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }

    @Override
    public boolean checkIfTeacher(String email) {
        try {
            return userDao.checkIfTeacher(email);
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    @Override
    public List<Course> getAllAttendances() {
        try {
            return attendanceDao.getAllAttendances();
        } catch (SQLException ex) {
            Logger.getLogger(DALManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
