package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;
    private List<String> users;

    @Before
    public void before() {
        //given
        statisticsMock = mock(Statistics.class);
        users = new ArrayList<>();
        users.add("batman");
        users.add("robin hood");
        users.add("superman");
        users.add("spiderman");
        forumStatistics = new ForumStatistics();
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(25);
    }

    @Test
    public void testCalculateAdvStatistics() {
        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(4, forumStatistics.getUsersQuantity());
        Assert.assertEquals(10, forumStatistics.getPostsQuantity());
        Assert.assertEquals(25, forumStatistics.getCommentsQuantity());
        Assert.assertEquals(2.5, forumStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(6.25, forumStatistics.getCommentsPerUser(), 0);
        Assert.assertEquals(2.5, forumStatistics.getCommentsPerPost(), 0);
    }

    @Test //gdy liczba postów = 0
    public void testCalculateWhen0Posts() {
        //given
        when(statisticsMock.postsCount()).thenReturn(0);

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertNull(forumStatistics.getCommentsPerPost());
        Assert.assertEquals(new Double(0), forumStatistics.getPostsPerUser());
        Assert.assertEquals(0, forumStatistics.getPostsQuantity());
    }

    @Test //gdy liczba postów = 1000
    public void testCalculateWhen1000Posts() {
        //given
        when(statisticsMock.postsCount()).thenReturn(1000);

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(new Double(0.025), forumStatistics.getCommentsPerPost());
        Assert.assertEquals(250.0, forumStatistics.getPostsPerUser(), 0);
        Assert.assertEquals(1000, forumStatistics.getPostsQuantity());
    }

    @Test //gdy liczba komentarzy = 0
    public void testCalculateWhen0Comments() {
        //given
        when(statisticsMock.commentsCount()).thenReturn(0);

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0.0, forumStatistics.getCommentsPerUser(), 0.0);
        Assert.assertEquals(0.0, forumStatistics.getCommentsPerPost(), 0.0);
        Assert.assertEquals(0, forumStatistics.getCommentsQuantity());
    }

    @Test //gdy liczba komentarzy < liczba postów
    public void testCalculateWhenCommentsLessThanPosts() {
        //given
        when(statisticsMock.commentsCount()).thenReturn(1);
        when(statisticsMock.postsCount()).thenReturn(2);

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0.5, forumStatistics.getCommentsPerPost(), 0.0);
    }

    @Test //gdy liczba komentarzy < liczba postów
    public void testCalculateWhenCommentsMoreThanPosts() {
        //given
        when(statisticsMock.commentsCount()).thenReturn(2);
        when(statisticsMock.postsCount()).thenReturn(1);

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(2.0, forumStatistics.getCommentsPerPost(), 0.0);
    }

    @Test //gdy liczba userów = 0
    public void testCalculateWhen0Users() {
        //given
        users.clear();

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, forumStatistics.getUsersQuantity());
        Assert.assertNull(forumStatistics.getPostsPerUser());
        Assert.assertNull(forumStatistics.getCommentsPerUser());
    }

    @Test //gdy liczba userów = 100
    public void testCalculateWhen100Users() {
        //given
        for (int i = 1; users.size() < 100; i++) {
            users.add("username" + i++);
        }

        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, forumStatistics.getUsersQuantity());
    }

}