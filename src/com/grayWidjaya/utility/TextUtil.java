package com.grayWidjaya.utility;

import javafx.scene.control.TextInputControl;

/**
 *
 * @author G'ray Widjaya
 */
public class TextUtil {
    
    public static boolean isEmptyField(TextInputControl... textFields){
        for (TextInputControl tic : textFields){
            if(tic.getText().trim().isEmpty()){
                return true;
            }
        }
        return false;
    }
}
