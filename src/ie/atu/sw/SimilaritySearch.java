package ie.atu.sw;

import java.util.*;

/**
 * Performs similarity searches on word embeddings using cosine similarity or
 * Euclidean distance.
 */
public class SimilaritySearch {

	private Map<String, double[]> embeddings;

	/**
	 * Creates a new SimilaritySearch object.
	 * 
	 * @param embeddings map containing word embeddings.
	 */
	// Time complexity: O(1)
	// Explanation: Initialises a new SimilaritySearch object and sets the variable
	// - no loops
	public SimilaritySearch(Map<String, double[]> embeddings) {
		this.embeddings = embeddings;
	}

	/**
	 * Finds the most similar words to a target vector.
	 * 
	 * @param target    the target vector to compare against
	 * @param topN      the number of results to return
	 * @param usedWords list of words already used in the vector operation
	 * @param method    similarity method to use
	 * @return list of the most similar words and their scores
	 */
	// Time complexity: O(n log n)
	// Explanation: Final sorting step is O(n log n) which is worse than the big-O
	// of the loop
	public List<SearchResults> findSimilarWords(double[] target, int topN, List<String> usedWords, int method) {

		// Thread safe list to store results
		List<SearchResults> results = Collections.synchronizedList(new ArrayList<>());

		// Store threads so we can wait for them
		List<Thread> threads = new ArrayList<>();

		// Loop through all words stored in the embeddings map
		for (String word : embeddings.keySet()) {

			// Exclude the user-inputted words
			if (usedWords.contains(word)) {
				continue;
			}

			// Get the vector for the current word
			double[] vector = embeddings.get(word);

			// Create a virtual thread
			Thread workerThread = Thread.startVirtualThread(() -> {

				double similarityScore;

				if (method == 1) {

					// Calculate the cosine similarity between target vector and current word vector
					similarityScore = VectorArithmetic.cosineSimilarity(target, vector);

				} else {
					// Calculate the euclidean distance between target vector and current word
					// vector
					similarityScore = VectorArithmetic.euclideanDistance(target, vector);
				}

				// Store the result
				results.add(new SearchResults(word, similarityScore));
			});

			threads.add(workerThread);
		}

		// Wait for all threads to finish
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Sort the results based on similarity score
		if (method == 1) {
			// Cosine similarity - higher = better
			results.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));
		} else {
			// Euclidean distance - lower = better
			results.sort((a, b) -> Double.compare(a.getScore(), b.getScore()));
		}

		// Return the top N most similar words
		return results.subList(0, topN);
	}
}