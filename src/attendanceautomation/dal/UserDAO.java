/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import attendanceautomation.be.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */


public class UserDAO {
        private DBConnection dbc;

    public UserDAO() {
        dbc = new DBConnection();
    }
        
   
    public List<User> getAllUsers() throws SQLException{
        List<User> allUsers = new ArrayList(); 
        try(Connection con = dbc.getConnection()){
            String SQLStmt = "SELECT userKey, userName, password, email, phonenr, address, postCode, city, teacher,   FROM USERS;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next())
            {
                int userKey = rs.getInt("userKey");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                int phoneNr = rs.getInt("phonenr");
                String address = rs.getString("address");
                int postCode = rs.getInt("postCode");
                String city = rs.getString("city");
                int isteacher = rs.getInt("teacher");
                boolean teacher = false;
                if(isteacher == 0)
                {
                    teacher = false;
                }
                else if(isteacher==1)
                {
                    teacher = true;
                }
               allUsers.add(new User(userKey, userName, password, email, phoneNr, address, postCode, city, teacher)); 
            }    
        }
        return allUsers;
    }
        
    
    public User getUser(int userKey) throws SQLException {
        List<User> allUsers = getAllUsers();
        User user;
        for (int i = 0; i < allUsers.size(); i++) {
            user = allUsers.get(i);
            int testKey = user.getUserKey();
            if (testKey == userKey)  {
            return user;
            }
        }
        return null;  
    }
    
    
     public User addNewUserToDB(String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher) { 
        String sql = "INSERT INTO Users(userName, password, email, phoneNr, address, postCode, city, teacher) VALUES (?,?,?,?,?,?,?,?,?)";
        User newUser = new User(postCode, userName, password, email, phoneNr, address, postCode, city, teacher);
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setInt(4, phoneNr);
            stmt.setString(5, address);
            stmt.setInt(6, postCode);
            stmt.setString(7, city);
            int isteacher = 0;
            if(teacher == true)
            {
                isteacher =1;
            }
            else if (teacher=false)
            {
                isteacher=1;
            }
            stmt.setInt(8, isteacher);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newUser.setUserKey((int) generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                } 
                return newUser;
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
    public User editUser (User userToEdit, String userName, String password, String email, int phoneNr, String address, int postCode, String city, boolean teacher) { 
        try (//Get a connection to the database.
            Connection con = dbc.getConnection()) {
            //Create a prepared statement.
            String sql = "UPDATE Users SET userName = ?, password = ?, email = ?, phoneNr = ? , address = ? , postCode = ? , city = ? , teacher = ?, WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter values.
           pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setInt(4, phoneNr);
            pstmt.setString(5, address);
            pstmt.setInt(6, postCode);
            pstmt.setString(7, city);
            int isteacher = 0;
            if(teacher == true)
            {
                isteacher =1;
            }
            else if (teacher=false)
            {
                isteacher=1;
            }
            pstmt.setInt(8, isteacher);
            pstmt.setInt(9, userToEdit.getUserKey());
            //Execute SQL query.
            pstmt.executeUpdate();
            userToEdit.setUserName(userName);
            userToEdit.setPassword(password);   
            userToEdit.setEmail(email);
            userToEdit.setPhoneNr(phoneNr);
            userToEdit.setAddress(address);
            userToEdit.setPostCode(postCode);
            userToEdit.setCity(city);
            userToEdit.setTeacher(teacher);
            return userToEdit;
        } catch (SQLServerException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

       
    public void removeUserFromDB(User userToDelete) {
        String stat = "DELETE FROM Users WHERE id =?";     
        try (Connection con = dbc.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(stat);
            stmt.setInt(1,userToDelete.getUserKey());                
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Exception " + ex);
        }
    }
      
    
    public int checkUserLogin(String email, String password) throws SQLException {  
        List<User> allUsers = getAllUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            User userToCheck = allUsers.get(i);
            if ((userToCheck.getEmail().equals(email)) && (userToCheck.getPassword().equals(password))) {
                if(userToCheck.getTeacher() == true)
                {
                    return 1;
                }
                else if(userToCheck.getTeacher() == false)
                {
                    return 2;
                }
            }
        }
        return 0;
    }
    
    
    public boolean checkIfTeacher(String email) throws SQLException {
        List<User> allUsers = getAllUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            User userToCheck = allUsers.get(i);
            if (userToCheck.getEmail().equals(email)) {
                if (userToCheck.getTeacher()) {
                return true;
            } else {
                    return false;
                }
            }
        }
        return false;
    }
        
        
    public String getUserNameFromKey(int studentKey) throws SQLException {
        List<User> allUsers = getAllUsers();
        for (int i = 0; i < allUsers.size(); i++) {
            User testUser = allUsers.get(i);
            if (testUser.getUserKey() == studentKey) {
                return testUser.getUserName();
            }
        }
        return null;
    }
   
   
    public String getAllStudentsInASubject(int studentKey) throws SQLException {   
        return null;  
    }
}