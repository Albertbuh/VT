package task12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    @DisplayName("toString")
    void testToString() {
        Book book = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);

        System.out.println(book.toString());
        assertTrue(true);
    }

    @Test
    @DisplayName("equals (true)")
    void testEquals() {
        Book book = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);

        Book book2 = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);


        assertEquals(book,book2);
    }

    @Test
    @DisplayName("equals (false)")
    void testEqualsFalse() {
        Book book = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);

        Book book2 = new Book()
                .setTitle("Abo")
                .setAuthor("Aboba author")
                .setPrice(100);


        assertNotEquals(book,book2);
    }

    @Test
    @DisplayName("hash code")
    void testHashCide() {
        Book book = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);

        Book book2 = new Book()
                .setTitle("Aboba")
                .setAuthor("Aboba author")
                .setPrice(100);


        assertEquals(book.hashCode(),book2.hashCode());
    }
}