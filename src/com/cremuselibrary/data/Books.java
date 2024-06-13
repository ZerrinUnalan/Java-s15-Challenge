
package com.cremuselibrary.data;

import com.cremuselibrary.model.Book;

import java.util.HashMap;
import java.util.Map;

public class Books {
    private final Map<Integer, Book> books;

    public Books() {

        books=new HashMap<>();

        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", true);
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", true);
        Book book3 = new Book(3, "1984", "George Orwell", "Science Fiction", true);
        Book book4 = new Book(4, "Pride and Prejudice", "Jane Austen", "Romance", true);
        Book book5 = new Book(5, "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", true);
        Book book6 = new Book(6, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", true);
        Book book7 = new Book(7, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
        Book book8 = new Book(8, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", true);
        Book book9 = new Book(9, "The Alchemist", "Paulo Coelho", "Adventure", true);
        Book book10 = new Book(10, "The Hunger Games", "Suzanne Collins", "Dystopian", true);


        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);
        books.put(book4.getId(), book4);
        books.put(book5.getId(), book5);
        books.put(book6.getId(), book6);
        books.put(book7.getId(), book7);
        books.put(book8.getId(), book8);
        books.put(book9.getId(), book9);
        books.put(book10.getId(), book10);
    }


    public Map<Integer, Book> getBooks() {
        return books;
    }
}
