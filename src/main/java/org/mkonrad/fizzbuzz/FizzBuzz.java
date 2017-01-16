package org.mkonrad.fizzbuzz;

import java.io.PrintStream;

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
		for (int i = 1; i <= numberOfRounds; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					printStream.println("FizzBuzz");
				} else {
					printStream.println("Fizz");
				}
			} else if (i % 5 == 0) {
        printStream.println("Buzz");
			} else {
				printStream.println(String.valueOf(i));
			}
		}
	}

	public static void main(String[] args) {
		new FizzBuzz(System.out).run(100);
	}
}
