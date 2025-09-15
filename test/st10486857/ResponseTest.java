/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package st10486857;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author OENTSENG M
 */
public class ResponseTest {
    Response response = new Response();
    public ResponseTest() {
    }

    @Test
    public void testReturnResponse() {
        
        String expected = "I see you there";
        String actual = response.returnResponse();
        
        assertEquals(expected,actual);
    }

    @Test
    public void testCalculateNumResponses() {
    }
    
    
}
