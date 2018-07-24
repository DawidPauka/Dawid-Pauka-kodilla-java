package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.*;

@Configuration
public class BoardConfig {

    @Bean
    public Board board() {
        return new Board(toDoList(), inProgressList() , doneList());
    }

    public TaskList toDoList() {
        return new TaskList();
    }

    public TaskList inProgressList() {
        return new TaskList();
    }

    public TaskList doneList() {
        return new TaskList();
    }
}