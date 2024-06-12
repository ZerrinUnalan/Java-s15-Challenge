package Data;

import model.Book;
import model.EBook;
import model.Genre;
import model.Reader;
import model.Author;
import model.Process;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Database {

    private AtomicInteger processIdCounter = new AtomicInteger(1);

    public int generateNewProcessId() {
        return processIdCounter.getAndIncrement();
    }

    private Map<Integer, Book> books;
    /*private Map<Integer, EBook> ebooks; */
    private Map<Integer, Reader> readers;
    private Map<Integer, Process> processes;

    public Database() {
        books = new HashMap<>();
       /* ebooks = new HashMap<>(); */
        readers = new HashMap<>();
        processes = new HashMap<>();
    }

    // BOOK METHODS

    public List<Book> getAllBooksDatabase() {
        return books.values().stream().toList();
    }

    public void addBook(Book book) {
        books.put(book.getBook_isbn(), book);
    }

    public Book getBookByIsbn(int isbn) {
        return books.get(isbn);
    }

    public List<Book> getBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return books.values().stream().filter(book -> book.getAuthor().equals(authorName)).collect(Collectors.toList());
    }

    public void updateBook(Book book) {
        books.put(book.getBook_isbn(), book);
    }

    public void deleteBook(int isbn) {
        books.remove(isbn);
    }

    public List<Book> getBooksByGenre(Genre genre) {
        return books.values().stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }



    public void borrowBook(Reader reader, Book book) {
        int newProcessId = generateNewProcessId();
        Process process = new Process(newProcessId, reader, book, false);
        process.put(process.getId(), process);
        reader.getBorrowedBooks().add(book);
        book.setBorrowed(true);
        books.remove(book.getBook_isbn());
    }

    public void returnBookDatabase(Reader reader, Book book) {
        Process process = processes.get(book.getBook_isbn());
        if (process != null && !process.isReturned()) {
            process.setReturned(true);
            book.setBorrowed(false);
            book.setBorrower(null);
            reader.getBorrowedBooks().remove(book);
        }
    }


    /* EBOOK METHODS

    public List<EBook> getAllEBooksDatabase() {
        return ebooks.values().stream().toList();
    }

    public void addEBook(EBook ebook) {
        ebooks.put(ebook.getBook_isbn(), ebook);
    }

    public EBook getEBookByIsbn(int isbn) {
        return ebooks.get(isbn);
    }

    public List<EBook> getEBooksByTitle(String title) {
        return ebooks.values().stream()
                .filter(ebook -> ebook.getTitle().equals(title)).collect(Collectors.toList());
    }

    public List<EBook> getEBooksByAuthor(String authorName) {
        return ebooks.values().stream().filter(ebook -> ebook.getAuthor().equals(authorName)).collect(Collectors.toList());
    }

    public void updateEBook(EBook ebook) {
        ebooks.put(ebook.getBook_isbn(), ebook);
    }

    public void deleteEBook(int isbn) {
        ebooks.remove(isbn);
    }

    public List<EBook> getEBooksByCategory(Genre genre) {
        return ebooks.values().stream().filter(ebook -> ebook.getGenre().equals(genre)).collect(Collectors.toList());
    }  */


    // reader methods

    public void addReader(Reader reader) {
        readers.put(reader.getReader_id(), reader);
    }

    public Reader getReaderById(int id) {
        return readers.get(id);
    }

    public Reader getReaderByEmail(String email) {
        return readers.values().stream()
                .filter(reader -> reader.reader_mail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void updateReader(Reader reader) {
        readers.put(reader.getReader_id(), reader);
    }

    public void deleteUser(int id) {
        readers.remove(id);
    }

    public List<Reader> getAllUsers() {
        return new ArrayList<>(readers.values());
    }

    @Override
    public String toString() {
        return "Database{" + "books=" + books + ", readers=" + readers + ", processes=" + processes + '}';
    }

    public List<Author> getAllAuthorsDatabase() {
        return books.values().stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }
}
