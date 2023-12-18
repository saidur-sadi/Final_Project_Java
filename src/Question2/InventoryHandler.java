package Question2;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryHandler {
    private Book[] inventory;
    private Scanner scanner;

    public InventoryHandler(Book[] inventory, Scanner scanner) {
        this.inventory = inventory;
        this.scanner = scanner;
    }

    public void enterBooks(AuthenticationHandler authenticationHandler) {
        // Check if authentication is successful before entering books
        if (!authenticationHandler.validatePassword()) return;

        // Prompt user for the number of books to enter
        System.out.print("How many books do you want to enter? ");
        int numBooks = scanner.nextInt();
        ArrayList<Book> addedBooks = new ArrayList<>(); // List to store added books

        int enteredBooks = 0;
        for (int i = 0; i < inventory.length && enteredBooks < numBooks; i++) {
            // Check if the inventory slot is empty
            if (inventory[i] == null) {
                // Prompt for book information
                System.out.print("Enter title: ");
                scanner.nextLine(); // Consume newline left-over
                String title = scanner.nextLine();

                System.out.print("Enter author: ");
                String author = scanner.nextLine();

                System.out.print("Enter ISBN: ");
                long isbn = scanner.nextLong();

                System.out.print("Enter price: ");
                double price = scanner.nextDouble();

                // Create a new Book object, add it to the inventory, and add to addedBooks list
                Book newBook = new Book(title, author, isbn, price);
                inventory[i] = newBook;
                addedBooks.add(newBook);
                enteredBooks++;
                
            }
        }
        
        // Display all the books that were added
        System.out.println("Books added:");
        for (Book book : addedBooks) {
            System.out.println(book.toString());
        }
        
        // Provide feedback on how many books were added
        if (enteredBooks < numBooks) {
            System.out.println("Only " + enteredBooks + " books were added due to space limitations.");
        } else {
            System.out.println(numBooks + " books added successfully.");
        }
    }

    public void changeBookInfo(AuthenticationHandler authenticationHandler) {
        // Check if authentication is successful before changing book information
        if (!authenticationHandler.validatePassword()) return;

        // Prompt user for the index of the book to update
        System.out.print("Enter book number to update: ");
        int bookIndex = scanner.nextInt() - 1;

        // Check if the index is valid and if a book exists at that index
        if (bookIndex < 0 || bookIndex >= inventory.length || inventory[bookIndex] == null) {
            System.out.println("Invalid book number. No book to update at this index.");
            return;
        }

        Book book = inventory[bookIndex];
        int choice;
        do {
            // Display current book information and options for updating
            System.out.println("\nCurrent Book Information: ");
            System.out.println(book);
            System.out.println("What information would you like to change?");
            System.out.println("1. Author\n2. Title\n3. ISBN\n4. Price\n5. Quit");
            System.out.print("Enter your choice > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Prompt for and update the author
                    System.out.print("Enter new author: ");
                    scanner.nextLine(); // Consume newline
                    book.setAuthor(scanner.nextLine());
                    break;
                case 2:
                    // Prompt for and update the title
                    System.out.print("Enter new title: ");
                    scanner.nextLine(); // Consume newline
                    book.setTitle(scanner.nextLine());
                    break;
                case 3:
                    // Prompt for and update the ISBN
                    System.out.print("Enter new ISBN: ");
                    book.setISBN(scanner.nextLong());
                    break;
                case 4:
                    // Prompt for and update the price
                    System.out.print("Enter new price: ");
                    book.setPrice(scanner.nextDouble());
                    break;
                case 5:
                    // Exit the update loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
