package ie.atu.sw;

import java.io.*;
import java.util.List;

public class OutputWriter {

	private String outputFile;

	public OutputWriter(String outputFile) {
		this.outputFile = outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public void write(List<SearchResults> results) {
		try (FileWriter fw = new FileWriter(new File(outputFile))) {
			for (SearchResults r : results) {
				fw.write(r.toString());
			}

			System.out.println("Results written to: " + outputFile);
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

}
