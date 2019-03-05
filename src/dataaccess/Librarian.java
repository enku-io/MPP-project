package dataaccess;

import com.sun.istack.internal.NotNull;
import util.Storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class Librarian extends PersonRole {

    @Override
    public List<Book> bookList(){
        return new ArrayList<>(Storage.books.values());
    }

    @Override
    public boolean checkout(int libraryMemberId, @NotNull BookCopy bookCopy, Date dueDate){
        if(bookCopy.isAvailable()){
            CheckoutRecord checkoutRecord = Storage.checkoutRecords.get(libraryMemberId);
            bookCopy.setAvailable(false);
            checkoutRecord.getEntries().add(new CheckoutRecordEntry(bookCopy, new Date(), dueDate));
            return true;
        }
        return false;
    }

    @Override
    public String getRole() {
        return PersonRole.LIBRARIAN_ROLE;
    }
}