package Question2;

import java.util.Scanner;

public class AuthenticationHandler {
    private static final String PASSWORD = "pargol"; // The correct password
    private Scanner scanner;

    public AuthenticationHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean validatePassword() {
        int attempts = 0; // Initialize the number of password entry attempts

        // Allow up to 3 password entry attempts
        while (attempts < 3) {
            System.out.print("Enter password: ");
            String enteredPassword = scanner.next();

            // Check if the entered password matches the correct password
            if (enteredPassword.equals(PASSWORD)) {
                return true; // Password is correct, authentication is successful
            } else {
                System.out.println("Incorrect password. Try again.");
                attempts++; // Increment the number of attempts
            }
        }

        // Maximum attempts exceeded, inform the user and return to the main menu
        System.out.println("Maximum attempts exceeded. Returning to main menu.");
        return false; // Authentication failed
    }
}
