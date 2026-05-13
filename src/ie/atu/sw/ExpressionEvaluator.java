package ie.atu.sw;

import java.util.*;

public class ExpressionEvaluator {

	// Builds a new vector based on the user input (words + operations)
	// Time complexity: O(n)
	// Performs vector operations based on user input
	public double[] buildVector(Scanner scanner, Map<String, double[]> embeddings, List<String> usedWords) {

		// Get the first word from the user
		System.out.println("Enter first word: ");
		String wordFirst = scanner.nextLine();
		usedWords.add(wordFirst);

		// Get the vector for the first word
		double[] resultVector = embeddings.get(wordFirst);

		// If word is not in embeddings, stop
		if (resultVector == null) {
			System.out.println("Word not found.");
			return null;
		}

		// Keep asking for user input until user finishes
		while (true) {

			System.out.println("Enter operator (+ - * /) or press Enter to finish: ");
			String operator = scanner.nextLine();

			// Empty input ends the loop
			if (operator.isEmpty())
				break;

			// Get the next word from the user
			System.out.println("Enter next word: ");
			String nextWord = scanner.nextLine();
			usedWords.add(nextWord);

			// Get vector for the next word
			double[] nextVector = embeddings.get(nextWord);

			// If word is not in embeddings, skip and continue loop
			if (nextVector == null) {
				System.out.println("Word not found.");
				continue;
			}

			// Apply the selected operation to update the result vector
			switch (operator) {
			case "+" -> resultVector = VectorArithmetic.add(resultVector, nextVector);
			case "-" -> resultVector = VectorArithmetic.subtract(resultVector, nextVector);
			case "*" -> resultVector = VectorArithmetic.multiply(resultVector, nextVector);
			case "/" -> resultVector = VectorArithmetic.divide(resultVector, nextVector);
			default -> {
				System.out.println("Invalid operator.");
				continue;
			}
			}
		}

		// Return final vector
		return resultVector;
	}

}
