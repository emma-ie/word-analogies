package ie.atu.sw;

import java.util.*;

public class SimilaritySearch {

	private Map<String, double[]> embeddings;

	// Constructor to set the embeddings Map
	public SimilaritySearch(Map<String, double[]> embeddings) {
		this.embeddings = embeddings;
	}

	public List<SearchResults> findSimilarWords(double[] target, int topN) {

		// Create list used to store words and their similarity scores
		List<SearchResults> results = new ArrayList<>();

		// Loop through every word stored in the embeddings map
		for (String word : embeddings.keySet()) {
			
			// Get the vector for the current word
			double[] vector = embeddings.get(word);

			// Calculate the cosine similarity between target vector and current word vector
			double similarity = VectorArithmetic.calculateCosineSimilarity(target, vector);
			
			// Store the word and similarity score in the results list
			results.add(new SearchResults(word, similarity));
		}

		// Sort the results based on similarity score
		results.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));

		// Return the top N most similar words
		return results.subList(0, topN);
	}
}
