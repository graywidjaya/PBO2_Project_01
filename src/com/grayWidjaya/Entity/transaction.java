
package com.grayWidjaya.Entity;

import java.util.Date;

/**
 *
 * @author G'ray widjaya
 */
public class transaction {
    private int id;
    private Date date;
    private int payment;
    private transaction transaction;

    public transaction(int id, Date date, int payment) {
        this.id = id;
        this.date = date;
        this.payment = payment;
        this.transaction = transaction;
    }

    public transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(transaction transaction) {
        this.transaction = transaction;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
    
    
}
