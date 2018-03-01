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
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OwnerFormController implements Initializable {

    @FXML
    private BorderPane borderOwner;
    @FXML
    private Button btnAddBarang;
    @FXML
    private Button btnAddUser;
    @FXML
    private Button btnSalesReport;
    @FXML
    private Button btnHighestSalesReport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAddBarang(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/TambahBarangForm.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);

            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Form Tambah Barang");
            secondStage.show();
            borderOwner.getScene().getWindow().hide();

        } catch (IOException ex) {
            Logger.getLogger(LoginFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAddUser(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/TambahUserForm.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);

            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Form Tambah User");
            secondStage.show();
            borderOwner.getScene().getWindow().hide();

        } catch (IOException ex) {
            Logger.getLogger(LoginFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSalesReport(ActionEvent event) {
    }

    @FXML
    private void btnHighestSalesReport(ActionEvent event) {
    }

}
