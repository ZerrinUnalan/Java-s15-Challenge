package model;


import Data.Database;
import Resource.BookResource;

import java.util.List;

public class BookManager implements BookResource {
    private Database database;

    public BookManager(Database database) {
        this.database = database;
    }

    public void addBook(Book book) {
        database.addBook(book);
    }

    @Override
    public Book getBookByIsbn(int isbn) {
        return database.getBookByIsbn(isbn);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return database.getBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        return database.getBooksByAuthor(authorName);
    }

    @Override
    public void updateBook(Book book) {
        database.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        database.deleteBook(id);
    }

    @Override
    public void deleteBookByTitle(Book book) {
        database.deleteBook(book.getBook_isbn());
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return database.getBooksByGenre(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return database.getBooksByAuthor(author);
    }


    public List<Author> getAllAuthors() {
        return database.getAllAuthorsDatabase();
    }
    @Override
    public void borrowBook(Reader reader, Book book) {
        if (!book.isBorrowed()) {
            if (reader.getBorrowedBooks().size() < 5) {
                book.setBorrowed(true);
                book.setBorrower(reader);
                database.borrowBook(reader, book);
                double totalPrice = book.getPrice();
                System.out.println("Total price for borrowed book: " + totalPrice);

            } else {
                System.out.println("Reader has reached the borrowing limit.");
            }
        } else {
            System.out.println("Book is already borrowed by another reader.");
        }
    }

    @Override
    public void returnBook(Reader reader, Book book) {

        if(book.isBorrowed()){
            book.setBorrowed(false);
            database.returnBookDatabase(reader, book);
        }


    }


    @Override
    public List<Book> getAllBooks() {
        return database.getAllBooksDatabase();
    }
}