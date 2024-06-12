import Data.Database;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    static Scanner scanner = new Scanner(System.in);
    static Database database = new Database();
    static ReaderManager readerManager = new ReaderManager(database);
    static BookManager bookManager = new BookManager(database);

    public static void main(String[] args) {

        System.out.println("Welcome to the CREMUSE LIBRARY!");
        System.out.println("--------------");
        System.out.println("--------------");

        Reader loggedInReader = null;
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // Register
                System.out.println("Enter your name:");
                String name = scanner.next();

                System.out.println("Enter your surname:");
                String surname = scanner.next();

                System.out.println("Enter your email:");
                String email = scanner.next();

                if (ReaderManager.isEmailRegisteredBefore(email)) {
                    System.out.println("Email is already registered. Please choose another email.");
                } else {
                    System.out.println("Enter your password:");
                    String password = scanner.next();


                    Reader newReader = new Reader(database.generateNewProcessId(), name, surname, email, password, new ArrayList<>());
                    ReaderManager.addReader(newReader);
                    System.out.println("Registration successful!");
                    System.out.println("---------------");
                }

            } else if (choice == 2) {
                // Login
                System.out.println("Enter your email:");
                String email = scanner.next();

                System.out.println("Enter your password:");
                String password = scanner.next();

                if (ReaderManager.checkReader(email, password)) {
                    System.out.println("Login successful!");
                    System.out.println("----------");
                    loggedInReader = database.getReaderByEmail(email);
                    processes(loggedInReader);

                } else {
                    System.out.println("Invalid email or password. Please try again.");
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close();
    }

    public static void processes(Reader loggedInReader) {

        while (true) {

            System.out.println("Please choose an option:");
            System.out.println("1. Add New Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show All Books with CommentRatings");
            System.out.println("5. Show Advices According to Genre");
            System.out.println("6. Update a Book Info");
            System.out.println("7. Delete a Book");
            System.out.println("8. Show CommentRatings");
            System.out.println("9. Add CommentRatings");
            System.out.println("9. Go to Cremuse Library's Goodreads Community");


            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                //the book added to library
                System.out.println("Enter name of the book:");
                String title = scanner.nextLine();

                System.out.println("Enter name of the author:");
                String authorName = scanner.nextLine();

                System.out.println("Enter surname of the author:");
                String authorSurname = scanner.nextLine();

                Author author = new Author(authorName, authorSurname);
                System.out.println("Enter book genre:");
                Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());

                System.out.println("Enter the price of the book:");

                String priceInput = scanner.nextLine().trim();

                if (!priceInput.isEmpty()) {
                    try {
                        double price = Double.parseDouble(priceInput);
                        Book newBook = new Book(database.generateNewProcessId(), title, author, genre, false, price, loggedInReader);
                        bookManager.addBook(newBook);
                        System.out.println("Book added successfully!");
                        System.out.println("----------");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price input. Please enter a valid number.");
                    }
                } else {
                    System.out.println("Invalid price input. Please enter a valid number.");
                }
            } else if (choice == 2) {
                //borrow book
                System.out.println("Enter your email:");
                String email = scanner.nextLine();

                System.out.println("Enter book title:");
                String bookTitle = scanner.nextLine();

                Reader reader = database.getReaderByEmail(email);
                Book book = bookManager.getBooksByTitle(bookTitle).stream()
                        .filter(b -> !b.isBorrowed())
                        .findFirst()
                        .orElse(null);

                if (reader == null || book == null) {
                    System.out.println("Reader or book not found.");
                } else {
                    bookManager.borrowBook(reader, book);
                    System.out.println("Book borrowed successfully!");
                    System.out.println("--------------");
                }
            } else if (choice == 3) {
                //return book
                System.out.println("Enter your email:");
                String email = scanner.nextLine();

                System.out.println("Enter book title:");
                String bookTitle = scanner.nextLine();

                Reader reader = database.getReaderByEmail(email);
                Book book = bookManager.getBooksByTitle(bookTitle).stream()
                        .filter(b -> b.isBorrowed() && b.getBorrower().equals(reader))
                        .findFirst()
                        .orElse(null);

                if (reader == null || book == null) {
                    System.out.println("Reader or borrowed book not found.");
                } else {
                    bookManager.returnBook(reader, book);
                    System.out.println("Book returned successfully!");
                    System.out.println("------------------");
                }
            }  else if (choice == 4) {
                List<Book> allBooks = bookManager.getAllBooks();

                if (allBooks.isEmpty()) {
                    System.out.println("No books available in the library.");
                } else {
                    System.out.println("All Books with CommentRatings:");
                    for (Book book : allBooks) {
                        System.out.println("Book Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor().getName() +" "+ book.getAuthor().getSurname());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("Price: " + book.getPrice());
/**********************BURAYI KONROL ETTTT*/
                    }
                }
            }
            else if(choice == 5){

                System.out.println("Enter the genre:");
                Genre genre = Genre.valueOf(scanner.nextLine());

                List<Book> booksInGenre = bookManager.getBooksByGenre(genre);
                if (booksInGenre.isEmpty()) {
                    System.out.println("No books available in this genre.");
                } else {
                    System.out.println("Books in " + genre + " genre:");
                    for (Book book : booksInGenre) {
                        System.out.println(book);
                    }
                }
            }
            else if(choice == 6){

                System.out.println("Enter the title of the book to update:");
                String titleToUpdate = scanner.nextLine();

                List<Book> booksToUpdate = bookManager.getBooksByTitle(titleToUpdate); // we received the all books as list and type of book!!
                if (booksToUpdate.isEmpty()) {
                    System.out.println("Book not found.");
                } else {
                    Book oneBookToUpdate = booksToUpdate.get(0);
                    System.out.println("Enter new title:");
                    String newTitle = scanner.nextLine();
                    oneBookToUpdate.setTitle(newTitle);

                    System.out.println("Enter new author name:");
                    String newAuthorName = scanner.nextLine();

                    System.out.println("Enter new author surname:");
                    String newAuthorSurname = scanner.nextLine();

                    oneBookToUpdate.getAuthor().setName(newAuthorName);
                    oneBookToUpdate.getAuthor().setSurname(newAuthorSurname);

                    System.out.println("Enter new price:");
                    String newPriceInput = scanner.nextLine().trim();

                    if (!newPriceInput.isEmpty()) {
                        try {
                            double newPrice = Double.parseDouble(newPriceInput);
                            oneBookToUpdate.setPrice(newPrice);
                            System.out.println("Book information updated successfully!");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price input. Book information not updated.");
                        }
                    } else {
                        System.out.println("Invalid price input. Book information not updated.");
                    }
                }
            }
            else if (choice == 7) {
                // Delete a Book
                System.out.println("Enter the title of the book to delete:");
                String titleToDelete = scanner.nextLine();

                List<Book> booksToDelete = bookManager.getBooksByTitle(titleToDelete); // we received the all books as list and type of book!!

                if (!booksToDelete.isEmpty()) {
                    for (Book bookToDelete : booksToDelete) {
                        bookManager.deleteBookByTitle(bookToDelete);
                        System.out.println("Book deleted successfully: " + bookToDelete.getTitle());
                    }
                    System.out.println("-------------");
                } else {
                    System.out.println("No books found with the title '" + titleToDelete + "'. Deletion failed.");
                }


                /*choice 8 ve 9 u yapppp*/

            }

            }
        }
    }
