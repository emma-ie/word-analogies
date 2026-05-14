package ie.atu.sw;

import java.io.*;
import java.util.*;

/**
 * Loads word embeddings from a text file and stores them in a HashMap.
 * 
 * Each word is mapped to a vector of doubles representing its embedding.
 */
public class EmbeddingLoader {

	/**
	 * Reads the embeddings file line by line and processes each line.
	 * 
	 * @param file       path to the embeddings file
	 * @param embeddings map used to store loaded word embeddings
	 */
	// Time complexity: O(n)
	// Explanation: Reads each line in the embeddings file
	private void parse(String file, Map<String, double[]> embeddings) {

		// Try to read in the file
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

			String line;

			// While the BufferedReader's next line is not null, send that line to the
			// method process
			while ((line = br.readLine()) != null) {
				process(line, embeddings);
			}
		} catch (IOException e) {
			return;
		}
	}

	/**
	 * Converts a single line from the embeddings file into a word and its vector
	 * representation.
	 * 
	 * @param line       line read from the embeddings file
	 * @param embeddings map used to store loaded word embeddings
	 */
	// Called by parse method
	// Time complexity: O(n)
	// Explanation: Loops through each value in the vector once
	private void process(String line, Map<String, double[]> embeddings) {

		// Splits the line into individual tokens from each comma
		String[] tokens = line.split(",\\s+");

		// The word is always the first token in the line
		String word = tokens[0];

		// Create a new array of doubles the length of the tokens array - 1 to account
		// for the word being in position 0
		double[] vector = new double[tokens.length - 1];

		// Loop through each number in the tokens array
		for (int i = 1; i < tokens.length; i++) {

			// Parse the tokens array (not including the word at [0]) into doubles and place
			// them in the vector array
			vector[i - 1] = Double.parseDouble(tokens[i]);
		}

		// Put the word and array of doubles into the Map embeddings
		embeddings.put(word, vector);
	}

	/**
	 * Loads all embeddings from the specified file into a HashMap.
	 * 
	 * @param file path to the embeddings file
	 * @return map containing all loaded word embeddings
	 */
	// Time complexity: O(n)
	// Explanation: Reads the embeddings file and stores all word vectors in a
	// HashMap
	public Map<String, double[]> load(String file) {

		Map<String, double[]> embeddings = new HashMap<>();

		parse(file, embeddings);

		return embeddings;
	}

}
