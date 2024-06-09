package model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int book_isbn;
    private String title;
    Author author;
    Category category;
    boolean isBorrowed;
    private double price;
    private Reader borrower;
    private List<CommentRating> comment_rating = new ArrayList<>();

    public Book(int book_id, String title, Author author, Category category, boolean isBorrowed, double price, Reader borrower, List<CommentRating> comment_rating) {
        this.book_isbn = book_isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = isBorrowed;
        this.price = price;
        this.borrower = borrower;
        this.comment_rating = comment_rating;
    }





}
