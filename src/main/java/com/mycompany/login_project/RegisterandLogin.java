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
    
    // Getters and Setters
    public RegisterandLogin() {}
    
    public String getFirstName() {return this.firstName;}
    public void setFirstName(String firstname) {this.firstName = firstname;}
    public String getLastName() {return this.lastName;}
    public void setLastName(String lastname) {this.lastName = lastname;} // Corrected setLastName method
    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return this.password;}
    public void setPassword(String password) {this.password = password;}
    
// Method for a valid password and requirements/rules
    public boolean isValidPassword() {
        if (password == null) return false;
        if (password.length() < 8) return false;
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false;
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false;
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false;
        return true;
    }
    
    // Method for a valid username
    public boolean isValidUsername() {
        return username != null && username.contains("_") && username.length() <= 5;
    }
    
    // User credentials validation
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
     // Register user
    public String registerUser() {
        if (!isValidUsername()) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!isValidPassword()) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "Username and Password successfully captured";
    }
}


