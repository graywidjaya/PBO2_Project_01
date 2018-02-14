package com.grayWidjaya.dao;

import com.grayWidjaya.Entity.role;
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
 * @author G'ray Widjaya
 */
public class RoleDaolmpl implements DaoService<role>{
    
    @Override
    public int addData(role object){
        int result = 0;
        try{
            Connection connection =DBUtil.createMySQLConnection();
            String query = "INSERT INTO role (id, name) VALUES(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)){
                ps.setInt(1, object.getId());
                ps.setString(2, object.getName());
                if(ps.executeUpdate() != 0){
                    connection.commit();
                    result = 1;
                }
            }
        } catch (ClassNotFoundException | SQLException ex){
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
            
        }
        return result;
    }

    @Override
    public int deleteData(role object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(role object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<role> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
