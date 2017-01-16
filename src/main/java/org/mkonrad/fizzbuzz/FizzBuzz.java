package org.mkonrad.fizzbuzz;

import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * @author Markus Konrad
 */
public final class FizzBuzz {

	private final PrintStream printStream;

	public FizzBuzz(PrintStream printStream) {
		this.printStream = printStream;
	}

	public final void run(int numberOfRounds){
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
