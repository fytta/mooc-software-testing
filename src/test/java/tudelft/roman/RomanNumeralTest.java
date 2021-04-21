package tudelft.roman;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {


    @Test
    public void singleNumber() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }
    
    @Test
    public void numberIsNull() {
        RomanNumeral roman = new RomanNumeral();
        Exception exception = Assertions.assertThrows(InvalidParameterException.class, 
        											  () -> {
        												  roman.convert(null);
        											  });
        
        String expectedMsg = "Parameter must be a roman number string.";
        String exceptionMsg = exception.getMessage();
        Assertions.assertTrue(exceptionMsg.contains(expectedMsg));
    }
}
