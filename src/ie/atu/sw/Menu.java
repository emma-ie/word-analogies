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

	private String embeddingsPath = "embeddings.txt";

	// Default value for how many results to print
	private int topN = 10;

	// Value that determines which similarity method is used - default is cosine
	// 1 = cosine, 2 = euclidean
	private int similarityMethod = 1;

	// Loads embeddings from file and refreshes the search
	// Time complexity: O(n)
	// Explanation: Reads all embeddings from the file and stores them in a map
	private void loadEmbeddings() {
		EmbeddingLoader loader = new EmbeddingLoader();
		this.embeddings = loader.load(embeddingsPath);
		this.search = new SimilaritySearch(embeddings);
	}

	// Constructor
	// Time complexity: O(1)
	// Explanation: Initialises the Menu object
	public Menu() {
		loadEmbeddings();
	}

	// Displays and runs the main menu loop
	// Time complexity: O(n)
	// Explanation: The menu runs in a loop until the user chooses to exit
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
			System.out.println("(5) Quit");

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
				// Set embeddings file path (or use default)
				System.out.print("Enter embeddings path (or press Enter for default embeddings.txt): ");
				String path = scanner.nextLine();

				if (!path.isBlank()) {
					embeddingsPath = path;
				}

				loadEmbeddings();

				System.out.println("Embeddings loaded from: " + embeddingsPath);
			}

			case 2 -> {
				// Run vector operation and similarity search
				List<String> usedWords = new ArrayList<>();

				double[] resultVector = evaluator.buildVector(scanner, embeddings, usedWords);

				if (resultVector == null)
					break;

				List<SearchResults> results = search.findSimilarWords(resultVector, topN, usedWords, similarityMethod);

				// Print results to console
				for (SearchResults r : results) {
					System.out.println(r);
				}

				// Write results to file
				outputWriter.write(results);

			}

			case 3 -> {
				System.out.println("Configuration Menu:");
				System.out.println("1. Set number of results to display (currently " + topN + ")");
				System.out.println("2. Set similarity method");
				System.out.println("3. Back to main menu");

				int choice;

				try {
					choice = Integer.parseInt(scanner.nextLine());
				} catch (Exception e) {
					System.out.println("Invalid input.");
					break;
				}

				switch (choice) {

				case 1 -> {
					System.out.println("Enter number of results to display: ");

					try {
						int value = Integer.parseInt(scanner.nextLine());

						if (value > 0) {
							topN = value;
							System.out.println("Number of results to display set to: " + topN);
						} else {
							System.out.println("Value must be greater than 0.");
						}
					} catch (Exception e) {
						System.out.println("Invalid number.");
					}
				}

				case 2 -> {
					System.out.println("Choose which similarity method to use:");
					System.out.println("1. Cosine similarity");
					System.out.println("2. Euclidean distance");

					try {
						int method = Integer.parseInt(scanner.nextLine());

						if (method == 1 || method == 2) {
							similarityMethod = method;
							System.out.println("Similarity method updated to " + similarityMethod);
						}
					} catch (Exception e) {
						System.out.println("Invalid input.");
					}
				}

				case 3 -> {
					System.out.println("Navigating to main menu...");
					break;
				}

				default -> System.out.println("Invalid option.");
				}

			}

			case 4 -> {
				// Change output file
				System.out.print("Enter output file path: ");
				String path = scanner.nextLine();
				outputWriter.setOutputFile(path);
				System.out.println("Output file set to: " + path);
			}

			case 5 -> {
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
