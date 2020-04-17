/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class UserModelTest {
    
    public UserModelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of CheckUser method, of class UserModel.
     */
    @Test
    public void testCheckUser() {
        System.out.println("CheckUser");
        String email = "easv@gmail.com";
        String password = "password";
        UserModel instance = new UserModel();
        int expResult = 0;
        int result = instance.CheckUser(email, password);
        assertEquals(expResult, result);
    }
    
}
