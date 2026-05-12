package ie.atu.sw;

public class SearchResults {

	private String word;
	private double score;
	
	// Constructor to set variables 
	public SearchResults(String word, double score) {
		this.word = word;
		this.score = score;
	}

	public String getWord() {
		return word;
	}
	
	public double getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return word + " (" + score + ")";
	}
}
