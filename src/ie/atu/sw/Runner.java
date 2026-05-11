package ie.atu.sw;

import java.util.Arrays;
import java.util.Map;

public class Runner {
	public static void main(String[] args) {
		EmbeddingLoader loader = new EmbeddingLoader();
		
		Map<String, double[]> embeddings = loader.load("embeddings.txt");
		System.out.println("Loaded words: " + embeddings.size());
		
		System.out.println("Test word vector:");
		double[] vec = embeddings.get("a");
	
		System.out.println(Arrays.toString(vec));
	}
}
