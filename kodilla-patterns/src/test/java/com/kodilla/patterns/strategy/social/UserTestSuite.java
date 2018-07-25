package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {

        //Given
        User millenials = new Millenials("Nancy");
        User yGeneration = new YGeneration("George");
        User zGeneration = new ZGeneration("Zack");

        //When
        String snapchat = millenials.sharePost();
        String twitter = yGeneration.sharePost();
        String facebook = zGeneration.sharePost();

        //Then
        Assert.assertEquals("Snapchat", snapchat);
        Assert.assertEquals("Twitter", twitter);
        Assert.assertEquals("Facebook", facebook);
    }

    @Test
    public void testIndividualSharingStrategy() {

        //Given
        User millenials = new Millenials("Nancy");
        millenials.setSocialPublisher(new FacebookPublisher());

        //When
        String facebook = millenials.sharePost();

        //Then
        Assert.assertEquals("Facebook", facebook);
    }
}