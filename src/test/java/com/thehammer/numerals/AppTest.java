package com.thehammer.numerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
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

	@Test
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

	@Test
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
	
	@Test
	public void testBadNumeral() throws InvalidCharacterException, InvalidSequenceException {
		final RomanNumeralConversion numeralsApp = new RomanNumeralConversion();
		numeralsApp.setNumeralInput("XIVX");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("IXX");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});
	}
}
