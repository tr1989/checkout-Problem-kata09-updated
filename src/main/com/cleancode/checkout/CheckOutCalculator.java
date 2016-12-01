package com.cleancode.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOutCalculator {

    private Map<String, Integer> priceList = new HashMap<String, Integer>();

    public CheckOutCalculator() {
        this.priceList.put("A", 10);
        this.priceList.put("B", 20);
    }

    public int calculatePrice(List<String> itemsList) {
        int sum = 0;
        int quantityForDiscountForItemA = 3;
        int priceAfterDiscountForItemA = 25;
        Map<String, Integer> quantityCounterMap = new HashMap<String,Integer>();
        for (String item: itemsList) {
            if(quantityCounterMap.containsKey(item)) {
                quantityCounterMap.put(item, quantityCounterMap.get(item)+1);
            } else {
                quantityCounterMap.put(item,1);
            }
        }
        for (Map.Entry<String, Integer> entry : quantityCounterMap.entrySet()) {
            if ("A".equals(entry.getKey()) && quantityForDiscountForItemA == entry.getValue()) {
                sum += priceAfterDiscountForItemA;
            } else {
                sum += priceList.getOrDefault(entry.getKey(), 0) * entry.getValue();
            }
        }
        return sum;
    }
}
