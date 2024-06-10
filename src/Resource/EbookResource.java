package Resource;

import model.Author;
import model.EBook;
import model.Genre;
import model.Reader;

import java.util.List;

public interface EbookResource {
    void addEBook(EBook ebook);
    EBook getEBookByIsbn(int id);
    List<EBook> getEBooksByTitle(String title);
    List<EBook> getEBookByAuthor(String author);
    void updateEBook(EBook eBook);
    void deleteEBook(EBook ebook);
    void deleteEBookByTitle(EBook ebook);
    List<EBook> getEBooksByCategory(Genre genre);
    List<EBook> getEBooksByAuthor(Author author);
    void borrowEBook(Reader reader, EBook ebook);
    void returnEBook(Reader reader, EBook ebook);
    List<EBook> getAllEBooks();
}
