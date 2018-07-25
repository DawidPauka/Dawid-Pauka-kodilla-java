package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testMakeShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeTask(TaskFactory.SHOPPING,
                "My shopping list",
                "potatoes",
                "2.5");
        boolean beforeExecution = shopping.isTaskExecuted();
        shopping.executeTask();
        //Then
        Assert.assertEquals("My shopping list", shopping.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testMakePaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeTask(TaskFactory.PAINTING,
                "My painting task", "blue", "my car");
        boolean beforeExecution = painting.isTaskExecuted();
        painting.executeTask();
        //Then
        Assert.assertEquals("My painting task", painting.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testMakeDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeTask(TaskFactory.DRIVING,
                "My driving task", "to heaven", "my painted blue car");
        boolean beforeExecution = driving.isTaskExecuted();
        driving.executeTask();
        //Then
        Assert.assertEquals("My driving task", driving.getTaskName());
        Assert.assertFalse(beforeExecution);
        Assert.assertTrue(driving.isTaskExecuted());
    }

    @Test
    public void testNullTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task nullTask = taskFactory.makeTask("Null",
                "My null task", "", "");
        //Then
        Assert.assertNull(nullTask);
    }
}