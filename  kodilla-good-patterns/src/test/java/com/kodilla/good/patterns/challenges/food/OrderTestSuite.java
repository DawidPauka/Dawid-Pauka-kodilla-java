package com.kodilla.good.patterns.challenges.food;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

import java.util.HashMap;
import java.util.Map;

public class OrderTestSuite {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TestName name = new TestName();

    @Before
    public void before() {
        System.out.println("Currently we're testing: " + name.getMethodName() + " method");
    }

    @After
    public void after() {
        System.out.println("Test has finished");
    }

    @Test
    public void testOrderProductExistenceInStock() {
        //Given
        //Ordered: milk:5; coffee:3
        Map<Product, Integer> productsInProducentsStock = new HashMap<>();
        productsInProducentsStock.put(new Product("milk"), 10);
        productsInProducentsStock.put(new Product("cola"), 5);
        productsInProducentsStock.put(new Product("coffee"), 3);

        //When
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop(productsInProducentsStock);
        OrderProcessor orderProcessor = new OrderProcessor(extraFoodShop);
        orderProcessor.process(orderRequest);

        int milkInStockQuantity = extraFoodShop.getProductsInStock()
                .get(new Product("milk"));
        int coffeeInStockQuantity = extraFoodShop.getProductsInStock()
                .get(new Product("coffee"));

        //Then
        Assert.assertEquals(5, milkInStockQuantity);
        Assert.assertEquals(0, coffeeInStockQuantity);
    }

    @Test
    public void testOrderProductNotExistenceInStock() {
        //Then
        expectedException.expect(ProductNotExistsException.class);
        expectedException.expectMessage("coffee not exists");

        //Given
        //Ordered: milk:5; coffee:3
        Map<Product, Integer> productsInProducentsStock = new HashMap<>();
        productsInProducentsStock.put(new Product("milk"), 10);
        productsInProducentsStock.put(new Product("cola"), 5);

        //When
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop(productsInProducentsStock);
        OrderProcessor orderProcessor = new OrderProcessor(extraFoodShop);
        orderProcessor.process(orderRequest);
    }

    @Test
    public void testOrderProductQuantityMoreThanInStock() {
        //Then
        expectedException.expect(ProductNotEnoughUnitsException.class);
        expectedException.expectMessage("coffee not enough units. Required 3. Available 1");

        //Given
        //Ordered: milk:5; coffee:3
        Map<Product, Integer> productsInProducentsStock = new HashMap<>();
        productsInProducentsStock.put(new Product("milk"), 10);
        productsInProducentsStock.put(new Product("cola"), 5);
        productsInProducentsStock.put(new Product("coffee"), 1);

        //When
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop(productsInProducentsStock);
        OrderProcessor orderProcessor = new OrderProcessor(extraFoodShop);
        orderProcessor.process(orderRequest);
    }
}