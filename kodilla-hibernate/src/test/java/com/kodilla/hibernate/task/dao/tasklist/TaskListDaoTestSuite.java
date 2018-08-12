package com.kodilla.hibernate.task.dao.tasklist;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String NAME1 = "ToDo";
    private static final String DESCRIPTION1 = "Tasks that are not started yet";
    private static final String NAME2 = "In progress";
    private static final String DESCRIPTION2 = "Tasks that are started but that are not finished yet";
    private static final String NAME3 = "Done";
    private static final String DESCRIPTION3 = "Tasks that are finished";
    private static final String DESCRIPTION_COMMON = "The task has no description yet";

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList1 = new TaskList(NAME1, DESCRIPTION1);
        TaskList taskList2 = new TaskList(NAME2, DESCRIPTION2);
        TaskList taskList3 = new TaskList(NAME3, DESCRIPTION3);
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);
        taskListDao.save(taskList3);

        // When
        List<TaskList> readTasksLists = taskListDao.findByListName(NAME2);

        // Then
        assertEquals(1, readTasksLists.size());
        TaskList readTaskList = readTasksLists.get(0);
        assertEquals(taskList2, readTaskList);

        // CleanUp
        taskListDao.delete(taskList1);
        taskListDao.delete(taskList2);
        taskListDao.delete(taskList3);
    }

    @Test
    public void testFindOneDefaultCaching() {
        // Given
        TaskList taskList = new TaskList(NAME1, DESCRIPTION1);
        taskListDao.save(taskList);
        int id = taskList.getId();

        // When
        TaskList readTaskList = taskListDao.findOne(id);

        // Then
        assertTrue(taskList == readTaskList);

        // CleanUp
        taskListDao.delete(id);
    }

    @Test
    public void testDelete() {
        // Given
        TaskList taskList = new TaskList(NAME1, DESCRIPTION1);
        taskListDao.save(taskList);
        int id = taskList.getId();
        TaskList readTaskList = taskListDao.findOne(id);

        // When
        taskListDao.delete(id);

        // Then
        assertNotNull(taskList);
        assertNotNull(readTaskList);
        assertEquals(taskList, readTaskList);
        assertEquals(id, taskList.getId());
        assertEquals(NAME1, taskList.getListName());
        assertEquals(DESCRIPTION1, taskList.getDescription());
    }

    @Test
    public void testSaveDeletedInstance() {
        // Given
        TaskList taskList = new TaskList(NAME1, DESCRIPTION1);
        taskListDao.save(taskList);
        int id = taskList.getId();
        TaskList readTaskList = taskListDao.findOne(id);
        taskListDao.delete(id);

        try {
            // When
            taskListDao.save(taskList);
            // Then
            fail("Expected exception here: org.springframework.dao.InvalidDataAccessApiUsageException");
        } catch (org.springframework.dao.InvalidDataAccessApiUsageException e) {
            // OK
        }
    }
}