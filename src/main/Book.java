public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ") [ISBN: " + isbn + "] - " + 
               (available ? "Available" : "Not Available");
    }
}
