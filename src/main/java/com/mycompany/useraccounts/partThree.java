/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.useraccounts;

/**
 *
 * @author Blessing
 */
public class partThree {
    
    // Method to find the index of the task with the longest duration
    public int findLongestTask(int[] durations) {
        int maxIndex = -1; 
        int maxDuration = 0;
        for (int i = 0; i < durations.length; i++) {
            if (durations[i] > maxDuration) {
                maxDuration = durations[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
     // Method to search for a task by its name and return details if found
    public String searchTaskByName(String taskName, String[] taskNames, String[] developers, String[] statuses) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                return "Task Name: " + taskNames[i] + "\n" +
                       "Developer: " + developers[i] + "\n" +
                       "Status: " + statuses[i];
            }
        }
        return "Task not found.";
    }
    
      // Method to search for tasks by developer
    public String searchTasksByDeveloper(String developerName, String[] taskNames, String[] developers, String[] taskStatus) {
        StringBuilder result = new StringBuilder("Tasks assigned to " + developerName + ":\n");

        boolean found = false;
        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equalsIgnoreCase(developerName)) { // Check if developer matches the input
                result.append("Task Name: ").append(taskNames[i])
                      .append("\nStatus: ").append(taskStatus[i])
                      .append("\n\n");
                found = true;
            }
        }

        if (!found) {
            result.append("No tasks found under this developer name.");
        }

        return result.toString();
    }
   //delete task method using task name
    public String deleteTaskByName(String taskName, String[] taskNames, String[] developers, String[] taskStatus, int[] taskDuration) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null && taskNames[i].equalsIgnoreCase(taskName)) { 
                // Shift elements left to fill in the gap
                for (int j = i; j < taskNames.length - 1; j++) {
                    taskNames[j] = taskNames[j + 1];
                    developers[j] = developers[j + 1];
                    taskStatus[j] = taskStatus[j + 1];
                    taskDuration[j] = taskDuration[j + 1];
                }

                // Clear the last elements after shifting
                taskNames[taskNames.length - 1] = null;
                developers[developers.length - 1] = null;
                taskStatus[taskStatus.length - 1] = null;
                taskDuration[taskDuration.length - 1] = 0;

                return "Task '" + taskName + "' deleted.";
            }
        }
        //return message if task name is not found
        return "Task '" + taskName + "' not found.";
    }
     // Existing methods like findLongestDurationTask, deleteTaskByName, etc.

    public String displayAllTasksReport(String[] taskNames, String[] developer, String[] taskStatus, int[] taskDuration, String[] tasKid) {
        StringBuilder report = new StringBuilder("Full Task Details Report:\n\n");

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i] != null) {  // Check if task exists
                report.append("Task Name: ").append(taskNames[i]).append("\n")
                      .append("Developer: ").append(developer[i]).append("\n")
                      .append("Task Duration: ").append(taskDuration[i]).append(" hours\n")
                      .append("Task Status: ").append(taskStatus[i]).append("\n")
                      .append("Task ID: ").append(tasKid[i]).append("\n\n");
            }
        }

        return report.toString();
    }

    }
    

