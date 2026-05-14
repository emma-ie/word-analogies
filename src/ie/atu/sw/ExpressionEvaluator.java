package ie.atu.sw;

import java.util.*;

/**
 * Builds a result vector from a user-exntered expression using word embeddings
 * and vector arithmetic operations.
 */
public class ExpressionEvaluator {

	/**
	 * Builds a new vector based on a sequence of user-entered words and operators. Input words are normalised and validated before being processed.
	 * 
	 * @param scanner    used to read user input
	 * @param embeddings map of words and their vector representations
	 * @param usedWords  list of words used in the expression (excluded from
	 *                   results)
	 * @return the final computed vector, or null if the first word is not found
	 */
	// Time complexity: O(n)
	// Performs vector operations based on user input
	public double[] buildVector(Scanner scanner, Map<String, double[]> embeddings, List<String> usedWords) {

		// Get the first word from the user
		System.out.println(ConsoleColour.WHITE);
		System.out.println("Enter first word: ");
		String wordFirst = scanner.nextLine().trim().toLowerCase();
		usedWords.add(wordFirst);

		// Get the vector for the first word
		double[] resultVector = embeddings.get(wordFirst);

		// If word is not in embeddings, stop
		if (resultVector == null) {
			System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
			System.out.println("Word not found.");
			return null;
		}

		// Keep asking for user input until user finishes
		while (true) {

			System.out.println(ConsoleColour.WHITE);
			System.out.println("Enter operator (+ - * /) or press Enter to finish: ");
			String operator = scanner.nextLine();

			// Empty input ends the loop
			if (operator.isEmpty())
				break;
			
			// Ensures only valid operators are accepted
			if (!operator.equals("+") &&
				!operator.equals("-") &&
				!operator.equals("*") &&
				!operator.equals("/")) {
				System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
				System.out.println("Invalid operator.");
				continue;
			}
				
			// Get the next word from the user
			System.out.println(ConsoleColour.WHITE);
			System.out.println("Enter next word: ");
			String nextWord = scanner.nextLine().trim().toLowerCase();
			
			// Get vector for the next word
			double[] nextVector = embeddings.get(nextWord);

			// If word is not in embeddings, skip and continue loop
			if (nextVector == null) {
				System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
				System.out.println("Word not found.");
				continue;
			}
			
			usedWords.add(nextWord);

			// Apply the selected operation to update the result vector
			switch (operator) {
			case "+" -> resultVector = VectorArithmetic.add(resultVector, nextVector);
			case "-" -> resultVector = VectorArithmetic.subtract(resultVector, nextVector);
			case "*" -> resultVector = VectorArithmetic.multiply(resultVector, nextVector);
			case "/" -> resultVector = VectorArithmetic.divide(resultVector, nextVector);
			}
		}

		// Return final vector
		return resultVector;
	}

}
