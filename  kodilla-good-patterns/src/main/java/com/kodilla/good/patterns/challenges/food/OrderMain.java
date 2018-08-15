package com.kodilla.good.patterns.challenges.food;

import java.util.HashMap;
import java.util.Map;

public class OrderMain {
    public static void main(String[] args) {
        Map<Product, Integer> productsInProducentsStock = new HashMap<>();
        productsInProducentsStock.put(new Product("bread"), 5);
        productsInProducentsStock.put(new Product("butter"), 10);
        productsInProducentsStock.put(new Product("tea"), 4);

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new ExtraFoodShop(productsInProducentsStock));
        orderProcessor.process(orderRequest);
    }
}