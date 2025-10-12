/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ChatAPP;


import java.util.Random;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author OENTSENG M
 */
public class MessageTest {
    MessageTest message = new MessageTest();
    
    public MessageTest() {
                 
        //TestData One
        String cellNumber1 = "+2718693002";
        String message1 = "Hi Mike, can you join us for Dinner Tonight";
         String choice1 = "Send";
        
        //TestData Two
        String cellNumber2 = "0857595889";
        String message2 = "Hi Keagan, Did you recieve payment";
        String choice2 = "Delete";
        
    }
    
   
    @Test
   //Test ID generator
    public void testGenerateRandomId() {
        String ID = message.generateRandomId();
        boolean expected = true;
        boolean test = ID.length()==10;
        assertEquals(expected,  test );
    }

        @Test
  //Test check message ID method
    public void testCheckMessageID() {
        String ID = message.generateRandomId();
        boolean expected = true;
        boolean test = message.checkMessageID(ID);
        assertEquals(expected,  test );
    }

    @Test
    public void testCheckRecipientCell1() {
        //Test cellNumber 1
        int expected = 1;
        int actual = message.checkRecipientCell("+2718693002");
        assertEquals (expected, actual);
        
    }
    public void testCheckRecipientCell2() {
        //Test cellNumber 2
        int expected = 0;
        int actual = message.checkRecipientCell("0857595889");
        assertEquals (expected, actual);
    }
    @Test
    public void testSentMessage1() {
        String expected = "Send";
        String actual= message.sentMessage(expected);
        assertEquals(expected, actual);
    }
    public void testSentMessage2() {
        String expected = "Save";
        String actual= message.sentMessage(expected);
        assertEquals(expected, actual);
    }
    public void testSentMessage3() {
        String expected = "Delete";
        String actual= message.sentMessage("expected");
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnTotalMessage() {
        int expected = 2;
        int actual = message.returnTotalMessage(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintMessage() {
        String cellNumber1 = "+2718693002";
        String message1 = "Hi Mike, can you join us for Dinner Tonight";
         String choice1 = "Send";
        String messageID = message.generateRandomId();
        int number = 1;
         String hashCreate="";
                       int add =0;
                        while(add<=1){
                            hashCreate = hashCreate + messageID.charAt(add);
                            add+=1;
                        }
        String hash = hashCreate + ":" + number + ":" + "HI" + "TONIGHT";
        
        String expected ="Final Message " + "\n" +
              "ID: " + messageID + "\n" +
             "Hash: " + hash + "\n" 
              + "Recipient: " + cellNumber1 + "\n" +
              "Message Number: " + number + "\n"+
              "Status: " + choice1 + "\n" +
              "Message: " + message1 + "\n";  
        String actual = message.printMessage(message1,  hash, cellNumber1,  choice1, messageID, number);
        assertEquals(expected, actual);
                       
        
    }
    
    //Actual Method
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
    }
     public int checkRecipientCell (String cellNumber){
         String pattern = "^\\+\\d{1,3}\\d{7,10}$";
        if(Pattern.matches(pattern, cellNumber)){
            return 1;
        }
        return 0;
     }
     
     
     public String sentMessage (String userChoose){
         System.out.print("Send, delete or Save Message?");
        
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
      return  "Final Message " + "\n" +
              "ID: " + messageID + "\n" +
             "Hash: " + hash + "\n" 
              + "Recipient: " + cellNumberR + "\n" +
              "Message Number: " + number + "\n"+
              "Status: " + send + "\n" +
              "Message: " + message + "\n";  
                     
     }
}
