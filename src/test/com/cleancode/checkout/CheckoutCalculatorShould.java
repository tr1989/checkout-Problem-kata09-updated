package com.cleancode.checkout;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CheckoutCalculatorShould {
    @Test
    public void return_total_price_as_10_for_one_unit_of_item_A() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("A");
        Assert.assertEquals(10, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_as_20_for_one_unit_of_item_B() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("B");
        Assert.assertEquals(20, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_as_30_for_each_unit_of_item_A_and_item_B () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("A","B");
        Assert.assertEquals(30, checkOutCalculator.calculatePrice(itemsList));
    }
}
