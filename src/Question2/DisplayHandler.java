package Question2;

import java.util.Scanner;

public class DisplayHandler {
    private Book[] inventory;
    private Scanner scanner;

    public DisplayHandler(Book[] inventory, Scanner scanner) {
        this.inventory = inventory;
        this.scanner = scanner;
    }

    public void displayBooksByAuthor() {
        // Prompt user to enter the author's name
    	System.out.print("Enter author name: ");
        scanner.nextLine(); // Consume newline left-over
        String authorName = scanner.nextLine();

        boolean found = false;
        // Loop through the inventory to find and display books by the given author
        for (Book book : inventory) {
            if (book != null && book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println(book);
                found = true;
            }
        }

        // Display a message if no books by the author were found
        if (!found) {
            System.out.println("No books found by author: " + authorName);
        }
    }

    public void displayBooksCheaperThan() {
        // Prompt user to enter a price
    	System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        boolean found = false;
        // Loop through the inventory to find and display books cheaper than the given price
        for (Book book : inventory) {
            if (book != null && book.getPrice() < price) {
                System.out.println(book);
                found = true;
            }
        }

        // Display a message if no books under the specified price were found
        if (!found) {
            System.out.println("No books found under $" + price);
        }
    }
}
