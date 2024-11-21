/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.useraccounts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author blessing
 */
public class TaskIT {
    
   

    /**
     * Test of checktaskdescription method, of class Task.
     */
    @Test
    public void testChecktaskdescription() {
        System.out.println("checktaskdescription");
        String taskDescription = "gfuyguy";
        Task instance = new Task();
        boolean expResult = true;
        boolean result = instance.checktaskdescription(taskDescription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        String taskName = "login";
        String developer_details = "userlogin";
        int tasks = 0;
        Task instance = new Task();
        String expResult = "";
        String result = instance.createTaskID(taskName, developer_details, tasks);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of printTaskdetails method, of class Task.
     */
    @Test
    public void testPrintTaskdetails() {
        System.out.println("printTaskdetails");
        String taskDescription = "";
        String taskID = "";
        String taskname = "";
        String developerDetails = "";
        int tasks = 0;
        String statusOutput = "";
        int time = 0;
        Task instance = new Task();
        String expResult = "";
        String result = instance.printTaskdetails(taskDescription, taskID, taskname, developerDetails, tasks, statusOutput, time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalhours method, of class Task.
     */
    @Test
    public void testReturnTotalhours() {
        System.out.println("returnTotalhours");
        int time = 0;
        Task instance = new Task();
        int expResult = 0;
        int result = instance.returnTotalhours(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
