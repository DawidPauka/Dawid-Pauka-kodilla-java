package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        String taskToDo = "task to do";
        String taskInProgress = "task in progress";
        String taskDone = "task done";
        board.toDoList().addTask(taskToDo);
        board.inProgressList().addTask(taskInProgress);
        board.doneList().addTask(taskDone);

        //Then
        Assert.assertEquals("task to do", board.toDoList().getTasks().get(0));
        Assert.assertEquals("task in progress", board.inProgressList().getTasks().get(0));
        Assert.assertEquals("task done", board.doneList().getTasks().get(0));
    }
}