package ie.atu.sw;

public class VectorArithmetic {
	public static double[] add(double[] a, double[] b) {
		// Create a new array of doubles to store result of arithmetic in
		double[] result = new double[a.length];
		
		// Add the same index of both arrays and store it in the result array 
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] + b[i];
		}

		return result;
	}

	public static double[] subtract(double[] a, double[] b) {
		double[] result = new double[a.length];

		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] - b[i];
		}

		return result;
	}

	// Cosine similarity calculation method from:
	// https://www.baeldung.com/java-cosine-similarity-two-vectors
	public static double calculateCosineSimilarity(double[] a, double[] b) {
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
}
