
package com.grayWidjaya.Entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;


/**
 *
 * @author G'ray Widjaya
 */
public class TransactionDetail {
    
//    private int quantity;
//    private int sellingPrice;
//    private Item item;
//    private Transaction transaction;

    private final IntegerProperty quantity = new SimpleIntegerProperty();

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int value) {
        quantity.set(value);
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }
    
    private final ObjectProperty<Item> item = new SimpleObjectProperty<>();

    public Item getItem() {
        return item.get();
    }

    public void setItem(Item value) {
        item.set(value);
    }

    public ObjectProperty itemProperty() {
        return item;
    }
    
    private final ObjectProperty<Transaction> transaction = new SimpleObjectProperty<>();

    public Transaction getTransaction() {
        return transaction.get();
    }

    public void setTransaction(Transaction value) {
        transaction.set(value);
    }

    public ObjectProperty transactionProperty() {
        return transaction;
    }

    private final IntegerProperty sellingPrice = new SimpleIntegerProperty();

    public int getSellingPrice() {
        return sellingPrice.get();
    }

    public void setSellingPrice(int value) {
        sellingPrice.set(value);
    }

    public IntegerProperty sellingPriceProperty() {
        return sellingPrice;
    }
    
    
}
