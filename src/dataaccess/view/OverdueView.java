package dataaccess.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-06.
 */
public class OverdueView {

    private String title;
    private String isbn;
    private ObservableList<BookCopyView> bookCopyViews = FXCollections.observableArrayList(new ArrayList<>());

    public OverdueView(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ObservableList<BookCopyView> getBookCopyViews() {
        return bookCopyViews;
    }

    public void setBookCopyViews(ObservableList<BookCopyView> bookCopyViews) {
        this.bookCopyViews = bookCopyViews;
    }

    public static class BookCopyView{
        private String id;
        private String memberId;
        private String memberFullName;
        private String due, checkoutDate;

        public BookCopyView(String id, String memberId, String memberFullName, String due, String checkoutDate) {
            this.id = id;
            this.memberId = memberId;
            this.memberFullName = memberFullName;
            this.due = due;
            this.checkoutDate = checkoutDate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getMemberFullName() {
            return memberFullName;
        }

        public void setMemberFullName(String memberFullName) {
            this.memberFullName = memberFullName;
        }

        public String getDue() {
            return due;
        }

        public void setDue(String due) {
            this.due = due;
        }

        public String getCheckoutDate() {
            return checkoutDate;
        }

        public void setCheckoutDate(String checkoutDate) {
            this.checkoutDate = checkoutDate;
        }
    }

}
