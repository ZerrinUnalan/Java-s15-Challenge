package model;

import java.util.List;
import java.util.Map;

public class Library {
    private Map<Integer,Book> books;

    private List<Reader> readers;

    public Library(Map<Integer, Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void addReader(Reader reader) {
        readers.set(reader.getId(),reader);
    }

    public void removeReader(Reader reader) {
        readers.remove(reader);
    }


}