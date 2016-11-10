package com.github.chabanenk0.Product;

/**
 * Class describing the batch of similar products in the warehouse
 * Created by dchabanenko on 10.11.16.
 */
public class ProductsBatch
{
    /**
     * Numerical identifier of the current products batch
     */
    private long id;
    /**
     * Name of the product in the batch
     */
    private String name;

    /**
     * Price for one product item
     */
    private double itemPrice;

    /**
     * Numerical code for describing product's type
     */
    private long typeCode;

    /**
     * quantity of products in the batch
     */
    private long quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public long getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(long typeCode) {
        this.typeCode = typeCode;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
