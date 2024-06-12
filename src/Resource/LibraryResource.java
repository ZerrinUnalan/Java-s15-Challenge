package Resource;

import model.Book;
import model.Library;

import java.util.HashMap;
import java.util.Map;

public class LibraryResource {
    private Library library;

    public LibraryResource(Library library) {
        this.library = library;
    }

    public Map<Integer,Book> getBooks(){
        return library.getBooks();
    }



    public Map<Integer,Book> getBooksByCategory(String category){
        Map<Integer,Book> booksByCategory=new HashMap<>();

        for(int bookId:library.getBooks().keySet()){
            Book book=library.getBooks().get(bookId);
            if(book.getGenre().equals(category)){
                booksByCategory.put(bookId,book);
            }

        }
        return booksByCategory;
    }

    public Map<Integer,Book> getBooksByAuthor(String author){
        Map<Integer,Book> booksByAuthor=new HashMap<>();

        for(int bookId:library.getBooks().keySet()){
            Book book=library.getBooks().get(bookId);
            if(book.getAuthor().equals(author)){
                booksByAuthor.put(bookId,book);
            }
        }
        return booksByAuthor;
    }

}