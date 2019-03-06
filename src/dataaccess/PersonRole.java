package dataaccess;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public abstract class PersonRole implements Serializable {

    public static final String ADMIN_ROLE = "admin";
    public static final String LIBRARIAN_ROLE = "librarian";
    public static final String SUPER_ADMIN_ROLE = "super";

    public abstract @NotNull String getRole();

    public List<LibraryMember> libraryMemberList(){
        return null;
    }

    public List<Book> bookList(){
        return null;
    }

    public boolean addLibraryMembers(LibraryMember... libraryMember){
        return false;
    }

    public boolean editLibraryMember(int id, LibraryMember libraryMember){
        return false;
    }

    public boolean removeLibraryMember(int id){
        return false;
    }

    public boolean addBooks(Book... books){
        return false;
    }

    public boolean addBookCopiesToBook(int bookId, BookCopy... bookCopies){
        return false;
    }

    public boolean checkout(int libraryMemberId, int isbn, Date dueDate){
        return false;
    }

}