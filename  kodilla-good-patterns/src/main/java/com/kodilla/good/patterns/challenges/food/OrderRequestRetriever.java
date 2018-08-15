package com.kodilla.good.patterns.challenges.food;

import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        Map<Product, Integer> productsToOrder = new HashMap<>();
        productsToOrder.put(new Product("milk"), 5);
        productsToOrder.put(new Product("coffee"), 3);

        return new OrderRequest(productsToOrder);
    }
}