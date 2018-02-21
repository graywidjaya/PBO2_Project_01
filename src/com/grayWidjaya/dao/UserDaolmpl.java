package com.grayWidjaya.dao;

import com.grayWidjaya.Entity.Role;
import com.grayWidjaya.Entity.User;
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
public class UserDaolmpl implements DaoService<User> {

    @Override
    public int addData(User object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "INSERT INTO user (id, name, username, password, role) VALUES(?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setString(2, object.getName());
                ps.setString(3, object.getUsername());
                ps.setString(4, object.getPassword());
                ps.setInt(5, object.getRole().getId());
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
    public int deleteData(User object) {
        int result = 0;
        try {

//        try{
            Connection connection = DBUtil.createMySQLConnection();
            String query = "Delete FROM user WHERE id = ? ";
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
    public int updateData(User object) {
        int result = 0;
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query
                    = "UPDATE User SET name = ?, SET username = ?, SET password = ?, SET role = ?, WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, object.getId());
                ps.setString(2, object.getName());
                ps.setString(3, object.getUsername());
                ps.setString(4, object.getPassword());
                ps.setInt(5, object.getRole().getId());
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
    public List<User> showAllData() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DBUtil.createMySQLConnection();
            String query = "SELECT * FROM User ORDER BY id";
            try (PreparedStatement ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getString("Password"));
                    user.setRole((Role) rs.getObject("role"));
                    users.add(user);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }

        return users;
    }
}
