package com.company.exercise8;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Item> items = List.of(
                new Item("Apple", 1.2),
                new Item("Milk", 2.5),
                new Item("Bread", 1.8)
        );

        ShoppingSummary summary = items.stream()
                .collect(ShoppingSummaryCollector.toShoppingSummary());

        System.out.println(summary);
    }
}
