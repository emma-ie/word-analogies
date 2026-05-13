package ie.atu.sw;

/**
 * Utility class that performs vector arithmetic operations and similarity
 * calculations on word embedding vectors.
 */
public class VectorArithmetic {

	/**
	 * Adds two vectors by element.
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return resulting vector after addition
	 */
	public static double[] add(double[] a, double[] b) {
		// Time complexity: O(n)
		// Explanation: Loops through each element in both vectors once

		// Create a new array of doubles to store result of arithmetic in
		double[] result = new double[a.length];

		// Add the same index of both arrays and store it in the result array
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] + b[i];
		}

		return result;
	}

	/**
	 * Subtracts two vectors by element.
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return resulting vector after subtraction
	 */
	public static double[] subtract(double[] a, double[] b) {
		// Time complexity: O(n)
		// Explanation: Loops through each element in both vectors once
		double[] result = new double[a.length];

		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] - b[i];
		}

		return result;
	}

	/**
	 * Multiplies two vectors by element.
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return resulting vector after multiplication
	 */
	public static double[] multiply(double[] a, double[] b) {
		// Time complexity: O(n)
		// Explanation: Loops through each element in both vectors once

		double[] result = new double[a.length];

		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] * b[i];
		}

		return result;
	}

	/**
	 * Divides two vectors by element.
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return resulting vector after multiplication
	 */
	public static double[] divide(double[] a, double[] b) {
		// Time complexity: O(n)
		// Explanation: Loops through each element in both vectors once

		double[] result = new double[a.length];

		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] / b[i];
		}

		return result;
	}

	/**
	 * Computes cosine similarity between two vectors.
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return similarity score between 0 and 1
	 * @throws IllegalArgumentException if vectors are null, empty or different
	 *                                  lengths
	 */
	public static double cosineSimilarity(double[] a, double[] b) {
		// Cosine similarity calculation method from:
		// https://www.baeldung.com/java-cosine-similarity-two-vectors
		// Time complexity: O(n)
		// Explanation: Loops through each element in both vectors once

		if (a == null || b == null || a.length != b.length || a.length == 0) {
			throw new IllegalArgumentException("Vectors must be non-null, non-empty, and of the same length.");
		}
		double dotProduct = 0.0;
		double magnitudeA = 0.0;
		double magnitudeB = 0.0;
		for (int i = 0; i < a.length; i++) {
			dotProduct += a[i] * b[i];
			magnitudeA += a[i] * a[i];
			magnitudeB += b[i] * b[i];
		}
		double finalMagnitudeA = Math.sqrt(magnitudeA);
		double finalMagnitudeB = Math.sqrt(magnitudeB);
		if (finalMagnitudeA == 0.0 || finalMagnitudeB == 0.0) {
			return 0.0;
		}
		return dotProduct / (finalMagnitudeA * finalMagnitudeB);
	}

	/**
	 * Computes euclidean distance between two vectors.
	 * 
	 * @param a first vector
	 * @param b second vector
	 * @return euclidean distance between vectors
	 */
	public static double euclideanDistance(double[] a, double[] b) {
		// Calculate euclidean distance between two vectors
		// sqrt(sum of squared differences between vector elements)
		// Time complexity: O(n)
		// Explanation: Method loops through each element of the input vectors once

		double sum = 0.0;

		for (int i = 0; i < a.length; i++) {
			double diff = a[i] - b[i];
			sum += diff * diff;
		}

		return Math.sqrt(sum);
	}
}
