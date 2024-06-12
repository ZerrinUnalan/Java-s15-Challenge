package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private int book_isbn;
    private String title;
    Author author;
    Genre genre;
    boolean isBorrowed;
    private double price;
    private Reader borrower;
    private List<CommentRating> comment_rating = new ArrayList<>();

    public Book(int book_isbn, String title, Author author, Genre genre, boolean isBorrowed, double price, Reader borrower, List<CommentRating> comment_rating) {
        this.book_isbn = book_isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
        this.price = price;
        this.borrower = borrower;
        this.comment_rating = comment_rating;

    }

    public Book(String title, List<CommentRating> comment_rating) {
        this.title = title;
        this.comment_rating = comment_rating;
    }

    public Book(int book_isbn, String title, Author author, Genre genre, boolean isBorrowed, double price, Reader borrower) {
        this.book_isbn = book_isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
        this.price = price;
        this.borrower = borrower;
    }


    public int getBook_isbn() {
        return book_isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public double getPrice() {
        return price;
    }

    public Reader getBorrower() {
        return borrower;
    }

    public List<CommentRating> getComment_rating() {
        return comment_rating;
    }

    public Book() {
        super();
    }

    public void setBook_isbn(int book_isbn) {
        this.book_isbn = book_isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBorrower(Reader borrower) {
        this.borrower = borrower;
    }

    public void setComment_rating(List<CommentRating> comment_rating) {
        this.comment_rating = comment_rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_isbn == book.book_isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(book_isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_isbn=" + book_isbn +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
