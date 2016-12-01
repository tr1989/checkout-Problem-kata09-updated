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

    @Test
    public void return_total_price_as_20_for_2_units_of_item_A () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("A","A");
        Assert.assertEquals(20, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_with_discount_as_25_for_3_units_of_item_A () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("A","A","A");
        Assert.assertEquals(25, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_with_discount_as_35_for_2_units_of_item_B () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("B","B");
        Assert.assertEquals(35, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_with_discount_as_45_for_5_units_of_item_A () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("A","A","A","A","A");
        Assert.assertEquals(45, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_with_discount_as_90_for_5_units_of_item_B () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        List<String> itemsList = Arrays.asList("B","B","B","B","B");
        Assert.assertEquals(90, checkOutCalculator.calculatePrice(itemsList));
    }

    @Test
    public void return_total_price_as_10_for_after_adding_individual_item_A_to_cart () {
        CheckOutCalculator checkOutCalculator =  new CheckOutCalculator();
        checkOutCalculator.scan("A");
        Assert.assertEquals(10, checkOutCalculator.getTotalPriceForAllItems());
    }

}
