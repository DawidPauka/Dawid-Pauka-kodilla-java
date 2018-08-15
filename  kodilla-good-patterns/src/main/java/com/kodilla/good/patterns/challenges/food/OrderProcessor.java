package com.kodilla.good.patterns.challenges.food;


public class OrderProcessor {
    private ProducerService producerService;

    public OrderProcessor(ProducerService producerService) {
        this.producerService = producerService;
    }

    public OrderDto process(OrderRequest orderRequest) {
        System.out.println("Start processing order");

        producerService.process(orderRequest.getProductsToOrder());

        System.out.println("Successfully finish processing order");
        return new OrderDto(orderRequest.getProductsToOrder());
    }
}