package ie.atu.sw;

import java.util.*;

public class Menu {

	// Scanner for user input
	private Scanner scanner = new Scanner(System.in);
	
	private SimilaritySearch search;
	
	// Stores word embeddings loaded from file
	private Map<String, double[]> embeddings;
	
	// Builds the result vector from user input
	private ExpressionEvaluator evaluator = new ExpressionEvaluator();
	
	// Writes results to a file
	private OutputWriter outputWriter = new OutputWriter("out.txt");

	// Constructor sets up embeddings and search class
	public Menu(Map<String, double[]> embeddings) {
		this.embeddings = embeddings;
		this.search = new SimilaritySearch(embeddings);
	}

	// Displays and runs the main menu loop
	public void showMenu() {
		
		// Print program header once
		System.out.println(ConsoleColour.WHITE);
		System.out.println("************************************************************");
		System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
		System.out.println("*                                                          *");
		System.out.println("*  Word Analogies with Vector Arithmetic & Virtual Threads *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");

		// Boolean flag controls main menu loop
		// When false, program exits
		boolean keepRunning = true;

		while (keepRunning) {
			System.out.println("(1) Enter Path to Embeddings File>");
			System.out.println("(2) Enter Vector Operation>");
			System.out.println("(3) Configure Options");
			System.out.println("(4) Specify Output File (default: ./out.txt)");
			System.out.println("(5) Optional Extras...");
			System.out.println("(6) Quit");

			int userChoice;

			// Read and validate user input
			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input - must be a number.");
				continue;
			}

			switch (userChoice) {

			case 1 -> {
				// Set embeddings file path
				System.out.print("Enter embeddings path: ");
				String path = scanner.nextLine();
				System.out.println("Path set to: " + path);
				break;
			}

			case 2 -> {
				// Run vector operation and similarity search
				List<String> usedWords = new ArrayList<>();

				double[] resultVector = evaluator.buildVector(scanner, embeddings, usedWords);

				if (resultVector == null)
					break;

				List<SearchResults> results = search.findSimilarWords(resultVector, 10, usedWords);

				// Print results to console
				for (SearchResults r : results) {
					System.out.println(r);
				}

				// Write results to file
				outputWriter.write(results);

			}

			case 3 -> {
				System.out.println("3 Not implemented yet");
				break;
			}

			case 4 -> {
				// Change output file
				System.out.println("Enter output file path: ");
				String path = scanner.nextLine();
				outputWriter.setOutputFile(path);
				System.out.println("Output file set to: " + path);
			}

			case 5 -> {
				System.out.println("5 Not implemented yet");
				break;
			}

			case 6 -> {
				System.out.println("Exiting...");
				keepRunning = false;
			}
			default -> {
				System.out.println("Invalid option.");
			}
			}

		}
	}
}
