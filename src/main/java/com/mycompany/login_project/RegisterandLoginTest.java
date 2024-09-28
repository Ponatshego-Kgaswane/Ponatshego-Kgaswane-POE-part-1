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
public class RegisterandLoginTest {
    
    /**
     * Test of isValidUsername method, of class RegisterandLogin.
     */
  @Test
    public void testIsValidUsername() {
        System.out.println("Welcome user, it is great to see you");
        RegisterandLogin instance = new RegisterandLogin();
        instance.setUsername("kyl_1");
        boolean expResult = true;
        boolean result = instance.isValidUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidUsername method, of class RegisterandLogin.
     */
     @Test
    public void testInvalidUsername() {
         System.out.println(" Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        RegisterandLogin instance = new RegisterandLogin();
        instance.setUsername("kyle!!!!!!!"); // Modified to exceed 5 characters
        boolean expResult = false;
        boolean result = instance.isValidUsername();
        assertEquals(expResult, result);
    }



    /**
     * Test of isValidPassword method, of class RegisterandLogin.
     */
   @Test
    public void testIsValidPassword() {
        System.out.println("Password successfully captured");
        RegisterandLogin instance = new RegisterandLogin();
        instance.setPassword("Ch&&sec@ke99!");
        boolean expResult = true;
        boolean result = instance.isValidPassword();
        assertEquals(expResult, result);
    }

       /**
     * Test of isValidPassword method, of class RegisterandLogin.
     */
   @Test
    public void testInValidPassword() {
         System.out.println("Password is not correctly formatted, please ensure that the password contains atleast 8 characters, a capital letter, a number and a special charater");
        RegisterandLogin instance = new RegisterandLogin();
        instance.setPassword("password");
        boolean expResult = false;
        boolean result = instance.isValidPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class RegisterandLogin.
     */
    @Test
    public void testValidLogin() {
        System.out.println("Successfully logged in");
        RegisterandLogin instance = new RegisterandLogin();
        instance.setUsername("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        boolean expResult = true;
        boolean result = instance.login("kyl_1", "Ch&&sec@ke99!");
        assertEquals(expResult, result);
    }
      /**
     * Test of login method, of class RegisterandLogin.
     */
    @Test
    public void testInvalidLogin() {
        RegisterandLogin instance = new RegisterandLogin();
        instance.setUsername("kyl_1");
        instance.setPassword("Ch&&sec@ke99!");
        boolean expResult = false;
        boolean result = instance.login("wrong_username", "wrong_password");
        assertEquals(expResult, result);
    }

    
}
