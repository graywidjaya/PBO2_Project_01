package com.grayWidjaya.dao;

import com.grayWidjaya.Entity.Role;
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
 * @author G'ray Widjaya
 */
public class RoleDaolmpl implements DaoService<Role> {

    @Override
    public int addData(Role object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query = "INSERT INTO role (id, name) VALUES(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setString(2, object.getName());
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
    public int deleteData(Role object) {
        int result = 0;
        try {

//        try{
            Connection connection = DBUtil.createMySQLConnection();
            String query = "Delete FROM role WHERE id = ? ";
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
    public int updateData(Role object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query = "UPDATE role SET name = ? WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getName());
                ps.setInt(2, object.getId());
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
    public List<Role> showAllData() {
        List<Role> roles = new ArrayList<>();
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query = "SELECT * FROM role ORDER BY id";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Role role = new Role();
                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("name"));
                    roles.add(role);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }

        return roles;
    }

}
