package ie.atu.sw;

import java.util.*;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private SimilaritySearch search;
	private Map<String, double[]> embeddings;
	private String outputFile = "out.txt";

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
				userChoice = Integer.parseInt(scanner.next());
			} catch (Exception e) {
				System.out.println("Invalid input - must be a number.");
				continue;
			}

			switch (userChoice) {

			case 1 -> {
				System.out.print("Enter embeddings path: ");
				String path = scanner.next();
				System.out.println("Path set to: " + path);
				break;
			}

			case 2 -> {
				System.out.println("2 Not implemented yet");
				break;
			}

			case 3 -> {
				System.out.println("3 Not implemented yet");
				break;
			}

			case 4 -> {
				System.out.println("Enter output file path: ");
				String outputFile = scanner.next();
				System.out.println("Output file path set to: " + outputFile);
				break;
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
