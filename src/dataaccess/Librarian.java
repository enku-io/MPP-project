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
                CheckoutRecord checkoutRecord;
                if(Storage.checkoutRecords.containsKey(libraryMemberId))
                    checkoutRecord = Storage.checkoutRecords.get(libraryMemberId);
                else{
                    if(Storage.libraryMembers.containsKey(libraryMemberId)){
                        LibraryMember member = Storage.libraryMembers.get(libraryMemberId);
                        checkoutRecord = new CheckoutRecord(member);
                        Storage.checkoutRecords.put(libraryMemberId, checkoutRecord);
                    }else {
                        System.out.println("Library Member does not exist!");
                        return false;
                    }

                }

                copy.setAvailable(false);
                checkoutRecord.getEntries().add(new CheckoutRecordEntry(copy, new Date(), dueDate));
                return true;
            }
        }

        return false;
    }

    public LibraryMember getRecordByMemberId(int libraryMemberId){
        if(Storage.checkoutRecords.containsKey(libraryMemberId)){

            return null;
        }else{
            System.out.println("Record don't exist");
            return null;
        }
    }


    @Override
    public String getRole() {
        return PersonRole.LIBRARIAN_ROLE;
    }
}