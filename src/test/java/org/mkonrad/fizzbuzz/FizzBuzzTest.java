package org.mkonrad.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * @author Markus Konrad
 */
public class FizzBuzzTest {

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
	public void run_numberOfRoundsIs1_print_1() throws Exception {
		// given
		int numberOfRounds = 1;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		verify(printStream).println("1");
	}

	@Test
	public void run_numberOfRoundsIs3_print_1_2_Fizz() throws Exception {
		// given
		int numberOfRounds = 3;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		InOrder inOrder = inOrder(printStream);
		inOrder.verify(printStream).println("1");
		inOrder.verify(printStream).println("2");
		inOrder.verify(printStream).println("Fizz");
	}

	@Test
	public void run_numberOfRoundsIs5_print_1_2_Fizz_4_Buzz() throws Exception {
		// given
		int numberOfRounds = 5;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		InOrder inOrder = inOrder(printStream);
		inOrder.verify(printStream).println("1");
		inOrder.verify(printStream).println("2");
		inOrder.verify(printStream).println("Fizz");
		inOrder.verify(printStream).println("4");
		inOrder.verify(printStream).println("Buzz");
	}

	@Test
	public void run_numberOfRoundsIs15_print_1_2_Fizz_4_Buzz_Fizz_7_8_Fizz_Buzz_11_Fizz_13_14_FizzBuzz() throws Exception {
		// given
		int numberOfRounds = 15;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		InOrder inOrder = inOrder(printStream);
		inOrder.verify(printStream).println("1");
		inOrder.verify(printStream).println("2");
		inOrder.verify(printStream).println("Fizz"); // 3
		inOrder.verify(printStream).println("4");
		inOrder.verify(printStream).println("Buzz"); // 5
		inOrder.verify(printStream).println("Fizz"); // 6
		inOrder.verify(printStream).println("7"); // 7
		inOrder.verify(printStream).println("8"); // 8
		inOrder.verify(printStream).println("Fizz"); // 9
		inOrder.verify(printStream).println("Buzz"); // 10
		inOrder.verify(printStream).println("11"); // 11
		inOrder.verify(printStream).println("Fizz"); // 12
		inOrder.verify(printStream).println("13"); // 13
		inOrder.verify(printStream).println("14"); // 14
		inOrder.verify(printStream).println("FizzBuzz"); // 15
	}

	@Test
	public void run_numberOfRoundsIs100_print100Times() throws Exception {
		// given
		int numberOfRounds = 100;
		// when
		fizzBuzz.run(numberOfRounds);
		// then
		verify(printStream, times(numberOfRounds)).println(anyString());
	}
}
