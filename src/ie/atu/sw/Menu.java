package ie.atu.sw;

import java.util.*;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private SimilaritySearch search;
	private Map<String, double[]> embeddings;
	
	public Menu(Map<String, double[]> embeddings) {
		this.embeddings = embeddings;
		this.search = new SimilaritySearch(embeddings);
	}
	
	public void showMenu() {
		
		while(true) {
			System.out.println(ConsoleColour.WHITE);
			System.out.println("************************************************************");
			System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
			System.out.println("*                                                          *");
			System.out.println("*  Word Analogies with Vector Arithmetic & Virtual Threads *");
			System.out.println("*                                                          *");
			System.out.println("************************************************************");
			System.out.println("(1) Enter Path to Embeddings File>");
			System.out.println("(2) Enter Vector Operation>");
			System.out.println("(3) Configure Options");
			System.out.println("(4) Specify Output File (default: ./out.txt)");
			System.out.println("(5) Optional Extras...");
			System.out.println("(6) Quit");
			
			String userChoice = scanner.nextLine();
			
			switch (userChoice) {
			case "1":
				System.out.print("Enter embeddings path: ");
				String path = scanner.nextLine();
				System.out.println("Path set to: " + path);
				break;
			
			case "2":
				System.out.println("2 Not implemented yet");
				break;
				
			case "3":
				System.out.println("3 Not implemented yet");
				break;
				
			case "4":
				System.out.println("Enter output file path: ");
				String outPath = scanner.nextLine();
				System.out.println("Output file path set to: " + outPath);
				break;
				
			case "5":
				System.out.println("5 Not implemented yet");
				break;
				
			case "6":
				System.out.println("Exiting...");
				return;
				
			default:
				System.out.println("Invalid option.");
			}
			
			//Output a menu of options and solicit text from the user
			System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
			System.out.print("Select Option [1-4]>");
			System.out.println();
		}
	}
}
