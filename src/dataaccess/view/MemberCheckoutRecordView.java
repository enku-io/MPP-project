package dataaccess.view;

import dataaccess.BookCopy;
import dataaccess.LibraryMember;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mekuanent Kassaye on 2019-03-06.
 */
public class MemberCheckoutRecordView implements Serializable {

    private int bookCopyId, libraryMemberId, isbn;
    private String bookTitle, fullName;
    private Date checkoutDate, dueDate;


    public MemberCheckoutRecordView(int bookCopyId, int libraryMemberId, int isbn, String bookTitle, String fullName, Date checkoutDate, Date dueDate) {
        this.bookCopyId = bookCopyId;
        this.libraryMemberId = libraryMemberId;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.fullName = fullName;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return libraryMemberId + " | " + bookCopyId + " | " + isbn + " | " + bookTitle + " | " + fullName + " | " + checkoutDate.toLocaleString() + " | " + dueDate.toLocaleString();
    }

    public int getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(int bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public int getLibraryMemberId() {
        return libraryMemberId;
    }

    public void setLibraryMemberId(int libraryMemberId) {
        this.libraryMemberId = libraryMemberId;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
