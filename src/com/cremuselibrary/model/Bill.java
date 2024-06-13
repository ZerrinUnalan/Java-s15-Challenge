package com.cremuselibrary.model;

import java.util.Date;

public class Bill {
    private int readerId;
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
    private double fineAmount;

    public Bill(int readerId, int bookId, Date borrowDate, Date returnDate, double fineAmount) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public int getReaderId() {
        return readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "readerId=" + readerId +
                ", bookId=" + bookId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", fineAmount=" + fineAmount +
                '}';
    }
}