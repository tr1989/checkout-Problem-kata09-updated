package com.cleancode.checkout;

import org.junit.Assert;
import org.junit.Test;

public class CheckoutCalculatorShould {
    @Test
    public void return_total_price_as_10_for_one_unit_of_item_A() {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        Assert.assertEquals(10, checkOutCalculator.calculatePrice("A"));
    }
}
