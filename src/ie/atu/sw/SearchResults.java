package ie.atu.sw;

public class SearchResults {

	private String word;
	private double score;

	// Constructor to set variables
	// Time complexity: O(1)
	// Explanation: Initialises a new SearchResults object and sets the variables - no loops
	public SearchResults(String word, double score) {
		this.word = word;
		this.score = score;
	}

	// Returns the word associated with the search result
	// Time complexity: O(1)
	// Explanation: Returns a single variable - no loops
	public String getWord() {
		return word;
	}

	// Returns the score associated with the search result
	// Time complexity: O(1)
	// Explanation: Returns a single variable - no loops
	public double getScore() {
		return score;
	}

	// Returns a readable version of the result for printing
	// Time complexity: O(1)
	// Explanation: Creates and returns a single string - no loops
	@Override
	public String toString() {
		return word + " (" + score + ")";
	}
}
