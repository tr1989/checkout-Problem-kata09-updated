package com.cleancode.checkout;

public class CheckOutCalculator {
    public int calculatePrice(String item) {
        if("A".equals(item)){
            return 10;
        }
        return 0;
    }
}
