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
            
  // Display registration result
            String result = login.registerUser();
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
            
            // Display login result
            if (login.loginUser(inputUsername, inputPassword)) {
                loggedin = true;
                JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }
        }
        
        showMenu(login.getFirstName(), login.getLastName());
    }
    
 // Menu for EasyKanban
    public static void showMenu(String firstName, String lastName) {
         JOptionPane.showMessageDialog(null, "Welcome to EasyKanban, " + firstName + " " + lastName + ".");
  boolean running = true;
        while (running) {
            Object[] options = {"Add tasks", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Please choose one of the following options:", "EasyKanban Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addTasks();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    running = false;
                    break;
            }
        }
    }

    // Add tasks
    public static void addTasks() {
           int numTasks;
        do {
            numTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to add?"));
            if (numTasks <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a positive number.");
            }
        } while (numTasks <= 0);

        Task[] tasks = new Task[numTasks];
        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            String taskName, taskDescription, developerDetails;
            int taskDuration;

            do {
                taskName = JOptionPane.showInputDialog(null, "Enter the name of task " + (i + 1) + ":");
                if (taskName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Task name cannot be empty.");
                }
            } while (taskName.isEmpty());

            do {
                taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 characters):");
  if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of 50 characters or less.");
                }
            } while (taskDescription.length() > 50);

            do {
                developerDetails = JOptionPane.showInputDialog(null, "Enter developer's full name:");
                if (developerDetails.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Developer's name cannot be empty.");
                }
            } while (developerDetails.isEmpty());

            do {
                taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter estimated duration of task (in hours):"));
                if (taskDuration <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number.");
                }
            } while (taskDuration <= 0);

            Object[] statusOptions = {"To Do", "Doing", "Done"};
            int statusOption = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            String taskStatus = (String) statusOptions[statusOption];
  tasks[i] = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);

            JOptionPane.showMessageDialog(null, "Task successfully captured");
            JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
            totalHours += tasks[i].returnTaskDuration();
        }

        JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + totalHours + " hrs");
    }
    }

    

