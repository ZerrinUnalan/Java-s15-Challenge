package Resource;

import model.Author;
import model.Book;
import model.Genre;
import model.Reader;

import java.util.List;

public interface BookResource {
    void addBook(Book book);
    Book getBookByIsbn(int id);
    List<Book> getBooksByTitle(String title);
    List<Book> getBookByAuthor(String author);
    void updateBook(Book book);
    void deleteBook(Book book);
    void deleteBookByTitle(Book book);
    List<Book> getBooksByCategory(Genre genre);
    List<Book> getBooksByAuthor(Author author);
    void borrowBook(Reader reader, Book book);
    void returnBook(Reader reader, Book book);
    List<Book> getAllBooks();



}

