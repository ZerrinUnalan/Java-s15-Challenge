package com.cremuselibrary.resource;

import com.cremuselibrary.model.Book;
import com.cremuselibrary.model.Library;

import java.util.HashMap;
import java.util.Map;

public class LibraryResource {
    private Library library;

    public LibraryResource() {
        // Library nesnesi burada başlatılabilir veya daha sonra setLibrary metodu ile atanabilir
    }

    public Map<Integer, Book> getBooks() {
        if (library == null) {
            // Eğer library null ise, boş bir kitap haritası döndür
            return new HashMap<>();
        }
        return library.getBooks();
    }

    public Map<Integer, Book> getBooksByGenre(String genre) {
        Map<Integer, Book> booksByGenre = new HashMap<>();

        if (library != null) {
            for (int bookId : library.getBooks().keySet()) {
                Book book = library.getBooks().get(bookId);
                if (book.getGenre().equals(genre)) {
                    booksByGenre.put(bookId, book);
                }
            }
        }
        return booksByGenre;
    }

    public Map<Integer, Book> getBooksByAuthor(String author) {
        Map<Integer, Book> booksByAuthor = new HashMap<>();

        if (library != null) {
            for (int bookId : library.getBooks().keySet()) {
                Book book = library.getBooks().get(bookId);
                if (book.getAuthor().equals(author)) {
                    booksByAuthor.put(bookId, book);
                }
            }
        }
        return booksByAuthor;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
