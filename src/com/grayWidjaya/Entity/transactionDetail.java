
package com.grayWidjaya.Entity;

/**
 *
 * @author G'ray Widjaya
 */
public class transactionDetail {
    private int quantity;
    private int sellingPrice;
    private item item;
    private transaction transaction;

    public transactionDetail(int quantity, int sellingPrice, item item, transaction transaction) {
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.item = item;
        this.transaction = transaction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public item getItem() {
        return item;
    }

    public void setItem(item item) {
        this.item = item;
    }

    public transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(transaction transaction) {
        this.transaction = transaction;
    }
    
    
}
