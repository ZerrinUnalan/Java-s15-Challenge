package model;

import java.util.List;

public class Author {
    private String name;
    private String surname;
    private String born_in;
    private String genre;
    List<Book> books;
    List<EBook> ebooks;

    public Author(String name, String surname, String born_in, String genre, List<Book> books, List<EBook> ebooks) {
        this.name = name;
        this.surname = surname;
        this.born_in = born_in;
        this.genre = genre;
        this.books = books;
        this.ebooks = ebooks;
    }
}
