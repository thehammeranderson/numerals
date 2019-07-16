package com.thehammer.numerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

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

		numeralsApp = new RomanNumeralConversion("IL");
		assertEquals(49, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("IC");
		assertEquals(99, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("ID");
		assertEquals(499, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("IM");
		assertEquals(999, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XL");
		assertEquals(40, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XC");
		assertEquals(90, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XD");
		assertEquals(490, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XM");
		assertEquals(990, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("CD");
		assertEquals(400, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("CM");
		assertEquals(900, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("XIV");
		assertEquals(14, numeralsApp.calculateNumeral());

		numeralsApp = new RomanNumeralConversion("MCDXCIV");
		assertEquals(1494, numeralsApp.calculateNumeral());

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

	}

	@Test
	public void testBadNumeralChar() throws InvalidCharacterException, InvalidSequenceException {
		final RomanNumeralConversion numeralsApp = new RomanNumeralConversion();
		numeralsApp.setNumeralInput("abc");
		assertThrows(InvalidCharacterException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("Z");
		assertThrows(InvalidCharacterException.class, () -> {
			numeralsApp.calculateNumeral();
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

		numeralsApp.setNumeralInput("XVIC");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("VXL");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("VXV");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("IVX");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("LC");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("Z");
		assertThrows(InvalidCharacterException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("IIIV");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("IXXC");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("IIIII");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("VV");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("XXXXX");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("LL");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("CCCCC");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("DD");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

		numeralsApp.setNumeralInput("IXX");
		assertThrows(InvalidSequenceException.class, () -> {
			numeralsApp.calculateNumeral();
		});

	}
}
