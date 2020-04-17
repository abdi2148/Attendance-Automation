/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.User;
import attendanceautomation.gui.model.UserModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class TeacherLoginSceneController implements Initializable {

    @FXML
    private JFXButton login;
    @FXML
    private JFXCheckBox cb_rememberteacher;
    
    private User user;
    private UserModel userModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_RememberTeacher(ActionEvent event) {
    }

    @FXML
    private void handle_LoginTeacher(ActionEvent event) throws IOException {
        
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/TeacherScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<TeacherSceneController>getController();

        Stage Stage = new Stage();
        Scene Scene = new Scene(root1);

        //songStage.initStyle(StageStyle.UNDECORATED);
        Stage.setScene(Scene);
        Stage.show();
    }
}
