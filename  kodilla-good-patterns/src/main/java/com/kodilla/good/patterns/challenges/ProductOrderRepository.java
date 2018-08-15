package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository {
    private static int id=0;

    public ProductOrderRepository() {
        id++;
    }

    @Override
    public int createOrder(User user, LocalDateTime orderDate) {
        System.out.println("Data inserted to DB.");
        return id;
    }
}