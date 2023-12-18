package Question1;

public class Book {
    private String title;
    private String author;
    private long isbn;
    private double price;

    // Static variable to keep track of the number of Book objects created
    private static int bookCount = 0;

    // Constructor
    public Book(String title, String author, long isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        bookCount++;  // Increment book count
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getISBN() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(long isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to find the number of created books
    public static int findNumberOfCreatedBooks() {
        return bookCount;
    }

    // equals method to compare two Book objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn == book.isbn && Double.compare(book.price, price) == 0;
    }

    // toString method to display book information
    @Override
    public String toString() {
        return "Book{" +
               "Title='" + title + '\'' +
               ", Author='" + author + '\'' +
               ", ISBN=" + isbn +
               ", Price=" + price +
               '}';
    }
}

