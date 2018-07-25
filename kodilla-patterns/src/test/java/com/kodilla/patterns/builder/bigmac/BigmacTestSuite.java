package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmackNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(RollType.STANDARD)
                .burgers(2)
                .sauce(SauceType.THOUSAND_ISLANDS)
                .ingredients(IngredientsType.CHEESE)
                .ingredients(IngredientsType.CHILI_PEPPERS)
                .ingredients(IngredientsType.LETTUCE)
                .build();
        //When
        int howManyBurgers = bigmac.getBurgers();
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(2, howManyBurgers);
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertTrue(bigmac.getIngredients().contains(IngredientsType.CHILI_PEPPERS));
        Assert.assertFalse(bigmac.getIngredients().contains(IngredientsType.BACON));
    }
}