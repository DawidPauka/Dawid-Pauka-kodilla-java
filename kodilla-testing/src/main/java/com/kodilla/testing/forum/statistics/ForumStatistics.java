package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersQuantity = 0;
    private int postsQuantity = 0;
    private int commentsQuantity = 0;
    private Double postsPerUser = null;
    private Double commentsPerUser = null;
    private Double commentsPerPost = null;

    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();

        if (usersQuantity > 0) {
            postsPerUser = (double) postsQuantity / usersQuantity;
            commentsPerUser = (double) commentsQuantity / usersQuantity;
        }

        if (postsQuantity > 0) {
            commentsPerPost = (double) commentsQuantity / postsQuantity;
        }
    }



    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public Double getPostsPerUser() {
        return postsPerUser;
    }

    public Double getCommentsPerUser() {
        return commentsPerUser;
    }

    public Double getCommentsPerPost() {
        return commentsPerPost;
    }
}