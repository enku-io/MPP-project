package dataaccess;

import com.sun.istack.internal.NotNull;
import util.Storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class Librarian extends PersonRole implements Serializable {

    @Override
    public List<Book> bookList(){
        return new ArrayList<>(Storage.books.values());
    }

    @Override
    public boolean checkout(int libraryMemberId, int isbn, Date dueDate){

        if(Storage.books.containsKey(isbn)){
            Book book = Storage.books.get(isbn);
            BookCopy copy = book.getBookCopies().stream().filter(BookCopy::isAvailable).findFirst().orElse(null);
            if(copy != null){
                CheckoutRecord checkoutRecord = Storage.checkoutRecords.get(libraryMemberId);
                copy.setAvailable(false);
                checkoutRecord.getEntries().add(new CheckoutRecordEntry(copy, new Date(), dueDate));
                return true;
            }
        }

        return false;
    }

    @Override
    public String getRole() {
        return PersonRole.LIBRARIAN_ROLE;
    }
}