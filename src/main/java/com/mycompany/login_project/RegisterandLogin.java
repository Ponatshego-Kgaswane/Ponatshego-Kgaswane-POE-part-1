/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login_project;
import java.util.regex.Pattern;
/**
 *
 * @author kgasw
 */
public class RegisterandLogin {
    private String firstName;
   private String lastName;
   private String username;
   private String password;
   

   public RegisterandLogin() {
   }

   public String getFirstName() {
      return this.firstName;
   }

   public void setFirstName(String firstname) {
      this.firstName = this.lastName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastname) {
      this.password = this.lastName;
   }

   public String getUsername() {
      return this.username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isValidUsername() {
      return this.username != null && this.username.contains("_") && this.username.length() <= 5;
      
   }

   public boolean isValidPassword() {
       if (password.length() < 8) return false;
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false; // password must contain an uppercase letter
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false; // password must contain a number
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false; // password must contain a special character
        return true;

        }

     // create a new user account
    public void Account(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Profile establishment complete!");
    }

    // Method to login user and verify the credentials
    public boolean login(String username, String password) {
        if (this.username == null || this.password == null) {
            System.out.println("No user found, please establish an account first.");
            return false;
        }
  if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful! Welcome " + this.firstName + " " + this.lastName);
            return true;
        } else {
            System.out.println("Login failed! Invalid username or password.");
            return false;
        }
  
    }
}

