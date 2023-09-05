package task15;

public class Book implements Comparable<Book>{
    private String title = "";
    private String author = "";
    private int price;
    private static int edition;
    private int isbn;
    public Book() {}
    public Book(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }
    public Book setTitle(String title) {
        this.title = title;
        return this;
    }
    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }
    public Book setPrice(int price) {
        this.price = price;
        return this;
    }
    public Book setEdition(int edit) {
        edition = edit;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Title: " + title + "\n");
        result.append("Author: " + author + "\n");
        result.append("Price: " + price + "$\n");
        return result.toString();
    }

    @Override
    public boolean equals(Object o){
        boolean result = false;
        if(o instanceof  Book book) {
            boolean isAuthor = book.author.equals(author);
            boolean isTitle = book.title.equals(title);
            boolean isPrice = book.price == price;
            result = isAuthor && isTitle && isPrice;
        }

        return result;
    }

    @Override
    public int hashCode() {
        return  (7 * title.hashCode()
                + 2 * author.hashCode()
                + 13 * Integer.valueOf(price).hashCode()
                + 117 * Integer.valueOf(edition).hashCode())
                % Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(Book o) {
        return this.isbn - o.isbn;
    }
}
