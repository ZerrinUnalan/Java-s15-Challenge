package com.cremuselibrary.readerinterface;

import com.cremuselibrary.resource.ReaderResource;
import com.cremuselibrary.model.Book;
import com.cremuselibrary.model.Librarian;
import com.cremuselibrary.model.Reader;
import com.cremuselibrary.resource.BookResource;
import com.cremuselibrary.resource.BillResource;
import com.cremuselibrary.resource.LibraryResource;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryApplication {
    private final BookResource bookResource;
    private ReaderResource readerResource;
    private final LibraryResource libraryResource;
    private final BillResource billResource;
    static Scanner scanner;


    public LibraryApplication(BookResource bookResource, ReaderResource readerResource, LibraryResource libraryResource, BillResource billResource) {
        this.bookResource = bookResource;
        this.libraryResource = libraryResource;
        this.readerResource= readerResource;
        this.billResource = billResource;
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BookResource bookResource = new BookResource() {
            @Override
            public void addBook(Book book) {

            }

            @Override
            public Book getBookById(int id) {
                return null;
            }

            @Override
            public List<Book> getBooksByTitle(String title) {
                return List.of();
            }

            @Override
            public List<Book> getBookByAuthor(String author) {
                return List.of();
            }

            @Override
            public void updateBook(int bookId, Book book) {

            }

            @Override
            public void deleteBook(int book) {

            }

            @Override
            public void deleteBookByTitle(Book book) {

            }

            @Override
            public <Genre> List<Book> getBooksByGenre(Genre genre) {
                return List.of();
            }

            @Override
            public <Author> List<Book> getBooksByAuthor(Author author) {
                return List.of();
            }

            @Override
            public void borrowBook(Reader reader, Book book) {

            }

            @Override
            public void returnBook(Reader reader, Book book) {

            }

            @Override
            public List<Book> getAllBooks() {
                return List.of();
            }
        };
        LibraryResource libraryResource = new LibraryResource();
        BillResource billResource = new BillResource();

        ReaderResource readerResource = new ReaderResource();
        LibraryApplication app = new LibraryApplication(bookResource, readerResource, libraryResource, billResource);

        System.out.println("Welcome to the CREMUSE LIBRARY!");
        System.out.println("--------------");
        System.out.println("--------------");

        int choice;
        do {
            System.out.println("Press 1 to continue, or 2 to exit:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Reader librarian = new Reader();
                    app.start(librarian);
                    break;
                case 2:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 2);

        scanner.close();
    }

    public void start(Reader librarian) {
        System.out.println("Moving to the reader interface.");
        Reader reader = new Reader();  // Varsayalım ki Reader sınıfının bir örneği var
        ReaderInterface readerInterface = new ReaderInterface(this.bookResource, this.libraryResource, this.billResource);
        readerInterface.start(reader);
    }

    public ReaderResource getReaderResource() {
        return readerResource;
    }

    public void setReaderResource(ReaderResource readerResource) {
        this.readerResource = readerResource;
    }
}

class ReaderInterface {
    private final BookResource bookResource;
    private final LibraryResource libraryResource;
    private final BillResource billResource;

    public ReaderInterface(BookResource bookResource, LibraryResource libraryResource, BillResource billResource) {
        this.bookResource = bookResource;
        this.libraryResource = libraryResource;
        this.billResource = billResource;
    }

    public void start(Reader reader) {
        int choice;

        do {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. List Books");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            choice = LibraryApplication.scanner.nextInt();
            LibraryApplication.scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(reader);
                    break;
                case 2:
                    updateBook(reader);
                    break;
                case 3:
                    deleteBook(reader);
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    listBooks(reader);
                    break;
                case 7:
                    System.out.println("Exiting. Thank you!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    public void listBooks(Reader reader) {
        System.out.println("------ List of Books ------");
        for (Book book : libraryResource.getBooks().values()) {
            System.out.println("Id: " + book.getId());
            System.out.println("Name: " + book.getName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
            System.out.println("-----------------------------");
        }
    }

    private void returnBook() {
        System.out.println("Enter book Id to return: ");
        int bookId = LibraryApplication.scanner.nextInt();
        if (libraryResource.getBooks().containsKey(bookId)) {
            System.out.println("Book with id " + bookId + " returned successfully.");
            System.out.println("Fine amount: " + billResource.calculateFineForAllBills() + " Tl");
            Map<Integer, Book> updatedBooks = libraryResource.getBooks();
            Book returnedBook = updatedBooks.get(bookId);

            if (returnedBook != null) {
                returnedBook.setAvailable(true);
                updatedBooks.put(bookId, returnedBook);
            }
        } else {
            System.out.println("Book with id " + bookId + " is not borrowed.");
        }
    }

    private void borrowBook() {
        System.out.println("Enter book id to borrow: ");
        int bookId = LibraryApplication.scanner.nextInt();
        Map<Integer, Book> books = libraryResource.getBooks();
        Book borrowedBook = books.get(bookId);
        if (books.containsKey(bookId) && borrowedBook.isAvailable()) {
            System.out.println(billResource.canReaderBorrowBooks());
            System.out.println("Book with id " + bookId + " is borrowed successfully");
            borrowedBook.setAvailable(false);
            books.put(bookId, borrowedBook);
        } else {
            System.out.println("Book that has this id not found or is not available.");
        }
    }

    public void deleteBook(Reader reader) {
        if (reader instanceof Librarian) {
            System.out.println("Enter book Id to delete: ");
            int id = LibraryApplication.scanner.nextInt();
            bookResource.deleteBook(id);
        } else {
            System.out.println("Only librarians can delete books.");
        }
    }

    public void updateBook(Reader reader) {
        if (reader instanceof Librarian) {
            System.out.println("Enter book Id to update: ");
            int bookId = LibraryApplication.scanner.nextInt();
            LibraryApplication.scanner.nextLine();
            System.out.println("Enter new book details: ");
            System.out.println("Name: ");
            String name = LibraryApplication.scanner.nextLine();
            System.out.println("Author: ");
            String author = LibraryApplication.scanner.nextLine();
            System.out.println("Genre: ");
            String genre = LibraryApplication.scanner.nextLine();

            Book updatedBook = new Book(bookId, name, author, genre, true);
            bookResource.updateBook(bookId, updatedBook);
        } else {
            System.out.println("Only librarians can update books.");
        }
    }

    public void addBook(Reader reader) {
        if (reader instanceof Librarian) {
            System.out.println("Enter book details:");
            System.out.println("Id: ");
            int id = LibraryApplication.scanner.nextInt();
            LibraryApplication.scanner.nextLine();

            if (libraryResource.getBooks().containsKey(id)) {
                System.out.println("A book with this ID already exists. Book cannot be added.");
                return;
            }
            System.out.println("Name: ");
            String name = LibraryApplication.scanner.nextLine();
            System.out.println("Author: ");
            String author = LibraryApplication.scanner.nextLine();
            System.out.println("Genre: ");
            String genre = LibraryApplication.scanner.nextLine();

            Book book = new Book(id, name, author, genre, true);
            bookResource.addBook(book);
            System.out.println("Book added successfully");
        } else {
            System.out.println("Only librarians can add books.");
        }
    }
}
