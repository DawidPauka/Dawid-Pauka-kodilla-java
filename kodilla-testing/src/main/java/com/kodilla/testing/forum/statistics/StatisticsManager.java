package com.kodilla.testing.forum.statistics;

public class StatisticsManager {

    private int userQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double postPerUser;
    private double commentPerUser;
    private double commentPerPost;


    public int getUserQuantity() {
        return userQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getPostPerUser() {
        return postPerUser;
    }

    public double getCommentPerUser() {
        return commentPerUser;
    }

    public double getCommentPerPost() {
        return commentPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        userQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
        postPerUser = postsQuantity / userQuantity;
        commentPerUser = commentsQuantity / userQuantity;
        commentPerPost = commentsQuantity / postsQuantity;
    }

    public void showStatistics() {

        System.out.println(userQuantity);
        System.out.println(postsQuantity);
        System.out.println(commentsQuantity);
        System.out.println(postPerUser);
        System.out.println(commentPerUser);
        System.out.println(commentPerPost);
    }
}