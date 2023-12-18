package Question1;

public class Main {
    public static void main(String[] args) {
        // Creating Book objects
        Book book1 = new Book("1984", "George Orwell", 1234567890123L, 9.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1234567890124L, 12.99);

        // Displaying the number of created books
        System.out.println("Number of books created: " + Book.findNumberOfCreatedBooks());

        // Modifying and displaying book details
        book1.setPrice(8.99);
        System.out.println(book1);

        // Comparing two books
        Book book3 = new Book("1984", "George Orwell", 1234567890123L, 8.99);
        System.out.println("Book1 equals Book3: " + book1.equals(book3));
    }
}

