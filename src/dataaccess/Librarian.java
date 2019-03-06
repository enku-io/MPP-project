package dataaccess;

import com.sun.istack.internal.NotNull;
import dataaccess.view.MemberCheckoutRecordView;
import dataaccess.view.OverdueView;
import util.Storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("Book does not exist!");
        return false;
    }

    @Override
    public List<MemberCheckoutRecordView> getRecordByMemberId(int libraryMemberId){
        if(Storage.checkoutRecords.containsKey(libraryMemberId)){
            CheckoutRecord checkoutRecord = Storage.checkoutRecords.get(libraryMemberId);
            List<MemberCheckoutRecordView> recordViews = new ArrayList<>();
            checkoutRecord.getEntries().forEach(checkoutRecordEntry -> {
                recordViews.add(
                  new MemberCheckoutRecordView(
                          checkoutRecordEntry.getBookCopy().getId(),
                          checkoutRecord.getLibraryMember().getId(),
                          checkoutRecordEntry.getBookCopy().getBook().getIsbn(),
                          checkoutRecordEntry.getBookCopy().getBook().getTitle(),
                          checkoutRecordEntry.getBookCopy().getBook().getAuthors().stream()
                                  .map(author -> author.getFirstName() + " " + author.getLastName())
                          .collect(Collectors.joining("\n")),
                          checkoutRecordEntry.getCheckoutDate(),
                          checkoutRecordEntry.getDueDate()
                  )
                );
            });
            return recordViews;
        }else{
            System.out.println("Record don't exist");
            return new ArrayList<>();
        }
    }

    @Override
    public void printCheckoutRecords(List<MemberCheckoutRecordView> checkoutRecords){

        System.out.println("Member ID | ISBN | Copy ID | Book Title | Full Name | Checkout Date | Due Date");

        checkoutRecords.forEach(System.out::println);

    }

    @Override
    public OverdueView getOverdueRecord(int isbn){
        if(Storage.books.containsKey(isbn)){
            Book book = Storage.books.get(isbn);
            OverdueView overdueView = new OverdueView(book.getTitle(), isbn + "");
            Storage.checkoutRecords.values().forEach(checkoutRecord -> {
                checkoutRecord.getEntries().stream()
                        .filter(checkoutRecordEntry -> checkoutRecordEntry.getBookCopy().getBook().getIsbn() == isbn)
                .forEach(checkoutRecordEntry -> {
                    overdueView.getBookCopyViews()
                            .add(new OverdueView.BookCopyView(
                                    checkoutRecordEntry.getBookCopy().getId() + "",
                                    checkoutRecord.getLibraryMember().getId() + "",
                                    checkoutRecord.getLibraryMember().getFirstName() + " " + checkoutRecord.getLibraryMember().getLastName(),
                                    checkoutRecordEntry.getDueDate().toLocaleString(),
                                    checkoutRecordEntry.getCheckoutDate().toLocaleString()
                            ));
                });

            });
            return overdueView;
        }else{
            return null;
        }

    }


    @Override
    public String getRole() {
        return PersonRole.LIBRARIAN_ROLE;
    }
}