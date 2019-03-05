package dataaccess;

import com.sun.istack.internal.NotNull;
import util.Storage;

import java.util.Date;

/**
 * Created by Mekuanent Getachew on 2019-03-05.
 */
public class SuperAdmin extends Admin {

    private Librarian librarian = new Librarian();

    @Override
    public boolean checkout(int libraryMemberId, @NotNull BookCopy bookCopy, Date dueDate){
        return librarian.checkout(libraryMemberId, bookCopy, dueDate);
    }

    @Override
    public String getRole() {
        return PersonRole.LIBRARIAN_ROLE;
    }

}
