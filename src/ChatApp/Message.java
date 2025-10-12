/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatApp;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Random;

/**
 *
 * @author OENTSENG M
 */
public class Message {
    public String message;
     public String messageID;
     private String recipient;
     public String action;
     public String hash;
     public int messageNum;
     
     public boolean checkMessageID(String messageID){
         if(messageID.length()<=10){
             return true;
         }
         return false;
     }
  
    public static String generateRandomId() {
        Random random = new Random();

        // Generate a number between 1000000000 and 9999999999 (inclusive)
        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }
     public int checkRecipientCell (String cellNumber){
         String pattern = "^\\+\\d{1,3}\\d{7,10}$";
        if(Pattern.matches(pattern, cellNumber)){
            return 1;
        }
        return 0;
     }
     
     
     public String sentMessage (Scanner inputScanner){
         System.out.print("Send, delete or Save Message?");
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
     
     public int returnTotalMessage(int number){
    return number;
}
     public String printMessage(String message, String hash, String cellNumberR, String send, String messageID, int number){
      return  "Review Message " + "\n" +
              "ID: " + messageID + "\n" +
             "Hash: " + hash + "\n" 
              + "Recipient: " + cellNumberR + "\n" +
              "Message Number: " + number + "\n"+
              "Status: " + send + "\n" +
              "Message: " + message + "\n";  
                     
     }
     
}
