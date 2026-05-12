package ie.atu.sw;

import java.util.*;

public class ExpressionEvaluator {

	public double[] buildVector(Scanner scanner, Map<String, double[]> embeddings) {

		double[] result = null;

		while (true) {

			System.out.println("Enter word (or blank to finish): ");
			String word = scanner.nextLine();

			if (word.isEmpty())
				break;

			double[] vector = embeddings.get(word);

			if (vector == null) {
				System.out.println("Word not found: " + word);
				continue;
			}

			if (result == null) {
				result = vector;
				continue;
			}

			System.out.println("Enter operator (+ - * /): ");
			String oper = scanner.nextLine();

			switch (oper) {
			case "+" -> result = VectorArithmetic.add(result, vector);
			case "-" -> result = VectorArithmetic.subtract(result, vector);
			case "*" -> result = VectorArithmetic.multiply(result, vector);
			case "/" -> result = VectorArithmetic.divide(result, vector);
			}
		}

		return result;
	}

}
