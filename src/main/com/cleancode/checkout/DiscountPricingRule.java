package com.cleancode.checkout;

public class DiscountPricingRule{
    private String itemCode;
    private int itemQuantityForDiscount;
    private int discountedPrice;

    public DiscountPricingRule(String itemCode, int itemQuantityForDiscount, int discountedPrice) {
        this.itemCode = itemCode;
        this.itemQuantityForDiscount = itemQuantityForDiscount;
        this.discountedPrice = discountedPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getItemQuantityForDiscount() {
        return itemQuantityForDiscount;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

}