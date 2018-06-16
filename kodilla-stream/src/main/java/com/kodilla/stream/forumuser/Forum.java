package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList = new LinkedList<>();

    public Forum() {
        userList.add(
                new ForumUser("Paulina", 'M', LocalDate.parse("1864-05-15"), 22));
        userList.add(
                new ForumUser("Bartek", 'M', LocalDate.parse("2012-12-30"), 3));
        userList.add(
                new ForumUser("Ramzes", 'M', LocalDate.parse("1599-11-28"), 4));
        userList.add(
                new ForumUser("Aleksandra", 'F', LocalDate.parse("1945-04-23"), 0));
        userList.add(
                new ForumUser("Kendra", 'F', LocalDate.parse("2000-06-17"), 70));
        userList.add(
                new ForumUser("Aleksander", 'M', LocalDate.parse("1689-05-25"), 1));
        userList.add(
                new ForumUser("Dawid", 'M', LocalDate.parse("2000-07-15"), 32));
        userList.add(
                new ForumUser("Angela", 'F', LocalDate.parse("1789-03-09"), 23));
        userList.add(
                new ForumUser("Tomek", 'M', LocalDate.parse("1489-05-22"), 5));
    }

    public List<ForumUser> getUserList() {
        return new LinkedList<>(userList);
    }
}