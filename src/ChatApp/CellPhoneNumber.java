
package ChatApp;

import java.util.regex.Pattern;


public class CellPhoneNumber {
    public boolean validatePhoneNumberFormat(String cellNumber) {
        String pattern = "^\\+\\d{1,3}\\d{7,10}$";
        return Pattern.matches(pattern, cellNumber);
    }
    
}
