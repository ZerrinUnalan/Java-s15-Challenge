
package com.cremuselibrary.resource;

import com.cremuselibrary.model.Bill;
import com.cremuselibrary.model.Library;
import com.cremuselibrary.model.Reader;

import java.util.Date;
import java.util.List;

public class BillResource {

    private List<Bill> bills;
    private Library library;

    public BillResource(List<Bill> bills, Library library) {
        this.bills = bills;
        this.library = library;
    }

    public BillResource() {

    }

    public boolean canReaderBorrowBooks() {
        for (Reader reader : library.getReaders()) {
            int readerId = reader.getId();
            int borrowedBooksCount = 0;

            for (Bill bill : bills) {
                if (bill.getReaderId() == readerId && bill.getReturnDate() == null) {
                    borrowedBooksCount++;
                }
            }

            if (borrowedBooksCount >= 5) {
                return false; // Kullanıcı 5'ten fazla kitap ödünç almış
            }
        }

        return true; // Tüm kullanıcılar 5'ten az kitap ödünç almış
    }

    //Eğer kullanıcı kitabı ödünç alıp 30 gün içinde geri getirmez ise 50 Tl fatura ödemektedir.
    public double calculateFine(Bill bill){
        Date borrowDate=bill.getBorrowDate();
        Date returnDate=bill.getReturnDate();

        if(borrowDate!=null && returnDate!=null){
            long borrowTimeMillis=returnDate.getTime()-borrowDate.getTime();
            long borrowedTimeDays=borrowTimeMillis/(1000*60*60*24);
            if(borrowedTimeDays>30){
                return 50.0;
            }
        }
        return 0.0;
    }
    public double calculateFineForAllBills() {
        double totalFine = 0.0;

        for (Bill bill : bills) {
            double fineAmount = calculateFine(bill);
            totalFine += fineAmount;
        }

        return totalFine;
    }
}
