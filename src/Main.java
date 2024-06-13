import com.cremuselibrary.data.Books;
import com.cremuselibrary.data.Readers;
import com.cremuselibrary.model.*;
import com.cremuselibrary.resource.BookResource;
import com.cremuselibrary.resource.BillResource;
import com.cremuselibrary.resource.LibraryResource;
import com.cremuselibrary.resource.ReaderResource;
import com.cremuselibrary.readerinterface.LibraryApplication;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Readers data
        Readers readers=new Readers();

        //----------
        Reader librarian=new Librarian(1,"Araz Mehmet Şen");


        //Books data
        Books books=new Books();
        Library library=new Library(books.getBooks(),readers.getReaders());

        Bill bill=new Bill(1,2,new Date(),new Date(System.currentTimeMillis()+100000),0);//her reader için ayrı ayrı bill tutmak için bill,billResource'da list olarak tutuldu.
        List<Bill> bills=new ArrayList<>();
        bills.add(bill);

        BookResource bookResource= new BookResource() {
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
        BillResource billResource=new BillResource(bills,library);
        LibraryResource libraryResource=new LibraryResource();
        ReaderResource readerResource=new ReaderResource();

        LibraryApplication console=new LibraryApplication(bookResource,readerResource,libraryResource,billResource);

        console.start(librarian);


    }
}