/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login_project;
import java.util.*;
/**
 *
 * @author kgasw
 */
public class TaskMaster {
  
    
    private List<Task> tasks = new ArrayList<>();
    private String[] developers;
    private String[] taskNames;
    private String[] taskIDs;
    private int[] taskDurations;
    private String[] taskStatuses;

    public void addTask(Task task) {
        tasks.add(task);
        updateArrays();
    }

    // Updates arrays with the latest task data
    private void updateArrays() {
        developers = new String[tasks.size()];
        taskNames = new String[tasks.size()];
        taskIDs = new String[tasks.size()];
        taskDurations = new int[tasks.size()];
        taskStatuses = new String[tasks.size()];

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            developers[i] = task.getDeveloperDetails();
            taskNames[i] = task.getTaskName();
            taskIDs[i] = task.getTaskID();
            taskDurations[i] = task.getTaskDuration();
            taskStatuses[i] = task.getTaskStatus();
        }
    }

    // Get task by name
    public Task getTaskByName(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return task;
            }
        }
        return null;
    }

    // Display tasks where status is 'Done'
    public void displayDoneTasks() {
        for (Task task : tasks) {
            if ("Done".equalsIgnoreCase(task.getTaskStatus())) {
                System.out.println("Developer: " + task.getDeveloperDetails() +
                        "\nTask Name: " + task.getTaskName() + "\nTask Duration: " + task.getTaskDuration());
            }
        }
    }

    // Display task with the longest duration
    public Task displayLongestTask() {
    Task longestTask = null;
    for (Task task : tasks) {
        if (longestTask == null || task.getTaskDuration() > longestTask.getTaskDuration()) {
            longestTask = task;
        }
    }
    return longestTask;
}


    // Search for tasks assigned to a developer
    public void searchTasksByDeveloper(String developer) {
        for (Task task : tasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developer)) {
                System.out.println("Task Name: " + task.getTaskName() +
                        "\nTask Status: " + task.getTaskStatus());
            }
        }
    }

    // Method to delete a task by task name
public void deleteTaskByName(String taskName) {
    Task taskToDelete = null;
    
    // Loop through the list of tasks to find the task with the matching name
    for (Task task : tasks) {
        if (task.getTaskName().equalsIgnoreCase(taskName)) {
            taskToDelete = task; // Found the task to delete
            break;
        }
    }
    
    // If the task is found, remove it from the list
    if (taskToDelete != null) {
        tasks.remove(taskToDelete);
        updateArrays(); // Update the arrays after deletion
        System.out.println("Task \"" + taskName + "\" has been successfully deleted.");
    } else {
        System.out.println("Task not found!");
    }
}


    // Display all tasks' details
    public void displayReport() {
        for (Task task : tasks) {
            System.out.println(task.printTaskDetails());
        }
    }

    // Get developer details
    public String[] getDeveloperDetails() {
        String[] developerDetails = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            developerDetails[i] = tasks.get(i).getDeveloperDetails();
        }
        return developerDetails;
    }
}







