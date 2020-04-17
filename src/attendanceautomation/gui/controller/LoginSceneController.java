/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.User;
import attendanceautomation.gui.model.UserModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class LoginSceneController implements Initializable {

    private Button btn_login;
    @FXML
    private JFXButton teacherscene;
    @FXML
    private JFXButton studentscene;
    
    private UserModel userModel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void handle_TeacherScene(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/TeacherLoginScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<TeacherSceneController>getController();

        Stage Stage = new Stage();
        Scene Scene = new Scene(root1);

        //songStage.initStyle(StageStyle.UNDECORATED);
        Stage.setScene(Scene);
        Stage.show();
    }
    
    @FXML
    private void handle_StudentScene(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/StudentLoginScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<TeacherSceneController>getController();

        Stage Stage = new Stage();
        Scene Scene = new Scene(root1);

        //songStage.initStyle(StageStyle.UNDECORATED);
        Stage.setScene(Scene);
        Stage.show();
    }
    
        public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
    
}
