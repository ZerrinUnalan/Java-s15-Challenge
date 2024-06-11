package model;

import java.util.List;
import java.util.Objects;

public class Author {
    private String name;
    private String surname;
    private String born_in;
    private String genre;
    List<Book> books;
    List<EBook> ebooks;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(String name, String surname, List<Book> books, List<EBook> ebooks) {
        this.name = name;
        this.surname = surname;
        this.books = books;
        this.ebooks = ebooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<EBook> getEbooks() {
        return ebooks;
    }

    public void setEbooks(List<EBook> ebooks) {
        this.ebooks = ebooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", books=" + books +
                ", ebooks=" + ebooks +
                '}';
    }
}

