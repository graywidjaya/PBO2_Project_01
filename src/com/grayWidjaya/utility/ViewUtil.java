package com.grayWidjaya.utility;

import javafx.scene.control.Alert;

/**
 *
 * @author G'ray Widjaya
 */
public class ViewUtil {
    public static Alert alert;
    
    static{
        alert = new Alert(Alert.AlertType.NONE);
    }
    
    public static void showAlert(Alert.AlertType type, String content){
        showAlert(type,null,content);
    }
    
    public static void showAlert(Alert.AlertType type, String title, String content){
        alert.setAlertType(type);
        alert.setContentText(content);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
