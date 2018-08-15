package com.kodilla.good.patterns.challenges.food;

import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        Map<Product, Integer> productsToOrder = new HashMap<>();
        productsToOrder.put(new Product("bread"), 5);
        productsToOrder.put(new Product("butter"), 10);

        return new OrderRequest(productsToOrder);
    }
}