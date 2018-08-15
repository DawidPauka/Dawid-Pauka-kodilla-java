package com.kodilla.good.patterns.challenges.food;

import java.util.Map;
import java.util.function.Consumer;

public class ExtraFoodShop implements ProducerService {
    private Map<Product, Integer> productsInStock;

    public ExtraFoodShop(Map<Product, Integer> productsInStock) {
        this.productsInStock = productsInStock;
    }

    @Override
    public void process(Map<Product, Integer> productsToOrder) {
        productsToOrder.entrySet().stream()
                .peek(validateProductExistence)
                .peek(validateProductQuantity)
                .forEach(order);
    }

    private Consumer<Map.Entry<Product, Integer>> order = entry -> {
        productsInStock.computeIfPresent(entry.getKey(), (k,v) -> v - entry.getValue());
    };

    private Consumer<Map.Entry<Product, Integer>> validateProductQuantity = entry -> {
        Product product = entry.getKey();
        int quantityToOrder = entry.getValue();

        if(productsInStock.get(product) < quantityToOrder) {
            throw new ProductNotEnoughUnitsException(entry.getKey(), quantityToOrder, productsInStock.get(product));
        }
    };

    private Consumer<Map.Entry<Product, Integer>> validateProductExistence = entry -> {
        Product product = entry.getKey();

        if(notContains(product)) {
            throw new ProductNotExistsException(product);
        }
    };

    private boolean notContains(Product product) {
        return !productsInStock.containsKey(product);
    }

    public Map<Product, Integer> getProductsInStock() {
        return productsInStock;
    }
}