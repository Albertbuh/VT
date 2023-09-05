package task13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammerBookTest {

    @Test
    @DisplayName("toString")
    public void testToString() {
        ProgrammerBook book = new ProgrammerBook();
        book.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book.setLanguage("ruby").setLevel(2);
        System.out.println(book.toString());
        assertTrue(true);
    }

    @Test
    @DisplayName("equals(false)")
    public void testNotEquals() {
        ProgrammerBook book1 = new ProgrammerBook();
        book1.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book1.setLanguage("ruby").setLevel(2);

        ProgrammerBook book2 = new ProgrammerBook();
        book2.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book2.setLanguage("rust").setLevel(2);
        assertNotEquals(book1, book2);
    }

    @Test
    @DisplayName("equals(true)")
    public void testEquals() {
        ProgrammerBook book1 = new ProgrammerBook();
        book1.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book1.setLanguage("ruby").setLevel(2);

        ProgrammerBook book2 = new ProgrammerBook();
        book2.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book2.setLanguage("ruby").setLevel(2);
        assertEquals(book1, book2);
    }

    @Test
    @DisplayName("hashCode")
    public void testHashCode() {
        ProgrammerBook book1 = new ProgrammerBook();
        book1.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book1.setLanguage("ruby").setLevel(2);

        ProgrammerBook book2 = new ProgrammerBook();
        book2.setTitle("aboba").setAuthor("aboba author").setPrice(100);
        book2.setLanguage("ruby").setLevel(2);
        assertEquals(book1.hashCode(), book2.hashCode());
    }
}