/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login_project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kgasw
 */
public class TaskTest {
    
       /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
   public void testTaskDescriptionLength_Success() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription());
    }
@Test
    public void testTaskDescriptionLength_Failure() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users, this description is too long and should fail", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription());
    }
    /**
     * Test of createTaskID method, of class Task.
     */
  @Test
public void testTaskIDCreation() {
    Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
    assertEquals("LO:1:SON", task.createTaskID());
}


    /**
     * Test of returnTaskDuration method, of class Task.
     */
    @Test
   
    public void testTotalHoursAccumulation() {
        Task[] tasks = new Task[2];
        tasks[0] = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        tasks[1] = new Task("Add Task Feature", 2, "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.returnTaskDuration();
        }
        assertEquals(18, totalHours);
    }
        @Test
    public void testTotalHoursAccumulation_AdditionalData() {
        Task[] tasks = new Task[5];
        tasks[0] = new Task("Task1", 1, "Task1 description", "Developer1", 10, "To Do");
        tasks[1] = new Task("Task2", 2, "Task2 description", "Developer2", 12, "Doing");
        tasks[2] = new Task("Task3", 3, "Task3 description", "Developer3", 55, "Done");
        tasks[3] = new Task("Task4", 4, "Task4 description", "Developer4", 11, "To Do");
        tasks[4] = new Task("Task5", 5, "Task5 description", "Developer5", 1, "Doing");
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.returnTaskDuration();
        }
        assertEquals(89, totalHours);

}

    
}
