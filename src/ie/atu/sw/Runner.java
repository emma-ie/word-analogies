package ie.atu.sw;

import java.util.*;

public class Runner {
	
	// Time complexity: O(n)
	// Explanation: Loads all embeddings from the file and starts the menu 
	public static void main(String[] args) {
		EmbeddingLoader loader = new EmbeddingLoader();

		// Load embeddings file
		Map<String, double[]> embeddings = loader.load("embeddings.txt");

		// Start menu
		Menu menu = new Menu(embeddings);
		menu.showMenu();

	}
}
