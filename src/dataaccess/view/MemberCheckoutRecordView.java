package dataaccess.view;

import dataaccess.BookCopy;
import dataaccess.LibraryMember;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mekuanent Kassaye on 2019-03-06.
 */
public class MemberCheckoutRecordView implements Serializable {

    private String bookCopyId, libraryMemberId, isbn;
    private String bookTitle, fullName;
    private String checkoutDate, dueDate;


    public MemberCheckoutRecordView(String bookCopyId, String libraryMemberId, String isbn, String bookTitle, String fullName, String checkoutDate, String dueDate) {
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
        return libraryMemberId + " | " + bookCopyId + " | " + isbn + " | " + bookTitle + " | " + fullName + " | " + checkoutDate + " | " + dueDate;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public String getLibraryMemberId() {
        return libraryMemberId;
    }

    public void setLibraryMemberId(String libraryMemberId) {
        this.libraryMemberId = libraryMemberId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
