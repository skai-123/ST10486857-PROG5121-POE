
package ChatApp;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Login {
    public String userName;
    public String password;
    private String cellNumber;
    public String firstName;
    public String lastName;
    
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
}


    

