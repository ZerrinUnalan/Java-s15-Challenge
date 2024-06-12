package model;

public interface LibraryAction {
    void addBook(Book book);
    void deleteBook(int bookId);
    void updateBook(int bookId,Book updatedBook);
}