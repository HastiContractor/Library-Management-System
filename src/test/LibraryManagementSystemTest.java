import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryManagementSystemTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        library.addBook("123456789", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertEquals(1, library.getBooksCount());
    }

    @Test
    void testBorrowBookSuccess() {
        library.addBook("123456789", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        assertTrue(library.borrowBook("123456789"));
        assertFalse(library.isBookAvailable("123456789"));
    }

    @Test
    void testBorrowBookFailure() {
        library.addBook("123456789", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.borrowBook("123456789");
        assertFalse(library.borrowBook("123456789")); // Attempt to borrow again should fail
    }

    @Test
    void testReturnBook() {
        library.addBook("123456789", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.borrowBook("123456789");
        library.returnBook("123456789");
        assertTrue(library.isBookAvailable("123456789"));
    }

    @Test
    void testViewAvailableBooks() {
        library.addBook("123456789", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook("987654321", "1984", "George Orwell", 1949);
        assertEquals(2, library.getAvailableBooks().size());
        library.borrowBook("123456789");
        assertEquals(1, library.getAvailableBooks().size());
    }
}
