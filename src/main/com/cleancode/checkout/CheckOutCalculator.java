package com.cleancode.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOutCalculator {

    private Map<String, Item> priceList = new HashMap<>();

    public CheckOutCalculator() {
        this.priceList.put("A", new Item("A", 10));
        this.priceList.put("B", new Item("B", 20));
    }

    public int calculatePrice(List<String> itemsList) {
        int sum = 0;
        int quantityForDiscountForItemA = 3;
        int priceAfterDiscountForItemA = 25;
        int quantityForDiscountForItemB = 2;
        int priceAfterDiscountForItemB = 35;

        Item defaultItem = new Item("default",0);

        Map<String, Integer> quantityCounterMap = new HashMap<String,Integer>();
        for (String item: itemsList) {
            Item currentItem = priceList.getOrDefault(item, defaultItem);
            currentItem.setItemQuantity(currentItem.getItemQuantity()+1);
        }
        for (Map.Entry<String, Item> entry : priceList.entrySet()) {
            if ("A".equals(entry.getKey()) && quantityForDiscountForItemA == entry.getValue().getItemQuantity()) {
                sum += priceAfterDiscountForItemA;
            } else if("B".equals(entry.getKey()) && quantityForDiscountForItemB == entry.getValue().getItemQuantity()) {
                sum += priceAfterDiscountForItemB;
            } else {
                sum += priceList.getOrDefault(entry.getKey(), defaultItem).getItemPrice() * entry.getValue().getItemQuantity();
            }
        }
        return sum;
    }
}
