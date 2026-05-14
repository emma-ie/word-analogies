package ie.atu.sw;

/**
 * Represents a similarity search result containing a word and its similarity
 * score.
 */
public class SearchResults {

	private String word;
	private double score;

	/**
	 * Creates a new SearchResults object.
	 * 
	 * @param word  the similar word
	 * @param score the similarity score for the word
	 */
	// Time complexity: O(1)
	// Explanation: Initialises a new SearchResults object and sets the variables -
	// no loops
	public SearchResults(String word, double score) {
		this.word = word;
		this.score = score;
	}

	/**
	 * Returns the word associated with the search result.
	 * 
	 * @return the similar word
	 */
	// Returns the word associated with the search result
	// Time complexity: O(1)
	// Explanation: Returns a single variable - no loops
	public String getWord() {
		return word;
	}

	/**
	 * Returns the similarity score associated with the search result.
	 * 
	 * @return the similarity score
	 */
	// Time complexity: O(1)
	// Explanation: Returns a single variable - no loops
	public double getScore() {
		return score;
	}

	/**
	 * Returns a readable string version of the search result.
	 * 
	 * @return formatted search result string
	 */
	// Time complexity: O(1)
	// Explanation: Creates and returns a single string - no loops
	@Override
	public String toString() {
		return word + " (" + score + ")";
	}
}
