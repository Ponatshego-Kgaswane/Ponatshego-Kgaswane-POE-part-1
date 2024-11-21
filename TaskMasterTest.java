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
public class TaskMasterTest {
    
    

    @Test
    public void testGetDeveloperDetails() {
        TaskMaster taskManager = new TaskMaster();
        
        Task task1 = new Task("Create Login", 1, "Create a login screen", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", 2, "Add new features", "Edward Harrison", 8, "Doing");
        Task task3 = new Task("Create Reports", 3, "Generate user reports", "Samantha Paulson", 2, "Done");
        Task task4 = new Task("Add Arrays", 4, "Implement array logic", "Glenda Oberholzer", 11, "To Do");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);

        String[] expected = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] result = taskManager.getDeveloperDetails();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDisplayLongestTask() {
        TaskMaster taskManager = new TaskMaster();
        
        Task task1 = new Task("Create Login", 1, "Create a login screen", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", 2, "Add new features", "Edward Harrison", 8, "Doing");
        Task task3 = new Task("Create Reports", 3, "Generate user reports", "Samantha Paulson", 2, "Done");
        Task task4 = new Task("Add Arrays", 4, "Implement array logic", "Glenda Oberholzer", 11, "To Do");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);

        Task longestTask = taskManager.displayLongestTask();
        assertEquals("Glenda Oberholzer", longestTask.getDeveloperDetails());
        assertEquals(11, longestTask.getTaskDuration());
    }

    @Test
    public void testGetTaskByName() {
        TaskMaster taskManager = new TaskMaster();
        
        Task task1 = new Task("Create Login", 1, "Create a login screen", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", 2, "Add new features", "Edward Harrison", 8, "Doing");
        Task task3 = new Task("Create Reports", 3, "Generate user reports", "Samantha Paulson", 2, "Done");
        Task task4 = new Task("Add Arrays", 4, "Implement array logic", "Glenda Oberholzer", 11, "To Do");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);

        Task task = taskManager.getTaskByName("Create Login");
        assertEquals("Mike Smith", task.getDeveloperDetails());
        assertEquals("Create Login", task.getTaskName());
    }

    @Test
    public void testSearchTasksByDeveloper() {
        TaskMaster taskManager = new TaskMaster();
        
        Task task1 = new Task("Create Login", 1, "Create a login screen", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", 2, "Add new features", "Edward Harrison", 8, "Doing");
        Task task3 = new Task("Create Reports", 3, "Generate user reports", "Samantha Paulson", 2, "Done");
        Task task4 = new Task("Add Arrays", 4, "Implement array logic", "Glenda Oberholzer", 11, "To Do");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);

        Task task = taskManager.getTaskByName("Create Reports");
        assertEquals("Samantha Paulson", task.getDeveloperDetails());
        assertEquals("Create Reports", task.getTaskName());
    }

    @Test
    public void testDeleteTaskByName() {
        TaskMaster taskManager = new TaskMaster();
        
        Task task1 = new Task("Create Login", 1, "Create a login screen", "Mike Smith", 5, "To Do");
        Task task2 = new Task("Create Add Features", 2, "Add new features", "Edward Harrison", 8, "Doing");

}
}
