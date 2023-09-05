package task15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void compareTo() {
        Book[] books = new Book[] {
                new Book(5).setTitle("Aboba"),
                new Book(3).setTitle("Biboba"),
                new Book(2).setTitle("Triboba"),
                new Book(4).setTitle("Quaboba"),
                new Book(4).setTitle("Pentboba"),
        };
        Arrays.sort(books);
        int[] isbns = new int[books.length];
        for(int i=0; i<isbns.length; i++) {
            isbns[i] = books[i].getIsbn();
        }
        assertArrayEquals(new int[] {2,3,4,4,5}, isbns);
    }

    @Test
    void compareToMore() {
        Book[] books = new Book[] {
                new Book(-2).setTitle("Aboba"),
                new Book(1).setTitle("Biboba"),
                new Book(2).setTitle("Triboba"),
                new Book(3).setTitle("Quaboba"),
                new Book(0).setTitle("Pentboba"),
        };
        Arrays.sort(books);
        int[] isbns = new int[books.length];
        for(int i=0; i<isbns.length; i++) {
            isbns[i] = books[i].getIsbn();
        }
        assertArrayEquals(new int[] {-2, 0, 1, 2, 3}, isbns);
    }
}