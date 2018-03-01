/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.controller;

import com.grayWidjaya.Entity.Item;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Developer
 */
public class TambahBarangFormController implements Initializable {

    @FXML
    private BorderPane borderTambahBarangForm;
    @FXML
    private TextField txtIdBarang;
    @FXML
    private TextField txtNamaBarang;
    @FXML
    private TextField txtHargaBarang;
    @FXML
    private Button btnTambahBarang;
    @FXML
    private Button btnReset;
    @FXML
    private TextField txtJumlahBarang;
    @FXML
    private Button btnMenuUtama;
    @FXML
    private TableColumn<Item, Integer> colId;
    @FXML
    private TableColumn<Item, String> colNama;
    @FXML
    private TableColumn<Item, Integer> colHarga;
    @FXML
    private TableColumn<Item, Integer> colJumlahStock;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTambahBarang(ActionEvent event) {
    }

    @FXML
    private void btnReset(ActionEvent event) {
        txtHargaBarang.clear();
        txtIdBarang.clear();
        txtJumlahBarang.clear();
        txtNamaBarang.clear();
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
            borderTambahBarangForm.getScene().getWindow().hide();

        } catch (IOException ex) {
            Logger.getLogger(LoginFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
