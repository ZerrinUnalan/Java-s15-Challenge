package model;


import java.util.List;

public class EBook extends Book {
    private double file_size;
    private String system_compatibility;

    public EBook(int book_id, String title, Author author, Genre genre, boolean isBorrowed, double price, Reader borrower, List<CommentRating> comment_rating, double file_size, String system_compatibility) {
        super(book_id, title, author, genre, isBorrowed, price, borrower, comment_rating);
        this.file_size = file_size;
        this.system_compatibility = system_compatibility;
    }

    public EBook(double file_size, String system_compatibility) {
        this.file_size = file_size;
        this.system_compatibility = system_compatibility;
    }
}

