package dataaccess;

import util.Storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class Admin extends PersonRole implements Serializable {

    @Override
    public List<LibraryMember> libraryMemberList(){
        return new ArrayList<>(Storage.libraryMembers.values());
    }

    @Override
    public List<Book> bookList(){
        return new ArrayList<>(Storage.books.values());
    }

    @Override
    public boolean addLibraryMembers(LibraryMember... libraryMember){
        Arrays.stream(libraryMember).forEach(member -> {
            int id = Storage.getNextLibraryMemberId();
            member.setId(id);
            Storage.libraryMembers.put(id, member);
        });
        return true;
    }

    @Override
    public boolean editLibraryMember(int id, LibraryMember libraryMember){
        if(!Storage.libraryMembers.containsKey(id))
            return false;

        Storage.libraryMembers.put(id, libraryMember);
        return true;
    }

    @Override
    public boolean removeLibraryMember(int id){
        if(!Storage.libraryMembers.containsKey(id))
            return false;
        Storage.libraryMembers.remove(id);
        return true;
    }

    @Override
    public boolean addBooks(Book... books){
        Arrays.stream(books).forEach(book -> {
            book.getAuthors().forEach(author -> {
                author.setId(Storage.getNextBookAuthorId());
            });

            book.getBookCopies().forEach(bookCopy -> {
                bookCopy.setBook(book);
            });

            Storage.books.put(book.getIsbn(), book);
        });
        return true;
    }

    @Override
    public boolean addBookCopiesToBook(int bookId, BookCopy... bookCopies){
        if(!Storage.books.containsKey(bookId))
            return false;
        Book book = Storage.books.get(bookId);
        List<BookCopy> bookCopies1 = new ArrayList<>();
        Arrays.stream(bookCopies).forEach(bookCopy -> {
            bookCopy.setBook(book);

        });

        bookCopies1.addAll(book.getBookCopies());
        bookCopies1.addAll(Arrays.asList(bookCopies));

        book.setBookCopies(bookCopies1);


        return true;
    }

    @Override
    public String getRole() {
        return PersonRole.ADMIN_ROLE;
    }
}