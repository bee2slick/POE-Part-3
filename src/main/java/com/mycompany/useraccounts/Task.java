/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.useraccounts;

/**
 *
 * @author Blessing
 */
class Task {
       
 
 
    private int totalHours = 0;
  

   
    
   //checking length of taskdescription method
    public boolean checktaskdescription(String taskDescription){
       
        
        return taskDescription.length()< 50; //task description must be less than 50
    }
    
   public String createTaskID(String taskName, String developer_details, int tasks){
       
      // Extract first two letters of taskName and last three letters of developerName
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerNamePart = developer_details.length() >= 3 ? developer_details.substring(developer_details.length() - 3).toUpperCase() : developer_details.toUpperCase();
        
        
        return taskNamePart + ":" + tasks + ":" + developerNamePart;
    
       
       
    }
    
    public String  printTaskdetails(String taskDescription, String taskID, String taskname, String developerDetails, int tasks,String statusOutput,int time ){
       
        return "Task Status: " + statusOutput + "\nDeveloper Details: " + developerDetails + "\nTask number: " + tasks + "\nTask name: " + taskname + "\nTask description: " + taskDescription + "\nTask ID: " + taskID + "\ntask duration: " + time +"hours";  
        
    }
    
    public int returnTotalhours(int time){
      this.totalHours += time; // Add the task's duration to totalHours
        return totalHours;
    
    
    }

    
    
}
