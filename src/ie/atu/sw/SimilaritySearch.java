package ie.atu.sw;

import java.util.*;

public class SimilaritySearch {

	private Map<String, double[]> embeddings;

	// Constructor to set the embeddings Map
	public SimilaritySearch(Map<String, double[]> embeddings) {
		this.embeddings = embeddings;
	}

	public List<SearchResults> findSimilarWords(double[] target, int topN, List<String> usedWords) {

		// Thread safe list to store results
		List<SearchResults> results = Collections.synchronizedList(new ArrayList<>());

		// Store threads so we can wait for them
		List<Thread> threads = new ArrayList<>();

		// Loop through every word stored in the embeddings map
		for (String word : embeddings.keySet()) {

			// Exclude the user-inputted words
			if (usedWords.contains(word)) {
				continue;
			}

			// Get the vector for the current word
			double[] vector = embeddings.get(word);

			// Run similarity calculation in a virtual thread
			Thread workerThread = Thread.startVirtualThread(() -> {

				// Calculate the cosine similarity between target vector and current word vector
				double similarityScore = VectorArithmetic.calculateCosineSimilarity(target, vector);

				// Store the result
				results.add(new SearchResults(word, similarityScore));
			});

			threads.add(workerThread);

			// Wait for all threads to finish
			for (Thread t : threads) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Sort the results based on similarity score
			results.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));

		}
		// Return the top N most similar words
		return results.subList(0, topN);
	}
}