package Question2;

public class Book {
    private String title;
    private String author;
    private long isbn;
    private double price;

    public Book(String title, String author, long isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    // Getters and setters for all attributes
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getISBN() {
        return isbn;
    }

    public void setISBN(long isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
