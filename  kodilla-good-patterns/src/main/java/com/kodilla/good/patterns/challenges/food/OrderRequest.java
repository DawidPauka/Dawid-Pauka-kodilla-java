package com.kodilla.good.patterns.challenges.food;

import java.util.Map;

public class OrderRequest {
    private Map<Product, Integer> productsToOrder;

    public OrderRequest(Map<Product, Integer> productsToOrder) {
        this.productsToOrder = productsToOrder;
    }

    public Map<Product, Integer> getProductsToOrder() {
        return productsToOrder;
    }
}