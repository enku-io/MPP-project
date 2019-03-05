package dataaccess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class Book{

    private int isbn;
    private String title;
    private List<BookAuthor> authors = new ArrayList<>();
    private List<BookCopy> bookCopies = new ArrayList<>();

    public Book(int isbn, String title, List<BookAuthor> authors, boolean isAvailable, List<BookCopy> bookCopies) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.bookCopies = bookCopies;
    }

    public Book(int isbn, String title, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
    }

    public List<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<BookAuthor> authors) {
        this.authors = authors;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}