package ie.atu.sw;

import java.util.*;

public class Runner {
	public static void main(String[] args) {
		EmbeddingLoader loader = new EmbeddingLoader();

		// Load embeddings file
		Map<String, double[]> embeddings = loader.load("embeddings.txt");
		System.out.println("Embeddings loaded: " + embeddings.size());

		// Start menu
		Menu menu = new Menu(embeddings);
		menu.showMenu();
		
	}
}
