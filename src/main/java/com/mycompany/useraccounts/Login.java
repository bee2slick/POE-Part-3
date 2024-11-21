/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.useraccounts;

/**
 *
 * @author Blessing
 */
class Login {
       //variable declaration
     private String name;
    private String lastname;
    private String initialUsername;
    private String initialPassword;
    private String finalUserName;
    private String finalpassWord;
    
    //setting getter and setter methods
    public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
public String getsurname() {
    return lastname;
}

public void setsurname(String lastname) {
    this.lastname = lastname;
}



    
    
     public boolean checkUserName(String initialUsername){
          
        
         //Check if the username is less than or equal to 5 characters and contains an underscore
        return initialUsername.length() <= 5 && initialUsername.contains("_");
    }
    
    public boolean checkPasswordComplexity(String initialPassword){
         
     
    // Ensure password is at least 8 characters, has one uppercase letter, one digit, and one special character
    return initialPassword.length() >= 8 
        && initialPassword.matches(".*[A-Z].*")    // Check for at least one uppercase letter
        && initialPassword.matches(".*\\d.*")      // Check for at least one digit
        && initialPassword.matches(".*[^a-zA-Z0-9].*"); // Check for at least one special character
        
    }
    
    public String registerUser(String initialUsername, String initialPassword){
         // Check if username and password meet the required conditions
        if (checkUserName(initialUsername) && checkPasswordComplexity(initialPassword)) {
            return "username and password successfully captured ";
          
            
        } else if (!checkUserName(initialUsername)) {
            return "username not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
            
        } else if (!checkPasswordComplexity(initialPassword)) {
            return "Password not correctly formatted, please ensure that your password contains atleast 8 characters, capital letter, special character and a number";
        }else{
        return "Registration failed: Incorrect login information.";}
    }
    
    public boolean loginUser(String finalUserName, String finalpassWord, String initialUsername, String initialPassword){
    
         
      
        return finalUserName.equals(initialUsername) && finalpassWord.equals(initialPassword);
    }

       
    
    public  String returnLoginStatus(String finalUserName, String finalpassWord, String initialUsername, String initialPassword){
      if (loginUser(finalUserName, finalpassWord, initialUsername, initialPassword)) {
            return "Welcome back " + name +" " + lastname +" it is great to see you again.";
        } else {
            return "username or password might be incorrect, please try again.";
        } 

    }
    
}
