package model;

import java.time.LocalDateTime;

public class Process {
    private int id;
    private Reader reader;
    private Book book;
    private EBook ebook;

    private boolean returned;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private double invoiceAmount;

    public Process(int newTransactionId, Reader reader, Book book, EBook ebook, boolean returned, LocalDateTime borrowDate) {
        this.id = newTransactionId;
        this.reader = reader;
        this.book = book;
        this.ebook = ebook;
        this.returned = returned;
        this.borrowDate = borrowDate;

    }
}
