package com.thehammer.numerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public void testAddition() throws InvalidCharacterException, InvalidSequenceException {
		RomanNumeralConversion numeralsApp = new RomanNumeralConversion("II");
		assertEquals(2, numeralsApp.calculateNumeral());
		
		numeralsApp = new RomanNumeralConversion("VI");
		assertEquals(6, numeralsApp.calculateNumeral());
		
		numeralsApp = new RomanNumeralConversion("VII");
		assertEquals(7, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XV");
		assertEquals(15, numeralsApp.calculateNumeral());
		
		numeralsApp = new RomanNumeralConversion("LXVIII");
		assertEquals(68, numeralsApp.calculateNumeral());

	}

	public void testSubtraction() throws InvalidCharacterException, InvalidSequenceException {
		RomanNumeralConversion numeralsApp = new RomanNumeralConversion("IV");
		assertEquals(4, numeralsApp.calculateNumeral());
		
		numeralsApp = new RomanNumeralConversion("IX");
		assertEquals(9, numeralsApp.calculateNumeral());
		
		numeralsApp = new RomanNumeralConversion("XL");
		assertEquals(40, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XIV");
		assertEquals(14, numeralsApp.calculateNumeral());
		
		numeralsApp = new RomanNumeralConversion("CXLIV");
		assertEquals(144, numeralsApp.calculateNumeral());

	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws InvalidCharacterException
	 * @throws InvalidSequenceException 
	 */
	public void testNumeralChars() throws InvalidCharacterException, InvalidSequenceException {
		RomanNumeralConversion numeralsApp = new RomanNumeralConversion("I");
		assertEquals(1, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("V");
		assertEquals(5, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("X");
		assertEquals(10, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("L");
		assertEquals(50, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("C");
		assertEquals(100, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("D");
		assertEquals(500, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("M");
		assertEquals(1000, numeralsApp.calculateNumeral());

		final RomanNumeralConversion numeralsAppFinal = new RomanNumeralConversion("Z");
	    assertThrows(InvalidCharacterException.class, () -> {
	    	numeralsAppFinal.calculateNumeral();
    	});
		
	}
	
	public void testBadNumeral() throws InvalidCharacterException, InvalidSequenceException {
		final RomanNumeralConversion numeralsApp = new RomanNumeralConversion("XIVX");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});
	}
}
