package com.kodilla.good.patterns.challenges.food;

public class ProductNotEnoughUnitsException extends RuntimeException {
    public ProductNotEnoughUnitsException(Product product, int required, int available) {
        super(product.getName() + " not enough units. Required " + required + ". Available " + available);
    }
}