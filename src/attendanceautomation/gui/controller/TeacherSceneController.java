/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class TeacherSceneController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private HBox hBoxNavigationBar;
    @FXML
    private JFXButton btn_controlpanel;
    @FXML
    private JFXButton btn_logout;
    @FXML
    private Label lblTeacherName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_ControlPanel(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/TeacherOverviewScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<TeacherSceneController>getController();

        Stage Stage = new Stage();
        Scene Scene = new Scene(root1);

        //songStage.initStyle(StageStyle.UNDECORATED);
        Stage.setScene(Scene);
        Stage.show();
    }

    @FXML
    private void handle_Logout(ActionEvent event) {
            Platform.exit();
    }

}