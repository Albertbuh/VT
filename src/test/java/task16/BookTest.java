package task16;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    @DisplayName("Sort by title")
    public void testSortByTitle() {
        Book[] books = new Book[] {
                new Book().setTitle("Aboba").setAuthor("ulrih").setPrice(130),
                new Book().setTitle("Biboba").setAuthor("misha").setPrice(234),
                new Book().setTitle("Triboba").setAuthor("oleg").setPrice(984),
                new Book().setTitle("Quaboba").setAuthor("kolya").setPrice(123),
                new Book().setTitle("Pentboba").setAuthor("morcepan").setPrice(384),
        };
        Arrays.sort(books, new TitleComparator());
        for(var b: books) {
            System.out.println(b.toString());
        }
        assertTrue(true);
    }

    @Test
    @DisplayName("Sort by title, by name")
    public void testSortByTitleByName() {
        Book[] books = new Book[] {
                new Book().setTitle("Aboba").setAuthor("ulrih").setPrice(130),
                new Book().setTitle("Biboba").setAuthor("misha").setPrice(234),
                new Book().setTitle("Triboba").setAuthor("oleg").setPrice(984),
                new Book().setTitle("Quaboba").setAuthor("kolya").setPrice(123),
                new Book().setTitle("Pentboba").setAuthor("morcepan").setPrice(384),
                new Book().setTitle("Pentboba").setAuthor("Amorcepan").setPrice(384),
                new Book().setTitle("Pentboba").setAuthor("Zmorcepan").setPrice(384),
        };
        Arrays.sort(books, new TitleComparator().thenComparing(new AuthorComparator()));
        for(var b: books) {
            System.out.println(b.toString());
        }
        assertTrue(true);
    }

    @Test
    @DisplayName("Sort by name, by title")
    public void testSortByNameByTitle() {
        Book[] books = new Book[] {
                new Book().setTitle("Aboba").setAuthor("ulrih").setPrice(130),
                new Book().setTitle("Biboba").setAuthor("misha").setPrice(234),
                new Book().setTitle("Triboba").setAuthor("oleg").setPrice(984),
                new Book().setTitle("Quaboba").setAuthor("kolya").setPrice(123),
                new Book().setTitle("ZPentboba").setAuthor("morcepan").setPrice(384),
                new Book().setTitle("pentboba").setAuthor("morcepan").setPrice(384),
                new Book().setTitle("APentboba").setAuthor("morcepan").setPrice(384),
        };
        Arrays.sort(books, new AuthorComparator().thenComparing(new TitleComparator()));
        for(var b: books) {
            System.out.println(b.toString());
        }
        assertTrue(true);
    }

    @Test
    @DisplayName("Sort by name, by title, by price")
    public void testSortByNameByTitleByPrice() {
        Book[] books = new Book[] {
                new Book().setTitle("Aboba").setAuthor("ulrih").setPrice(130),
                new Book().setTitle("Biboba").setAuthor("misha").setPrice(234),
                new Book().setTitle("Triboba").setAuthor("oleg").setPrice(984),
                new Book().setTitle("Quaboba").setAuthor("kolya").setPrice(123),
                new Book().setTitle("ZPentboba").setAuthor("morcepan").setPrice(384),
                new Book().setTitle("pentboba").setAuthor("morcepan").setPrice(384),
                new Book().setTitle("pentboba").setAuthor("morcepan").setPrice(376),
                new Book().setTitle("pentboba").setAuthor("morcepan").setPrice(415),
                new Book().setTitle("APentboba").setAuthor("morcepan").setPrice(384),
        };
        Arrays.sort(books, new AuthorComparator()
                .thenComparing(new TitleComparator())
                .thenComparing(new PriceComparator()));
        
        for(var b: books) {
            System.out.println(b.toString());
        }
        assertTrue(true);
    }

}