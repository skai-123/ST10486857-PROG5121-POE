/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package st10486857;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author OENTSENG M
 */
public class ST10486857Test {
    
    public ST10486857Test() {
    }

    @Test
    public void testMain() {
        // Test that main method runs without exceptions
        assertDoesNotThrow(() -> ST10486857.main(new String[]{}));
    }
    
    @Test
    public void testCheckUsername() {
        ST10486857 app = new ST10486857();
        
        // Valid usernames (<=5 characters and contains underscore)
        assertTrue(app.checkUsername("user_"));
        assertTrue(app.checkUsername("a_b"));
        assertTrue(app.checkUsername("_test"));
        
        // Invalid usernames
        assertFalse(app.checkUsername("username")); // Too long
        assertFalse(app.checkUsername("test")); // No underscore
        assertFalse(app.checkUsername("")); // Empty string
        assertFalse(app.checkUsername("long_username")); // Too long with underscore
    }
    
    @Test
    public void testCheckPasswordComplexity() {
        ST10486857 app = new ST10486857();
        
        // Valid passwords (>=8 chars, at least 1 uppercase, 1 number, 1 special char)
        assertTrue(app.checkPasswordComplexity("Password1!"));
        assertTrue(app.checkPasswordComplexity("Test123@"));
        assertTrue(app.checkPasswordComplexity("ABCdef123#"));
        
        // Invalid passwords
        assertFalse(app.checkPasswordComplexity("short")); // Too short
        assertFalse(app.checkPasswordComplexity("nouppercase1!")); // No uppercase
        assertFalse(app.checkPasswordComplexity("NONUMBERS!")); // No numbers
        assertFalse(app.checkPasswordComplexity("NoSpecial123")); // No special characters
        assertFalse(app.checkPasswordComplexity("")); // Empty string
    }
    
    @Test
    public void testCheckCellPhoneNumber() {
        ST10486857 app = new ST10486857();
        
        // Valid phone numbers
        assertTrue(app.checkCellPhoneNumber("+27123456789")); // South Africa
        assertTrue(app.checkCellPhoneNumber("+11234567890")); // USA
        assertTrue(app.checkCellPhoneNumber("+441234567890")); // UK
        
        // Invalid phone numbers
        assertFalse(app.checkCellPhoneNumber("27123456789")); // No plus
        assertFalse(app.checkCellPhoneNumber("+123")); // Too short
        assertFalse(app.checkCellPhoneNumber("+123456789012345")); // Too long
        assertFalse(app.checkCellPhoneNumber("+abc1234567")); // Contains letters
        assertFalse(app.checkCellPhoneNumber("")); // Empty string
    }
    
    @Test
    public void testLoginUser() {
        ST10486857 app = new ST10486857();
        
        // Since the actual username and password are not set in the class,
        // we need to test the logic structure
        // This test verifies that the method returns the expected boolean
        
        // The method compares with internal fields that are null by default
        // So any login attempt should return false
        assertFalse(app.loginUser("test", "password"));
        assertFalse(app.loginUser("", ""));
        assertFalse(app.loginUser("user_", "Password1!"));
    }
    
    @Test
    public void testReturnLoginStatus() {
        ST10486857 app = new ST10486857();
        
        // Test successful login message structure
        String successMessage = app.returnLoginStatus(true);
        assertTrue(successMessage.contains("Welcome"));
        assertTrue(successMessage.contains("it is great to see you again"));
        
        // Test failed login message
        String failMessage = app.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", failMessage);
        
        // Verify messages are different
        assertNotEquals(successMessage, failMessage);
    }
    
    @Test
    public void testClassInstantiation() {
        // Test that the class can be instantiated without errors
        ST10486857 app = new ST10486857();
        assertNotNull(app);
        
        // Test that the main method can be called (though it shows GUI)
        assertDoesNotThrow(() -> ST10486857.main(new String[]{}));
    }
    
    @Test
    public void testPasswordComplexityEdgeCases() {
        ST10486857 app = new ST10486857();
        
        // Edge case: exactly 8 characters with all requirements
        assertTrue(app.checkPasswordComplexity("Pass1!@#"));
        
        // Edge case: 7 characters (too short)
        assertFalse(app.checkPasswordComplexity("Pass1!@"));
        
        // Edge case: missing uppercase
        assertFalse(app.checkPasswordComplexity("password1!"));
        
        // Edge case: missing number
        assertFalse(app.checkPasswordComplexity("PASSWORD!"));
        
        // Edge case: missing special character
        assertFalse(app.checkPasswordComplexity("Password1"));
    }
    
    @Test
    public void testUsernameEdgeCases() {
        ST10486857 app = new ST10486857();
        
        // Edge case: exactly 5 characters with underscore
        assertTrue(app.checkUsername("abc_d"));
        
        // Edge case: 6 characters (too long)
        assertFalse(app.checkUsername("abc_de"));
        
        // Edge case: underscore at start
        assertTrue(app.checkUsername("_abcd"));
        
        // Edge case: underscore at end
        assertTrue(app.checkUsername("abcd_"));
        
        // Edge case: only underscore
        assertTrue(app.checkUsername("_"));
    }
}