package ie.atu.sw;

import java.util.*;

public class ExpressionEvaluator {

	public double[] buildVector(Scanner scanner, Map<String, double[]> embeddings) {

		System.out.println("Enter first word: ");
		String wordFirst = scanner.nextLine();
		
		double[] resultVector = embeddings.get(wordFirst);
		
		if (resultVector == null) {
			System.out.println("Word not found.");
			return null;
		}

		while (true) {

			System.out.println("Enter operator (+ - * /) or press Enter to finish: ");
			String operator = scanner.nextLine();

			if (operator.isEmpty())
				break;

			System.out.println("Enter next word: ");
			String wordSecond = scanner.nextLine();
			
			double[] nextVector = embeddings.get(wordSecond);

			if (nextVector == null) {
				System.out.println("Word not found.");
				continue;
			}

			switch (operator) {
			case "+" -> resultVector = VectorArithmetic.add(resultVector, nextVector);
			case "-" -> resultVector = VectorArithmetic.subtract(resultVector, nextVector);
			case "*" -> resultVector = VectorArithmetic.multiply(resultVector, nextVector);
			case "/" -> resultVector = VectorArithmetic.divide(resultVector, nextVector);
			default -> System.out.println("Invalid operator.");
			}
		}

		return resultVector;
	}

}
