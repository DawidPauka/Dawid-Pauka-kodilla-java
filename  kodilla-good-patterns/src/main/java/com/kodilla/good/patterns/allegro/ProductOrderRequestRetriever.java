package com.kodilla.good.patterns.allegro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductOrderRequestRetriever {

    public ProductOrderRequest retrieve() {
        User user = new User("David", "Tom", "Pauka");
        LocalDateTime orderDate = LocalDateTime.of(2017, 5, 20, 21, 25);
        Product product = new Bicycle( "WIGRY",
                "super rower",
                new BigDecimal("3000"));
        int quantity = 2;

        System.out.println("Retrieve product request:");
        System.out.println("User: " + user.getUserName() +
                " Date: " + orderDate + " \n " +
                product + ", quantity = " + quantity);
        return new ProductOrderRequest(user, orderDate, product, quantity);
    }
}