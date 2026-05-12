package ie.atu.sw;

public class SearchResults {

	private String word;
	private double score;
	
	// Constructor to set variables 
	public SearchResults(String word, double score) {
		this.word = word;
		this.score = score;
	}

	// Returns the word associated with the search result
	public String getWord() {
		return word;
	}
	
	// Returns the score associated with the search result
	public double getScore() {
		return score;
	}
	
	
	// Returns a readable version of the result for printing
	@Override
	public String toString() {
		return word + " (" + score + ")";
	}
}
