

package ChatApp;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Chatapp {
    //USer details
    public String userName;
    public String password;
    private String cellNumber;
    public String firstName;
    public String lastName;
    
     public String message;
     public String messageID;
     private String cellNumber2;
     public String sent;
     public String hash;
     public int messageNum;
     
    // Default login Constructor
    public  Chatapp(){
        this.cellNumber = "";
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.userName = "";
        
// Default message Constructor
         this.message = "";
        this.messageID = "";
        this.cellNumber2 = "";
        this.sent = "";
        this.hash = "";
        this.messageNum =0;
    }
    
   
    
   

    // Main method to run the program
    public static void main(String[] args) {
        Chatapp authSystem = new Chatapp(); // Updated class name here
        Scanner inputScanner = new Scanner(System.in);
        boolean loginSuccess=  false; boolean valid = false;
      /* System.out.println("=== User Registration ===");
        String registrationResult = authSystem.registerNewUser(inputScanner);
        System.out.println(registrationResult);

        if (registrationResult.toLowerCase().contains("successful")) {
            System.out.println("\n=== User Login ===");
            System.out.print("Enter username: ");
            String enteredUsername = inputScanner.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = inputScanner.nextLine();

            loginSuccess = authSystem.authenticateUser(enteredUsername, enteredPassword);   
        }
        if(!loginSuccess){
            System.out.print("Login Not Successful");
            inputScanner.close();
            System.exit(0);
        }
        else{ 
            System.out.println(authSystem.getLoginStatusMessage(loginSuccess));*/
            System.out.print("1. Make Message \n2.Come Soon  \n3.Quit\n");
            int loop;
            
            loop = inputScanner.nextInt();
            if(loop >=1 && loop <=2){
                while(loop>=1 && loop<= 2){
                    if(loop==1){ 
                        String cellNumber2, message;
                        
                        System.out.print("Enter Recipient Number ");
                        cellNumber2 = inputScanner.next(); 
                        inputScanner.nextLine();
                        System.out.print("Enter Message :");
                        message = inputScanner.nextLine();
                        
                        
                        System.out.print("Review Message :\n ");
                        System.out.print("Message : "+ message);
                        System.out.print("\nRecipient : "+ cellNumber2 );
                       
                        System.out.print("\nWhat to do with the message? \n ");
                        String send = authSystem.sentMessage (inputScanner);
                        if (send.compareToIgnoreCase("send")==0 || send.compareToIgnoreCase("save")==0){
                        if(authSystem.checkRecipientCell (cellNumber2) == 1){
                             if(message.length()>0 && message.length()<= 250)
                             {valid = true; authSystem.messageNum = authSystem.messageNum + 1;} }
                        }
                        String messageID = authSystem.generateRandomId();
                        while(!authSystem.checkMessageID(messageID)){
                             messageID=authSystem.generateRandomId();
                                }
                        //Create Hash
                        String hashCreate="";
                        int add =0;
                        while(add<=1){
                            hashCreate = hashCreate + messageID.charAt(add);
                            add+=1;
                        }
                        authSystem.hash = hashCreate + ":" + authSystem.messageNum + ":" + authSystem.getFirstWord(message).toUpperCase() + authSystem.getLastWord(message).toUpperCase();
                        //Display message 
                        if(valid){
                            System.out.println(authSystem.printMessage(message, authSystem.hash, cellNumber2, send, messageID, authSystem.messageNum));
                         System.out.print("Total Messages Save so far :" + authSystem.returnTotalMessage(authSystem.messageNum) +"\n");   
                        }
                        else if(send.compareToIgnoreCase("Delete")==0){
                            //Message Deleted
                             System.out.print("Message Deleted\n" );
                        }
                         else {
                            //Invalid Cell Phone or Message
                             System.out.print("Message, Send Action or Cell Number Invalid \n" );
                        }
                        
                    }    
                    else{
                        System.out.print("Currently Not Available right now ");
                    }
                    System.out.print("1. Make Another Message \n 2.Come Soon \n 3. Quit \n");
                    loop = inputScanner.nextInt();
                }
            }
            else{
                System.out.print("Not a Option/Closing ");
            }
        //}
    }

    // Check if username meets requirements
    public boolean validateUsernameFormat(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Check if password meets complexity requirements
    public boolean validatePasswordComplexity(String password) {
        if (password.length() < 8) return false;
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false;
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false;
        return Pattern.compile("[^A-Za-z0-9]").matcher(password).find();
    }

    // Check if cell phone number is correctly formatted
    public boolean validatePhoneNumberFormat(String cellNumber) {
        String pattern = "^\\+\\d{1,3}\\d{7,10}$";
        return Pattern.matches(pattern, cellNumber);
    }

    // Handle user registration process
    public String registerNewUser(Scanner inputScanner) {
        
        //User first name
        System.out.print("Enter your first name: ");
        this.firstName = inputScanner.nextLine();
        
        //User last name
        System.out.print("Enter your last name: ");
        this.lastName = inputScanner.nextLine();

        // Username validation
        System.out.print("Enter username (must contain _ and be ≤5 characters): ");
        String username = inputScanner.nextLine();
        if (!validateUsernameFormat(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        this.userName = username;

        // Password validation
        System.out.print("Enter password (≥8 chars, with capital, number, special char): ");
        String password = inputScanner.nextLine();
        if (!validatePasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        this.password = password;

        // Cell number validation
        System.out.print("Enter cell phone number (with international code, e.g., ‪+27831234567‬): ");
        String cellNumber = inputScanner.nextLine();
        if (!validatePhoneNumberFormat(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.cellNumber = cellNumber;

        return "Registration successful!";
    }

    // Verify login credentials
    public boolean authenticateUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.userName) && enteredPassword.equals(this.password);
    }

    // Return appropriate login status message
    public String getLoginStatusMessage(boolean isSuccessful) {
        if (isSuccessful) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
    
    //Part 2 Methods
    public boolean checkMessageID(String messageID){
         if(messageID.length()<=10){
             return true;
         }
         return false;
     }
       public String generateRandomId() {
        Random random = new Random();

        // Generate a number between 1000000000 and 9999999999 (inclusive)
        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    } //Verify Recipient Phone is valid
     public int checkRecipientCell (String cellNumber){
         String pattern = "^\\+\\d{1,3}\\d{7,10}$";
        if(Pattern.matches(pattern, cellNumber)){
            return 1;
        }
        return 0;
     } //Allow user to send/delete/save message
      public String sentMessage (Scanner inputScanner){
         System.out.print("Send, delete or Save Message? \n");
         String userChoose = inputScanner.nextLine();
         if(userChoose.compareToIgnoreCase("send")==0){
             return "Send";
         }
         else if (userChoose.compareToIgnoreCase("Save")==0){
             return "Save";
         }
         else{
             return "Delete";
     }
     }
      
      //return total number of messages sent
      public int returnTotalMessage(int number){
    return number;}
      //Print message
      public String printMessage(String message, String hash, String cellNumberR, String send, String messageID, int number){
      return "Final Message " + "\n" +
              "ID: " + messageID + "\n" +
             "Hash: " + hash + "\n" 
              + "Recipient: " + cellNumberR + "\n" +
              "Message Number: " + number + "\n"+
              "Status: " + send + "\n" +
              "Message: " + message + "\n";  
                     
     }
      //First and LAst Words
      public String getFirstWord(String message) {
        if (message == null || message.isBlank()) return "";
        String[] words = message.trim().split("\\s+");
        return words[0];
    }

    public String getLastWord(String message) {
        if (message == null || message.isBlank()) return "";
        String[] words = message.trim().split("\\s+");
        return words[words.length - 1];
    }
}

