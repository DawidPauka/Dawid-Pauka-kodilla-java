package com.kodilla.spring.portfolio;

public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList toDoList() {
        return toDoList;
    }

    public TaskList  inProgressList() {
        return inProgressList;
    }

    public TaskList doneList() {
        return doneList;
    }
}