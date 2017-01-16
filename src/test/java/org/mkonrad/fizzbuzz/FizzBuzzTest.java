package org.mkonrad.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

/**
 * @author Markus Konrad
 */
public class FizzBuzzTest {

  public static final String[] EXPECTED_OUTPUT = {
    "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
    "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
    "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
    "31", "32", "Fizz", "34", "Buzz", "Fizz", "37", "38", "Fizz", "Buzz",
    "41", "Fizz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz",
    "Fizz", "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59", "FizzBuzz",
    "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz",
    "71", "Fizz", "73", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz",
    "Fizz", "82", "83", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
    "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz"
  };

	private PrintStream printStream;
	private FizzBuzz fizzBuzz;

	@Before
	public void setUp() throws Exception {
		printStream = mock(PrintStream.class);
		fizzBuzz = new FizzBuzz(printStream);
	}

	@Test
	public void run_numberOfRoundsIsNegative_printHint() throws Exception {
		// given
		int numberOfRounds = -1;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		verify(printStream).println("Please specify a positive value for the parameter \"numberOfRounds\"");
		verifyNoMoreInteractions(printStream);
	}

	@Test
	public void run_numberOfRoundsIsZero_printHint() throws Exception {
		// given
		int numberOfRounds = 0;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		verify(printStream).println("Please specify a positive value for the parameter \"numberOfRounds\"");
		verifyNoMoreInteractions(printStream);
	}

	@Test
	public void run_oneHundredRounds() throws Exception {
		// given
		int numberOfRounds = 100;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
    InOrder inOrder = inOrder(printStream);
    Stream.of(EXPECTED_OUTPUT).limit(numberOfRounds).forEach(x -> inOrder.verify(printStream).println(x));
    verify(printStream, times(numberOfRounds)).println(anyString());
	}
}
