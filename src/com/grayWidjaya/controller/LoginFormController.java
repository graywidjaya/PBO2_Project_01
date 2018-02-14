/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.controller;

import com.grayWidjaya.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane anchorLogin;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField passPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLogin(ActionEvent event) {
        if (txtUsername.getText().equals("owner") && passPassword.
                getText().equals("12345")) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/OwnerForm.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);

                Stage secondStage = new Stage();
                secondStage.setScene(scene);
                secondStage.setTitle("Owner Form");
                secondStage.show();
                anchorLogin.getScene().getWindow().hide();

            } catch (IOException ex) {
                Logger.getLogger(LoginFormController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } else if (txtUsername.getText().equals("kasir") && passPassword.
                getText().equals("1572044")) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/KasirForm.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);

                Stage secondStage = new Stage();
                secondStage.setScene(scene);
                secondStage.setTitle("Kasir Form");
                secondStage.show();
                anchorLogin.getScene().getWindow().hide();

            } catch (IOException ex) {
                Logger.getLogger(LoginFormController.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Username and Password");
            alert.showAndWait();

        }
        passPassword.clear();
        txtUsername.clear();
    }
}
