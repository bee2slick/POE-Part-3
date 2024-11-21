/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.useraccounts;

import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Blessing
 */
public class UserAccounts {

    public static void main(String[] args) {
        
          //Class instance creation
        Login infor = new Login();
        Task upload = new Task();
        partThree Report = new partThree(); 
        
        
        //Object Scanner creation
        Scanner sc = new Scanner(System.in);
        
        //prompting user to enter first name
        System.out.println("enter your name:");
        infor.setName(sc.next());
        
        //prompting user to enter last name
        System.out.println("enter your last name:");
        infor.setsurname(sc.next());
        
        //creating username by prompting user
        System.out.println("create a username not longer than 5 characters and contains an underscore");
         String initialUsername = sc.next();
        
        //creating password by prompting user
       System.out.println("create a password longer than 7 characters");
       String initialPassword = sc.next();
       
         //Proccess of verifying conditions for registration
       if(infor.checkUserName(initialUsername) && infor.checkPasswordComplexity(initialPassword)){
           
        //callinng the registerUser method
        String register;
        register= infor.registerUser(initialUsername, initialPassword);
        System.out.println(register);
        
}
       
       //login to account
       if(initialUsername.contains("_") && initialUsername.length() <= 5 && infor.checkPasswordComplexity(initialPassword)){
       
         //prompting user to enter username to login
       System.out.println("Please enter your username to login:");
       String finalUserName= sc.next();
       
       //prompting user to enter password to login
       System.out.println("Please enter your password to login:");
        String finalpassWord = sc.next();
       
       //testing if password and username entered matches recorded password and username
       if(infor.loginUser(finalUserName,finalpassWord, initialUsername , initialPassword)){
                 
      
           //calling loginstatus method
           String status = infor.returnLoginStatus(finalUserName, finalpassWord ,initialUsername ,initialPassword );
           System.out.println(status);
           
           //command JOPtion to be on top
           final JDialog print = new JDialog();
            print.setAlwaysOnTop(true);
            
            //message welcoming user
            JOptionPane.showMessageDialog(print,"Welcome to Easykanban","Welcome",JOptionPane.INFORMATION_MESSAGE);
              
             int option = 0;
            String[] definetasks = null;
            String[] developer = null;
            String[] task_Names = null;
            String[] task_ID = null;
            int[] task_Hours = null;
            String[] task_Status = null;
            int tasks = 0;
             
             
             //while loop till option quit is choosen
            while(option !=3){
             
            
            String [] response = {"1. Add task(s)", "2. Show report", "3. Quit"};//array for menu option
            
            //JOptionPane to get option from user
             int choice =JOptionPane.showOptionDialog(print, "Choose option from menu:", "Menu", option, JOptionPane.PLAIN_MESSAGE, null, response, response[0]);
             option = choice;
           
            
              
            //switch case for different option choices
            switch(option){
                
                //add task option
                case 0:
                    
                    //prompt user to enter amount of tasks
                    tasks =Integer.parseInt(JOptionPane.showInputDialog(print, "How many task do you want to enter?", "task Amount", JOptionPane.QUESTION_MESSAGE));
                    definetasks = new String [tasks];
                    
                     //part 3
                    developer = new String  [tasks];
                    task_Names = new String [tasks];
                    task_ID = new String [tasks];
                   task_Hours = new int [tasks];
                   task_Status= new String [tasks];
                   
                    
                    //for loop to run till all tasks are entered
                   for (int i =0; i < definetasks.length; i++) {
                       
                       //prompting user to enter task name
                      String taskname = JOptionPane.showInputDialog(print, "Enter task name:");
                      task_Names[i] = taskname;
                      
                         // Task description prompt with validation loop
                         String taskDescription;
                       do {
                           taskDescription = JOptionPane.showInputDialog(print, "Enter task description (must be less than 50 characters):");
                       if (!upload.checktaskdescription(taskDescription)) {
                            JOptionPane.showMessageDialog(print, "Description too long! Please enter less than 50 characters.", "Error", JOptionPane.ERROR_MESSAGE);
                           }
                        } while (!upload.checktaskdescription(taskDescription)); // Repeat until valid description is entered

                       // Confirm successful capture
                         JOptionPane.showMessageDialog(print, "Task successfully captured!", "Task Capture", JOptionPane.INFORMATION_MESSAGE);

    // Developer details
                      
                      //asking user to enter developer details
                      String developerDetails=  JOptionPane.showInputDialog(print, "Enter developer's fullname (name and surname):");
                      developer[i] = developerDetails;
                      
                      //asking user to enter task duration in hours
                      int time = Integer.parseInt(JOptionPane.showInputDialog(print, "Enter task duration (in hours)", "task duration", JOptionPane.PLAIN_MESSAGE));
                       task_Hours[i] = time;
                       
                      //display task ID to user
                     String taskID =upload.createTaskID(taskname, developerDetails,i);
                     JOptionPane.showMessageDialog(print,taskID,"task ID",JOptionPane.INFORMATION_MESSAGE);
                    
                     
                      int statusOption = 0;// initializing status options
                       
                     String [] statusOftask = {"To Do", "Done", "Doing"};//Array  for task status
                     
                     //asking user to enter status of task
                     int taskStatus =JOptionPane.showOptionDialog(print, "Enter status of task", "task status", option,JOptionPane.QUESTION_MESSAGE,null, statusOftask, statusOftask[0]);
                      task_Status[i] = taskStatus == 0 ? "To Do" : taskStatus == 1 ? "Done" : "Doing";
                     statusOption =taskStatus;
                    
                     String statusOutput = "";
                     switch (statusOption){
                         case 0://displays when task is to be done 
                          statusOutput = "To Do";
                          JOptionPane.showMessageDialog(print,statusOutput,"Task status",JOptionPane.INFORMATION_MESSAGE);
                         break;
                         case 1://displays when task is done
                             statusOutput = "Done";
                             JOptionPane.showMessageDialog(print,statusOutput,"Task status",JOptionPane.INFORMATION_MESSAGE);
                         break;
                         
                         case 2: //displays when task is still being done
                              statusOutput = "Doing";
                             JOptionPane.showMessageDialog(print, statusOutput,"Task status",JOptionPane.INFORMATION_MESSAGE);
                         break;
                         
                         
                     }
                     
                     //displays task details
                     JOptionPane.showMessageDialog(print,upload.printTaskdetails(taskDescription, taskID, taskname,  developerDetails,  i, statusOutput, time ) , "Full task details", JOptionPane.INFORMATION_MESSAGE);
                     int totalHours = 0;
                     
                     //displays total hours of all entered tasks
                   JOptionPane.showMessageDialog(print,"Total hours:"+ upload.returnTotalhours(time)+" hours","Totat time", JOptionPane.INFORMATION_MESSAGE);
                    
                        
                   }
                   
                 
                  
                   
                    break;
                    //show report option
                case 1:
                  
                    String[] reportOptions = {"Show Completed Tasks", "Search for a Task by Name", "Show Longest Task", "Search Task by User", "Delete Task Using Task Name", "Show Full Report"};
                                int reportChoice = JOptionPane.showOptionDialog(print, "Choose an option:", "Show Report", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, reportOptions, reportOptions[0]);

                                switch (reportChoice) {
                                    case 0: // Show Completed Tasks
                                        StringBuilder doneTasksReport = new StringBuilder("Tasks with status 'Done':\n");
                                        for (int i = 0; i < tasks; i++) {
                                            if ("Done".equals(task_Status[i])) {
                                                doneTasksReport.append("Task Name: ").append(task_Names[i]).append("\n")
                                                               .append("Developer: ").append(developer[i]).append("\n")
                                                               .append("Duration: ").append(task_Hours[i]).append(" hours\n\n");
                                            }
                                        }
                                        if (doneTasksReport.length() > 0) {
                                            JOptionPane.showMessageDialog(print, doneTasksReport.toString(), "Completed Tasks Report", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(print, "No tasks with the status 'Done'.", "Completed Tasks Report", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        break;

                                    case 1: // Search for a specific task by name
                                        String taskNameToSearch = JOptionPane.showInputDialog(print, "Enter the task name to search:");
                                        String searchResult = Report.searchTaskByName(taskNameToSearch, task_Names, developer, task_Status);
                                        JOptionPane.showMessageDialog(print, searchResult, "Task Search Result", JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                    case 2: // Show longest task
                                        int longestTaskIndex = Report.findLongestTask(task_Hours);
                                        if (longestTaskIndex != -1) {
                                            JOptionPane.showMessageDialog(print, "Task with the longest duration:\n" +
                                                    "Task Name: " + task_Names[longestTaskIndex] + "\n" +
                                                    "Developer: " + developer[longestTaskIndex] + "\n" +
                                                    "Duration: " + task_Hours[longestTaskIndex] + " hours", "Longest Task", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(print, "No tasks available.", "Longest Task", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        break;

                                    case 3: // Search for tasks by developer
                                        String developerToSearch = JOptionPane.showInputDialog(print, "Enter the developer's name to view tasks:");
                                        String searchResultByDeveloper = Report.searchTasksByDeveloper(developerToSearch, task_Names, developer, task_Status);
                                        JOptionPane.showMessageDialog(print, searchResultByDeveloper, "Developer's Task Search Result", JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                    case 4: // Delete task by name
                                        String taskNameToDelete = JOptionPane.showInputDialog(print, "Enter the name of the task to delete:");
                                        if (taskNameToDelete != null && !taskNameToDelete.trim().isEmpty()) {
                                            String deleteMessage = Report.deleteTaskByName(taskNameToDelete, task_Names, developer, task_Status, task_Hours);
                                            JOptionPane.showMessageDialog(print, deleteMessage, "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(print, "Task name cannot be empty.", "Delete Task", JOptionPane.WARNING_MESSAGE);
                                        }
                                        break;

                                    case 5: // Show full report
                                        String fullReport = Report.displayAllTasksReport(task_Names, developer, task_Status, task_Hours, task_ID);
                                        JOptionPane.showMessageDialog(print, fullReport, "All Tasks Report",
                                                 JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                    default:
                                        break;
                           
}
                    break;
                    //quit option
                case 2:
                    option = 3;
                     JOptionPane.showMessageDialog(print,"Goodbye","Task Capture",JOptionPane.INFORMATION_MESSAGE);
                    break;
               
            }
            }
            print.dispose();
            
          
       }
       else{
            //calling loginstatus method
            String status = infor.returnLoginStatus( finalUserName, finalpassWord,initialUsername , initialPassword);
           System.out.println(status);
          
       } 
       }
       else{
            String register;
                register= infor.registerUser(initialUsername, initialPassword);
        System.out.println(register);
         
       }
    }
   
}
