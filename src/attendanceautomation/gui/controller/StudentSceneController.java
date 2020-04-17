/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.User;
import attendanceautomation.gui.model.AttendanceModel;
import attendanceautomation.gui.model.UserModel;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class StudentSceneController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private HBox hBoxNavigationBar;
    @FXML
    private JFXButton btn_overview;
    @FXML
    private JFXButton btn_logout;
    @FXML
    private JFXButton btn_week;
    @FXML
    private TableColumn<?, ?> week;
    
    private User user;
    private UserModel userModel;
    private AttendanceModel attendanceModel;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handle_Overview(ActionEvent event) {
    }

    @FXML
    private void handle_Logout(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handle_Week(ActionEvent event) {
    }
    
}
