package org.mkonrad.fizzbuzz;

import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * Simple implementation of the Fizz Buzz game. See the README.md or the
 * <a href="https://en.wikipedia.org/wiki/Fizz_buzz">Wikipedia page</a> on Fizz Buzz for more details.
 *
 * @author Markus Konrad
 */
public final class FizzBuzz {

	private final PrintStream printStream;

	public FizzBuzz(PrintStream printStream) {
		this.printStream = printStream;
	}

  /**
   * Start a new game with the given maximum number of rounds.
   *
   * @param numberOfRounds the number of rounds the game lasts
   */
	public final void run(int numberOfRounds) {
		if (numberOfRounds < 1) {
			printStream.println("Please specify a positive value for the parameter \"numberOfRounds\"");
			return;
		}
    IntStream.range(1, numberOfRounds + 1)
      .mapToObj(i ->	{
        if (i % 3 == 0) {
          if (i % 5 == 0) {
            return "FizzBuzz";
          }
          return "Fizz";
        }
        if (i % 5 == 0) {
          return "Buzz";
        }
        return String.valueOf(i);
      })
      .forEach(printStream::println);
	}

	public static void main(String[] args) {
		new FizzBuzz(System.out).run(100);
	}
}
