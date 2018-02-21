
package com.grayWidjaya.Entity;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author G'ray widjaya
 */
public class Transaction {

//    private int id;
//    private Date date;
//    private int payment;
    
    private final IntegerProperty id = new SimpleIntegerProperty();

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    
    private final IntegerProperty payment = new SimpleIntegerProperty();

    public int getPayment() {
        return payment.get();
    }

    public void setPayment(int value) {
        payment.set(value);
    }

    public IntegerProperty paymentProperty() {
        return payment;
    }

    
    
    
    
}
