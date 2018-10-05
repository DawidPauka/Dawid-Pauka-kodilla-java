package com.kodilla.good.patterns.challenges;



        import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime orderDate;

    public OrderRequest(User user, LocalDateTime orderDate) {
        this.user = user;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }


    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}