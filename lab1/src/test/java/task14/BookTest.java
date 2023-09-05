package task14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    @DisplayName("clone")
    void testClone() {
        Book book = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);
        Book bookClone = book.clone();
        assertNotEquals(bookClone.hashCode(), book.hashCode());
    }

    @Test
    @DisplayName("clone2")
    void testClone2() {
        Book book = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);
        Book bookClone = book.clone();
        bookClone.setTitle("Biboba");
        assertNotEquals(bookClone.getTitle(), book.getTitle());
    }
}