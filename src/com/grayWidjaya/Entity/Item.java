
package com.grayWidjaya.Entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author G'ray Widjaya
 */
public class Item {

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
    
    private final IntegerProperty prices = new SimpleIntegerProperty();

    public int getPrices() {
        return prices.get();
    }

    public void setPrices(int value) {
        prices.set(value);
    }

    public IntegerProperty pricesProperty() {
        return prices;
    }
    
    private final StringProperty stock = new SimpleStringProperty();

    public String getStock() {
        return stock.get();
    }

    public void setStock(String value) {
        stock.set(value);
    }

    public StringProperty stockProperty() {
        return stock;
    }
    
    private final StringProperty name = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
    
    
}
