/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.dao;

import com.grayWidjaya.Entity.TransactionDetail;
import com.grayWidjaya.utility.DBUtil;
import com.grayWidjaya.utility.DaoService;
import com.grayWidjaya.utility.ViewUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public class TransactionDetaillmpl implements DaoService<TransactionDetail> {

    @Override
    public int addData(TransactionDetail object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "INSERT INTO user (quantuty, selling price, item, transaction) VALUES(?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getQuantity());
                ps.setInt(2, object.getSellingPrice());
                ps.setInt(3, object.getItem().getId());
                ps.setInt(4, object.getTransaction().getId());
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
    public int deleteData(TransactionDetail object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(TransactionDetail object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TransactionDetail> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
