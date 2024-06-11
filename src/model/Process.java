package model;

import java.time.Duration;
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
        this.borrowDate = LocalDateTime.now();
    }

        private int generateNewTransactionId() {
            return 0;
        }

        private double calculateInvoiceAmount() {
            Duration loanDuration = Duration.between(borrowDate, returnDate);
            long days = loanDuration.toDays();
            double bookPrice = book.getPrice();
            double invoiceAmount = days * bookPrice;
            return invoiceAmount;
        }

        public void markReturned() {
            this.returned = true;
            this.returnDate = LocalDateTime.now();
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public EBook getEbook() {
        return ebook;
    }

    public void setEbook(EBook ebook) {
        this.ebook = ebook;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Process{" +
                "reader=" + reader +
                ", id=" + id +
                ", book=" + book +
                ", ebook=" + ebook +
                ", returned=" + returned +
                '}';
    }


    //EBOOK İÇİN GÜNCELLENECEK
}
}
