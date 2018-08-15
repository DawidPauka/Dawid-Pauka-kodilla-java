package com.kodilla.good.patterns.challenges.food;

import java.util.Map;

public class OrderDto {
    private Map<Product, Integer> orderedProducts;

    public OrderDto(Map<Product, Integer> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public Map<Product, Integer> getOrderedProducts() {
        return orderedProducts;
    }
}