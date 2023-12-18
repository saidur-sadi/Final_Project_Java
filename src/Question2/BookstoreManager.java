package Question2;

import java.util.Scanner;

public class BookstoreManager {
    private static Book[] inventory;
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryHandler inventoryHandler;
    private static DisplayHandler displayHandler;
    private static AuthenticationHandler authenticationHandler;

    public static void main(String[] args) {
        System.out.println("Welcome to the Bookstore Management System!");
        initializeInventory();
        inventoryHandler = new InventoryHandler(inventory, scanner);
        displayHandler = new DisplayHandler(inventory, scanner);
        authenticationHandler = new AuthenticationHandler(scanner);

        int choice;
        do {
            choice = displayMainMenuAndGetChoice();
            switch (choice) {
                case 1:
                    // Option 1: Enter new books (password required)
                    inventoryHandler.enterBooks(authenticationHandler);
                    break;
                case 2:
                    // Option 2: Change information of a book (password required)
                    inventoryHandler.changeBookInfo(authenticationHandler);
                    break;
                case 3:
                    // Option 3: Display all books by a specific author
                    displayHandler.displayBooksByAuthor();
                    break;
                case 4:
                    // Option 4: Display all books under a certain price
                    displayHandler.displayBooksCheaperThan();
                    break;
                case 5:
                    // Option 5: Quit the program
                    System.out.println("Thank you for using the Bookstore Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void initializeInventory() {
        // Initialize the inventory with a user-defined maximum number of books
        System.out.print("Enter the maximum number of books: ");
        int maxBooks = scanner.nextInt();
        inventory = new Book[maxBooks];
    }

    private static int displayMainMenuAndGetChoice() {
        // Display the main menu options and prompt the user for their choice
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Enter new books (password required)");
        System.out.println("2. Change information of a book (password required)");
        System.out.println("3. Display all books by a specific author");
        System.out.println("4. Display all books under a certain price");
        System.out.println("5. Quit");
        System.out.print("Please enter your choice > ");
        return scanner.nextInt();
    }
}

