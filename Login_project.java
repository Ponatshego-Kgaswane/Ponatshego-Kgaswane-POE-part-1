/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login_project;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author kgasw
 */
public class Login_project {
   


    public static void main(String[] args) {
        RegisterandLogin login = new RegisterandLogin();
        TaskMaster taskMaster = new TaskMaster();
        
        // Registration loop
        boolean registered = false;
        while (!registered) {
            JOptionPane.showMessageDialog(null, "Please register your account.");
            String username = JOptionPane.showInputDialog(null, "Enter username:");
            String password = JOptionPane.showInputDialog(null, "Enter password:");
            String firstName = JOptionPane.showInputDialog(null, "Enter your first name:");
            String lastName = JOptionPane.showInputDialog(null, "Enter your last name:");
            
            login.setUsername(username);
            login.setPassword(password);
            login.setFirstName(firstName);
            login.setLastName(lastName);
            
            String result = login.registerUser(firstName, lastName, username, password);
            JOptionPane.showMessageDialog(null, result);
            
            if (result.equals("Username and Password successfully captured")) {
                registered = true;
            }
        }
        
        // Login loop
        boolean loggedin = false;
        while (!loggedin) {
            JOptionPane.showMessageDialog(null, "Registration complete. Please log in.");
            String inputUsername = JOptionPane.showInputDialog(null, "Enter username:");
            String inputPassword = JOptionPane.showInputDialog(null, "Enter password:");
            
            if (login.loginUser(inputUsername, inputPassword)) {
                loggedin = true;
                JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        }
        
        // Displaying the menu
        showMenu(login.getFirstName(), login.getLastName(), taskMaster);
    }
    
   public static void showMenu(String firstName, String lastName, TaskMaster taskManager) {
    boolean running = true;
    while (running) {
        String menu = "Welcome to EasyKanban, " + firstName + " " + lastName + "\n" +
                      "1. Add Tasks\n" +
                      "2. Show Report\n" +
                      "3. Search Task\n" +
                      "4. Delete Task\n" + 
                      "5. Quit\n";
        String input = JOptionPane.showInputDialog(null, menu);
        int choice = Integer.parseInt(input);

        switch (choice) {
            case 1:
                addTasks(taskManager);
                break;
            case 2:
                taskManager.displayReport();
                break;
            case 3:
                searchTask(taskManager);
                break;
            case 4:
                deleteTask(taskManager); 
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Goodbye!");
                running = false;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
                break;
        }
    }
}

    // Add tasks method, modified to populate arrays
    public static void addTasks(TaskMaster TaskMaster) {
        int numTasks;
        do {
            numTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to add?"));
            if (numTasks <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive number.");
            }
        } while (numTasks <= 0);

        Task[] tasks = new Task[numTasks];
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog(null, "Enter the name of task " + (i + 1) + ":");
            String taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 characters):");
            String developerDetails = JOptionPane.showInputDialog(null, "Enter developer's full name:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter estimated duration of task (in hours):"));
            String[] statusOptions = {"To Do", "Doing", "Done"};
            int statusOption = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            String taskStatus = (String) statusOptions[statusOption];

            Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
            TaskMaster.addTask(task);
        }
    }

    // Search task by name
    public static void searchTask(TaskMaster TaskMaster) {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name to search for:");
        Task task = TaskMaster.getTaskByName(taskName);
        if (task != null) {
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        } else {
            JOptionPane.showMessageDialog(null, "Task not found!");
        }
    }
    public static void deleteTask(TaskMaster taskMaster) {
    String taskName = JOptionPane.showInputDialog(null, "Enter the task name to delete:");
    taskMaster
            .deleteTaskByName(taskName);
}

    
}

    
    

