/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class KasirFormController implements Initializable {

    @FXML
    private Button btnTambahBarang;
    @FXML
    private Button btnReset;
    @FXML
    private TextField txtNamaBarang;
    @FXML
    private TableColumn<?, ?> colIdBarang;
    @FXML
    private TableColumn<?, ?> colNamaBarang;
    @FXML
    private TableColumn<?, ?> colHargaBarang;
    @FXML
    private BorderPane borderKasirForm;
    @FXML
    private TextField txtJumlahBarang;
    @FXML
    private Button btnCetakKuitansi;
    @FXML
    private TextField txtTotalHarga;

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
    }

    @FXML
    private void btnCetakKuitansi(ActionEvent event) {
    }

}
