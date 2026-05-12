package ie.atu.sw;

import java.util.*;

public class Runner {
	public static void main(String[] args) {
		EmbeddingLoader loader = new EmbeddingLoader();
		
		Map<String, double[]> embeddings = loader.load("embeddings.txt");
		
		double[] king = embeddings.get("king");
		double[] man = embeddings.get("man");
		double[] woman = embeddings.get("woman");
		
		double[] result = VectorArithmetic.subtract(king, man);
		
		result = VectorArithmetic.add(result, woman);
		
		SimilaritySearch search = new SimilaritySearch(embeddings);
		
		List<SearchResults> answers = search.findSimilarWords(result, 10);
		
		for(SearchResults r : answers) {
			System.out.println(r);
		}
	}
}
