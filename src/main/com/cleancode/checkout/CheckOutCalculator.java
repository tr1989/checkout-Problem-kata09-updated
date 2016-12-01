package com.cleancode.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOutCalculator {

    private Map<String, Item> priceList = new HashMap<>();
    private Map<String, DiscountPricingRule> discountPricingRuleMap = new HashMap<>();

    Item defaultItem = new Item("default",0);
    DiscountPricingRule defaultRule = new DiscountPricingRule("default", 0,0);

    public CheckOutCalculator() {
        this.priceList.put("A", new Item("A", 10));
        this.priceList.put("B", new Item("B", 20));

        this.discountPricingRuleMap.put("A", new DiscountPricingRule("A", 3, 25));
        this.discountPricingRuleMap.put("B", new DiscountPricingRule("B", 2, 35));

    }

    public int calculatePrice(List<String> itemsList) {

        scanItemFromList(itemsList);

        return getTotalPriceForAllItems();
    }

    private int getTotalPriceForAllItems() {
        int sum = 0;
        for (Map.Entry<String, Item> entry : priceList.entrySet()) {
            DiscountPricingRule currentRule = discountPricingRuleMap.getOrDefault(entry.getKey(), defaultRule);

                int quantityInCart = entry.getValue().getItemQuantity();
                int itemActualPrice = entry.getValue().getItemPrice();

                int itemQuantityForDiscount = currentRule.getItemQuantityForDiscount();
                int discountedPrice = currentRule.getDiscountedPrice();

                if(quantityInCart >= itemQuantityForDiscount){
                    int discountedSetOfItems = quantityInCart / itemQuantityForDiscount;
                    int remainingQuantity = quantityInCart % itemQuantityForDiscount;
                    sum += discountedPrice * discountedSetOfItems;
                    sum += itemActualPrice * remainingQuantity;
                } else {
                    sum += itemActualPrice * quantityInCart;
                }
        }
        return sum;
    }

    private void scanItemFromList(List<String> itemsList) {
        for (String item: itemsList) {
            Item currentItem = priceList.getOrDefault(item, defaultItem);
            currentItem.setItemQuantity(currentItem.getItemQuantity()+1);
        }
    }
}
