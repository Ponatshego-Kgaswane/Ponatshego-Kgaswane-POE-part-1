/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login_project;
import java.util.*;
/**
 *
 * @author kgasw
 */
public class Login_project {

    public static void main(String[] args) {
           RegisterandLogin system = new RegisterandLogin();
        Scanner sc = new Scanner(System.in);

           // Keep asking for valid account creation details using a while loop
        boolean isAccountCreated = false;

        System.out.println("Hi, Let's create your account!");

        while (!isAccountCreated) {
            //firstname
            System.out.print("Please enter your first name: ");
            String firstName = sc.nextLine();
            system.setFirstName(firstName);
            
            //last name
            System.out.print("Please enter your last name: ");
            String lastName = sc.nextLine();
            system.setLastName(lastName);
            
            //username and requirements
            System.out.print("Please enter your username: ");
            String username = sc.nextLine();
            system.setUsername(username);
            
            //password and requirements
            System.out.print("Please enter your password: ");
            String password = sc.nextLine();
            system.setPassword(password);

            
        
            if (!system.isValidUsername()) {
                System.out.println("Invalid username! Username must contain an underscore and be no more than 5 characters long.");
            }
            else if (!system.isValidPassword()) {
                System.out.println("Invalid password! Password must be at least 8 characters long, contain a capital letter, a number, and a special character.");
            } else {
 system.Account(username, password, firstName, lastName);
                isAccountCreated = true;
            }
        }

        // Proceed to login if account creation is successful
        System.out.println("Login:");
        System.out.print("Please enter your username: ");
        String loginUsername = sc.nextLine();
        System.out.print("Please enter your password: ");
        String loginPassword = sc.nextLine();

        // Attempt login
        system.login(loginUsername, loginPassword);
    }
    }

    
