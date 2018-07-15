package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsManagerTestSuite {

    @Test
    public void testPostsCountZero() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 1;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 1;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList< >();
        users.add("Maciek");
        users.add("Magda");
        users.add("Michał");
        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int result = statisticsManager.getPostsQuantity();

        //Then//
        Assert.assertEquals(1,result);
    }

    @Test
    public void testPostsCountThousand() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 1000;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 2000;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList<String>();
        users.add("Maciek");
        users.add("Magda");
        users.add("Michał");
        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int result = statisticsManager.getPostsQuantity();

        //Then//
        Assert.assertEquals(1000,result);
    }

    @Test
    public void testCommentsCountZero() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 1;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 1;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList< >();
        users.add("Maciek");
        users.add("Magda");
        users.add("Michał");
        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int result = statisticsManager.getCommentsQuantity();

        //Then//
        Assert.assertEquals(1,result);
    }

    @Test
    public void testCommentsFewerThanPosts() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 50;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 10;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList< >();
        users.add("Maciek");
        users.add("Magda");
        users.add("Michał");
        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int posts = statisticsManager.getPostsQuantity();
        int comments = statisticsManager.getCommentsQuantity();
        boolean commentsFewerThanPosts = comments < posts;

        //Then//
        Assert.assertTrue(commentsFewerThanPosts);
    }

    @Test
    public void testCommentsGreaterThanPosts() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 50;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 100;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList< >();
        users.add("Maciek");
        users.add("Magda");
        users.add("Michał");
        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int posts = statisticsManager.getPostsQuantity();
        int comments = statisticsManager.getCommentsQuantity();
        boolean commentsGreaterThanPosts = comments > posts;

        //Then//
        Assert.assertTrue(commentsGreaterThanPosts);
    }

    @Test
    public void testUsersCountZero() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 1;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 1;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList< >();
        users.add("Maciek");

        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int result = statisticsManager.getUserQuantity();

        //Then//
        Assert.assertEquals(1,result);
    }

    @Test
    public void testUsersCountHundred() {
        //Given//
        Statistics statisticsMock = mock(Statistics.class);

        int postsQuantity = 1;
        when(statisticsMock.postsCount()).thenReturn(postsQuantity);

        int commentsQuantity = 1;
        when(statisticsMock.commentsCount()).thenReturn(commentsQuantity);

        ArrayList<String> users = new ArrayList< >();

        for (int i = 0; i <100 ; i++) {
            users.add("Maciek");
        }

        when(statisticsMock.usersNames()).thenReturn(users);

        StatisticsManager statisticsManager = new StatisticsManager();

        //When//
        statisticsManager.calculateAdvStatistics(statisticsMock);

        int result = statisticsManager.getUserQuantity();

        //Then//
        Assert.assertEquals(100,result);
    }
}