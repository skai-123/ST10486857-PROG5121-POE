package ChatAPP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ChatApp.Chatapp;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ChatAppTest {

    private Chatapp authSystem;

    @BeforeEach
    public void setUp() {
        authSystem = new Chatapp();
    }

    @Test
    public void testValidateUsernameFormat() {
        assertTrue(authSystem.validateUsernameFormat("abc_")); // valid
        assertFalse(authSystem.validateUsernameFormat("abcdef")); // too long
        assertFalse(authSystem.validateUsernameFormat("user")); // no underscore
    }

    @Test
    public void testValidatePasswordComplexity() {
        assertTrue(authSystem.validatePasswordComplexity("Strong1@")); // valid
        assertFalse(authSystem.validatePasswordComplexity("weakpass")); // no uppercase, digit, special
        assertFalse(authSystem.validatePasswordComplexity("NoSpecial1")); // missing special
        assertFalse(authSystem.validatePasswordComplexity("short1@")); // too short
    }

    @Test
    public void testValidatePhoneNumberFormat() {
        assertTrue(authSystem.validatePhoneNumberFormat("+27831234567")); // valid
        assertFalse(authSystem.validatePhoneNumberFormat("0821234567")); // missing +
        assertFalse(authSystem.validatePhoneNumberFormat("+27AB12345")); // contains letters
    }

    @Test
    public void testAuthenticateUser() {
        // Set up values directly
        authSystem.userName = "abc_";
        authSystem.password = "Strong1@";

        assertTrue(authSystem.authenticateUser("abc_", "Strong1@")); // correct
        assertFalse(authSystem.authenticateUser("abc_", "WrongPass")); // wrong password
        assertFalse(authSystem.authenticateUser("wrong_", "Strong1@")); // wrong username
    }

    @Test
    public void testGetLoginStatusMessage() {
        authSystem.firstName = "Ohanah";
        authSystem.lastName = "";

        assertEquals("Welcome John, Doe it is great to see you again.",
                authSystem.getLoginStatusMessage(true));

        assertEquals("Username or password incorrect, please try again.",
                authSystem.getLoginStatusMessage(false));
    }
}
