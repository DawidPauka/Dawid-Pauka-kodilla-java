package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer,ForumUser> usersById = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> Period.between(user.getBirthDate(),
                        LocalDate.now()).getYears() > 19)
                .filter(user -> user.getPostCount() > 0)
                .collect(Collectors.toMap(user -> user.getId(), user -> user));

        usersById.entrySet().stream()
                .forEach(System.out::println);
    }
}