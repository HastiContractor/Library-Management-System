import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(String isbn, String title, String author, int publicationYear) {
        if (!books.containsKey(isbn)) {
            books.put(isbn, new Book(isbn, title, author, publicationYear));
        }
    }

    public boolean borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean isBookAvailable(String isbn) {
        Book book = books.get(isbn);
        return book != null && book.isAvailable();
    }

    public int getBooksCount() {
        return books.size();
    }
}
