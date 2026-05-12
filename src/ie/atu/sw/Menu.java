package ie.atu.sw;

import java.io.PrintStream;
import java.util.*;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private SimilaritySearch search;
	private Map<String, double[]> embeddings;
	private ExpressionEvaluator evaluator = new ExpressionEvaluator();
	private OutputWriter outputWriter = new OutputWriter("out.txt");
	
	public Menu(Map<String, double[]> embeddings) {
		this.embeddings = embeddings;
		this.search = new SimilaritySearch(embeddings);
	}

	public void showMenu() {
		// Print program header
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

			try {
				userChoice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input - must be a number.");
				continue;
			}

			switch (userChoice) {

			case 1 -> {
				System.out.print("Enter embeddings path: ");
				String path = scanner.nextLine();
				System.out.println("Path set to: " + path);
				break;
			}

			case 2 -> {
				double[] resultVector = evaluator.buildVector(scanner, embeddings);
				
				if (resultVector == null) break;
				
				List<SearchResults> results = search.findSimilarWords(resultVector, 10);
				
				for (SearchResults r : results) {
					System.out.println(r);
				}
				
				outputWriter.write(results);
				
			}

			case 3 -> {
				System.out.println("3 Not implemented yet");
				break;
			}

			case 4 -> {
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
