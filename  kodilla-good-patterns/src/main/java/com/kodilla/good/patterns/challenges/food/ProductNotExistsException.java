package com.kodilla.good.patterns.challenges.food;

public class ProductNotExistsException extends RuntimeException {
    public ProductNotExistsException(Product product) {
        super(product.getName() + " not exists");
    }
}