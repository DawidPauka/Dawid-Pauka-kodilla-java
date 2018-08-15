package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {
    int createOrder(User user, LocalDateTime orderDate);
}