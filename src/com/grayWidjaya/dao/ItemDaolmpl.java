/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grayWidjaya.dao;

import com.grayWidjaya.Entity.Item;
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
public class ItemDaolmpl implements DaoService<Item> {

    @Override
    public int addData(Item object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "INSERT INTO user (id, name, prices, stock) VALUES(?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setString(2, object.getName());
                ps.setInt(3, object.getPrices());
                ps.setString(4, object.getStock());
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
    public int deleteData(Item object) {
        int result = 0;
        try {

//        try{
            Connection connection = DBUtil.createMySQLConnection();
            String query = "Delete FROM item WHERE id = ? ";
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
    public int updateData(Item object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "UPDATE User SET name = ?, SET prices = ?, SET stock = ?, WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setString(2, object.getName());
                ps.setInt(3, object.getPrices());
                ps.setString(4, object.getStock());
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
    public List<Item> showAllData() {
        List<Item> items = new ArrayList<>();
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query = "SELECT * FROM Item ORDER BY id";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setPrices(rs.getInt("Prices"));
                    item.setStock(rs.getString("Stock"));
                    items.add(item);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }

        return items;
    }

}
