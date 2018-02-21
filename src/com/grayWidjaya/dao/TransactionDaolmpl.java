/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.dao;

import com.grayWidjaya.Entity.Transaction;
import com.grayWidjaya.utility.DBUtil;
import com.grayWidjaya.utility.DaoService;
import com.grayWidjaya.utility.ViewUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public class TransactionDaolmpl implements DaoService<Transaction> {

    @Override
    public int addData(Transaction object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "INSERT INTO Transaction (id, date, payment) VALUES(?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setInt(2, object.getPayment());
                //ps.setDate(2, date); cara buat date gmn
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());

        }
        return result;
    }

    @Override
    public int deleteData(Transaction object) {
        int result = 0;
        try {

//        try{
            Connection connection = DBUtil.createMySQLConnection();
            String query = "Delete FROM Transactio WHERE id = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getId());
            if (ps.executeUpdate() != 0) {
                connection.commit();
                result = 1;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoleDaolmpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateData(Transaction object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "UPDATE Transaction SET id = ?, SET Payment = ?, SET Date = ?, WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setInt(2, object.getPayment());
                //ps.setDate(2, date); cara buat date gmn
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Transaction> showAllData() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query = "SELECT * FROM Transaction ORDER BY id";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Transaction transaction = new Transaction();
                    transaction.setId(rs.getInt("id"));
                    transaction.setPayment(rs.getInt("Payment"));
                    //transaction.setDate(rs.getString("Date")); cara masukin date gmn

                    transactions.add(transaction);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }

        return transactions;
    }

}
