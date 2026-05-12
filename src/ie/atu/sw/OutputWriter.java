package ie.atu.sw;

import java.io.*;
import java.util.List;

public class OutputWriter {

	// File name where results will be saved
	private String outputFile;

	// Constructor sets the default output file
	public OutputWriter(String outputFile) {
		this.outputFile = outputFile;
	}

	// Allows user to change the output file name
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	// Writes the list of results to a text file
	public void write(List<SearchResults> results) {
		try (FileWriter fw = new FileWriter(new File(outputFile))) {
			
			// Write each result to the file
			for (SearchResults r : results) {
				fw.write(r.toString() + "\n");
			}

			System.out.println("Results written to: " + outputFile);
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

}
