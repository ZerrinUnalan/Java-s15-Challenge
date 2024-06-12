package model;


import java.util.List;

public class EBook extends Book {
    private double file_size;
    private String system_compatibility;

    public EBook(int book_isbn, String title, Author author, Genre genre, boolean isBorrowed, double price, Reader borrower, List<CommentRating> comment_rating, double file_size, String system_compatibility) {
        super(book_isbn, title, author, genre, isBorrowed, price, borrower, comment_rating);
        this.file_size = file_size;
        this.system_compatibility = system_compatibility;
    }

    public EBook(double file_size, String system_compatibility) {
        this.file_size = file_size;
        this.system_compatibility = system_compatibility;
    }

    public double getFile_size() {
        return file_size;
    }

    public void setFile_size(double file_size) {
        this.file_size = file_size;
    }

    public String getSystem_compatibility() {
        return system_compatibility;
    }

    public void setSystem_compatibility(String system_compatibility) {
        this.system_compatibility = system_compatibility;
    }


    ///BURAYI GÜNCELLEEEE

}

