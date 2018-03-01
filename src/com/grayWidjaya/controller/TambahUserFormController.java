/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.controller;

import com.grayWidjaya.Entity.User;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Developer
 */
public class TambahUserFormController implements Initializable {

    @FXML
    private BorderPane borderTambahUserForm;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtRole;
    @FXML
    private Button btnTambahUser;
    @FXML
    private Button btnHapus;
    @FXML
    private PasswordField passPassword;
    @FXML
    private Button btnMenuUtama;
    @FXML
    private TableColumn<User, Integer> colId;
    @FXML
    private TableColumn<User, String> colNama;
    @FXML
    private TableColumn<User, String> colUsername;
    @FXML
    private TableColumn<User, String> colPassword;
    @FXML
    private TableColumn<User, String> colRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTambahUser(ActionEvent event) {
    }

    @FXML
    private void btnHapus(ActionEvent event) {
        txtNama.clear();
        txtRole.clear();
        txtUsername.clear();
        passPassword.clear();
    }

    @FXML
    private void btnMenuUtama(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/OwnerForm.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);

            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Form Owner");
            secondStage.show();
            borderTambahUserForm.getScene().getWindow().hide();

        } catch (IOException ex) {
            Logger.getLogger(LoginFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
