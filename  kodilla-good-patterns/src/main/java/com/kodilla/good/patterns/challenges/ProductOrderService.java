package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(User user, LocalDateTime orderDate) {
        System.out.println("Product ordered by: " + user.getName() + user.getSurname()
                + " in: " + orderDate.toString());
        return true;
    }
}