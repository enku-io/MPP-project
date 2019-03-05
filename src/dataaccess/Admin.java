package dataaccess;

import util.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class Admin extends PersonRole{

    public List<LibraryMember> libraryMemberList(){
        return new ArrayList<>(Storage.libraryMembers.values());
    }

    public List<Book> bookList(){
        return new ArrayList<>(Storage.books.values());
    }

    public boolean addLibraryMembers(LibraryMember... libraryMember){
        Arrays.stream(libraryMember).forEach(member -> {
            int id = Storage.getNextLibraryMemberId();
            Storage.libraryMembers.put(id, member);
        });
        return true;
    }

    public boolean editLibraryMember(int id, LibraryMember libraryMember){
        if(!Storage.libraryMembers.containsKey(id))
            return false;

        Storage.libraryMembers.put(id, libraryMember);
        return true;
    }

    public boolean removeLibraryMember(int id){
        if(!Storage.libraryMembers.containsKey(id))
            return false;
        Storage.libraryMembers.remove(id);
        return true;
    }

    public boolean addBooks(Book... books){
        Arrays.stream(books).forEach(book -> {
            book.getAuthors().forEach(author -> {
                author.setId(Storage.getNextBookAuthorId());
            });

            Storage.books.put(book.getIsbn(), book);
        });
        return true;
    }

    public boolean addBookCopiesToBook(int bookId, BookCopy... bookCopies){
        if(!Storage.books.containsKey(bookId))
            return false;
        Book book = Storage.books.get(bookId);
        book.setBookCopies(Arrays.asList(bookCopies));
        return true;
    }

}