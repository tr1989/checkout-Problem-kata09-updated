package com.cleancode.checkout;

public class Item {

    private String itemCode;
    private int itemPrice;
    private int itemQuantity;

    public Item(String itemCode, int itemPrice) {
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
        this.itemQuantity = 0;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

}
