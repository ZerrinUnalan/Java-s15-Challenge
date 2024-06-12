
package ReaderInterface;

import model.Book;
import model.Librarian;
import model.Library;
import model.Reader;
import Resource.BookResource;
import Resource.BillResource;
import Resource.LibraryResource;
import Resource.ReaderResource;

import java.util.Map;
import java.util.Scanner;

public class LibraryApplication {
    private BookResource bookResource;
    private ReaderResource readerResource;
    private LibraryResource libraryResource;
    private BillResource invoiceResource;
    private static Scanner scanner;

    public LibraryApplication(BookResource bookResource, ReaderResource readerResource, LibraryResource libraryResource, BillResource invoiceResource) {
        this.bookResource = bookResource;
        this.readerResource = readerResource;
        this.libraryResource = libraryResource;
        this.invoiceResource = invoiceResource;
        this.scanner = new Scanner(System.in);
    }


    public void start(Reader reader){
        int choice;

        do{
            System.out.println("Library Management System");
            System.out.println("1.Add Book");
            System.out.println("2.Update Book");
            System.out.println("3.Delete Book");
            System.out.println("4.Borrow Book");
            System.out.println("5.Return Book");
            System.out.println("6.List Books");
            System.out.println("7.Exit");
            System.out.println("Enter your choice: ");
            choice=scanner.nextInt();
            scanner.nextLine();


            switch (choice){
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
                    listBooks();
                    break;
                case 7:
                    System.out.println("Exiting..Thank you!!");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");

            }

        }while (choice!=7);
    }

    public void listBooks() {
        System.out.println("------ List of Books ------");
        for(Book book:libraryResource.getBooks().values()){
            System.out.println("Id: "+book.getId());
            System.out.println("Name: "+book.getName());
            System.out.println("Author: "+book.getAuthor());
            System.out.println("Genre: "+book.getGenre());
            System.out.println("Available: "+(book.isAvailable()?"Yes":"No"));
            System.out.println("-----------------------------");
        }
    }

    private void returnBook() {
        System.out.println("Enter book Id to return: ");
        int bookId=scanner.nextInt();
        if(!libraryResource.getBooks().containsKey(bookId)){
            System.out.println("Book with id "+bookId+" returned successfully.");
            System.out.println("Fine amount: "+invoiceResource.calculateFineForAllBills()+" Tl");
            Map<Integer, Book> updatedBooks = libraryResource.getBooks();
            Book returnedBook=updatedBooks.get(bookId);

            if (returnedBook != null) {
                returnedBook.setAvailable(true);
                updatedBooks.put(bookId, returnedBook);
            }
        }else {
            System.out.println("Book with id "+bookId+" is not borrowed.");
        }
    }

    private void borrowBook() {
        System.out.println("Enter book id to borrow: ");
        int bookId=scanner.nextInt();
        Map<Integer,Book> books=libraryResource.getBooks();
        Book borrowedBook=books.get(bookId);
        if(books.containsKey(bookId) && borrowedBook.isAvailable()){
            System.out.println(invoiceResource.canReaderBorrowBooks());
            System.out.println("Book with id "+bookId+" is borrowed successfully");
            borrowedBook.setAvailable(false);
            books.remove(bookId,borrowedBook);
        }else {
            System.out.println("Book that has this id not found");
        }
    }

    public void deleteBook(Reader reader) {
        if(reader instanceof Librarian){
            System.out.println("Enter book Id to delete: ");
            int id=scanner.nextInt();
            bookResource.deleteBook(id);
        }else {
            System.out.println("Only librarians can delete books.");
        }

    }

    public void updateBook(Reader reader) {
        if(reader instanceof Librarian){
            System.out.println("Enter book Id to update: ");
            int bookId=scanner.nextInt();
            System.out.println("Enter new book details: ");
            System.out.println("Name: ");
            String name=scanner.nextLine();
            System.out.println("Author: ");
            String author=scanner.nextLine();
            System.out.println("Genre: ");
            String genre=scanner.nextLine();

            Book updatedBook=new Book(bookId,name,author,genre,true);

            bookResource.updateBook(bookId,updatedBook);
        }else {
            System.out.println("Only librarians can update books.");
        }

    }

    public void addBook(Reader reader) {
        if(reader instanceof Librarian){
            System.out.println("Enter book details:");
            System.out.println("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (libraryResource.getBooks().containsKey(id)) {
                System.out.println("A book with this ID already exists. Book cannot be added.");
                return;
            }
            System.out.println("Name: ");
            String name=scanner.nextLine();
            System.out.println("Author: ");
            String author=scanner.nextLine();
            System.out.println("Genre: ");
            String genre=scanner.nextLine();

            Book book=new Book(id,name,author,genre,true);
            bookResource.addBook(book);
            System.out.println("Book added successfully");
        }else {
            System.out.println("Only librarians can add books.");
        }
    }
}
