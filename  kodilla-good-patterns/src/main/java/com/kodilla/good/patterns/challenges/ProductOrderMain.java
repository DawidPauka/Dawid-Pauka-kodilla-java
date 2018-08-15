package com.kodilla.good.patterns.challenges;



public class ProductOrderMain {
    public static void main(String[] args) {
        //set variables' values
        OrderRequestRetriver orderRequestRetriver = new OrderRequestRetriver();
        //get variables with values
        OrderRequest orderRequest = orderRequestRetriver.retrieve();
        //order process
        OrderProcessor orderProcessor = new OrderProcessor(
                new MailService(), new ProductOrderService(), new ProductOrderRepository());
        orderProcessor.process(orderRequest);
    }
}