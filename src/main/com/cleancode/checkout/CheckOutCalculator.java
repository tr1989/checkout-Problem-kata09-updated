package com.cleancode.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckOutCalculator {

    private Map<String, Integer> priceList = new HashMap<String, Integer>();

    public CheckOutCalculator() {
        this.priceList.put("A", 10);
        this.priceList.put("B", 20);
    }

    public int calculatePrice(String item) {
        return priceList.getOrDefault(item, 0);
    }
}
