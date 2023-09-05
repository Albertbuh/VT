package task13;

import task12.Book;

public class ProgrammerBook extends Book {
    private String language;
    private int level;
    public ProgrammerBook setLanguage(String lang) {
        language = lang;
        return this;
    }
    public ProgrammerBook setLevel(int level) {
        this.level = level;
        return this;
    }

    @Override
    public String toString() {
      return super.toString()
              + "Lang: " + language + "\n";
    }

    @Override
    public boolean equals(Object o) {
        boolean result = super.equals(o);
        if(result) {
            if(o instanceof ProgrammerBook book) {
                result = book.language.equals(language) && book.level == level;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (17 * super.hashCode() + 99 * language.hashCode() + level * 10000) % Integer.MAX_VALUE;
    }
}
