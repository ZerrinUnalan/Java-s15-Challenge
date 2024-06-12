package Resource;

import model.Book;
import model.Reader;

import java.util.List;

public interface BookResource {
    void addBook(Book book);
    Book getBookById(int id);
    List<Book> getBooksByTitle(String title);
    List<Book> getBookByAuthor(String author);
    void updateBook(int bookId, Book book);
    void deleteBook(int book);
    void deleteBookByTitle(Book book);
    <Genre> List<Book> getBooksByGenre(Genre genre);
    <Author> List<Book> getBooksByAuthor(Author author);
    void borrowBook(Reader reader, Book book);
    void returnBook(Reader reader, Book book);
    List<Book> getAllBooks();



}

