package dataaccess;

import com.sun.istack.internal.NotNull;
import util.Storage;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mekuanent Getachew on 2019-03-05.
 */
public class SuperAdmin extends Admin implements Serializable {

    private Librarian librarian = new Librarian();

    @Override
    public boolean checkout(int libraryMemberId, int isbn, Date dueDate){
        return librarian.checkout(libraryMemberId, isbn, dueDate);
    }

    @Override
    public String getRole() {
        return PersonRole.LIBRARIAN_ROLE;
    }

}
