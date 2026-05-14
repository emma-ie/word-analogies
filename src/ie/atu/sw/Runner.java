package ie.atu.sw;

/**
 * Entry point for the application. 
 * 
 * This class starts the program by launching the main menu interface.
 */
public class Runner {
	
	/**
	 * Main method that starts the application.
	 * 
	 * @param args Command line arguments - not used in this application.
	 */
	// Time complexity: O(n)
	// Explanation: Loads all embeddings from the file and starts the menu 
	public static void main(String[] args) {

		// Create new instance of Menu object
		Menu menu = new Menu();
		
		// Start menu
		menu.showMenu();
	}
}
