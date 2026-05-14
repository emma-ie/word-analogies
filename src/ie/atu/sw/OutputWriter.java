package ie.atu.sw;

import java.io.*;
import java.util.List;

/**
 * Writes similarity search results to an output text file.
 */
public class OutputWriter {

	// File name where results will be saved
	private String outputFile;

	/**
	 * Creates a new OutputWriter object with the specified output file.
	 * 
	 * @param outputFile the name or path of the output file
	 */
	// Time complexity: O(1)
	// Explanation: Initialises a new OutputWriter object and sets the output file
	// name - no loops
	public OutputWriter(String outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * Updates the output file used to save results.
	 * 
	 * @param outputFile the new output file name or path
	 */
	// Time complexity: O(1)
	// Explanation: Updates the output file name - no loops
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * Writes similarity search results to the output file.
	 * 
	 * @param results list of search results to write to the file
	 */
	// Time complexity: O(n)
	// Explanation: Loops through all search results and writes each one to the file
	public void write(List<SearchResults> results) {
		try (FileWriter fw = new FileWriter(new File(outputFile))) {

			// Write each result to the file
			for (SearchResults r : results) {
				fw.write(r.toString() + "\n");
			}
			System.out.println(ConsoleColour.WHITE);
			System.out.println("Results written to: " + outputFile);
		} catch (IOException e) {
			System.out.println(ConsoleColour.RED_BOLD_BRIGHT);
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

}
