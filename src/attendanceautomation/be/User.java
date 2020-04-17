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
public class User {
    private int userKey;
    private String userName;
    private String password;
    private String email;
    private int phoneNr;
    private String address;
    private int postCode;
    private String city;
    private boolean teacher;
    
    
 public User (int userKey, String userName, String password, String email, int phoneNr, String address, int zipCode, String city, boolean teacher) {

     this.userKey = userKey;
     this.userName = userName;
     this.password = password;
     this.email = email;
     this.phoneNr = phoneNr;
     this.address = address;
     this.postCode = zipCode;
     this.city = city;
     this.teacher = teacher;
     
 }


    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostCode() {
        return postCode;
    }
    
    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
     
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }
 
}
