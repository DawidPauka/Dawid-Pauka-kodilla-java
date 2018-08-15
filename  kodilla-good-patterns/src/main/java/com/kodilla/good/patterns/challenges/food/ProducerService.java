package com.kodilla.good.patterns.challenges.food;

import java.util.Map;

public interface ProducerService {
    void process(Map<Product, Integer> productsToOrder);

}