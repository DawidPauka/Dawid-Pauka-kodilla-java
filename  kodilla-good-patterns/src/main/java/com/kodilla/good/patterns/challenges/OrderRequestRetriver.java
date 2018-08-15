package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriver {
    public OrderRequest retrieve() {
        User user = new User("John", "Smith");
        LocalDateTime orderDate = LocalDateTime.now();

        return  new OrderRequest(user, orderDate);
    }
}