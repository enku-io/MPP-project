package dataaccess;

import java.io.Serializable;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class BookCopy implements Serializable {

    private int id;
    private boolean available;
    private Book book;

    public BookCopy(int id, boolean available) {
        this.id = id;
        this.available = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}