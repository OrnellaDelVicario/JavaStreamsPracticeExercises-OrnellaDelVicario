package com.company.exercise2;

/*
📦 Exercise 2: Group Products by Category
Task:
Given a List<Product> with fields name, category, and price, group them by category.

✅ Concepts:
Collectors.groupingBy()
Collectors.mapping() (Optional Bonus)
 */

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupProductsByCategory {

    public static Map<String, List<Product>> groupByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Banana", "Grocery", 1.2),
                new Product("Apple", "Grocery", 1.5),
                new Product("Desk", "Furniture", 300.0)
        );

        Map<String, List<Product>> grouped = groupByCategory(products);
        grouped.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });
    }
}
