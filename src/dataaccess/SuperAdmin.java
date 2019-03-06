package dataaccess;

import com.sun.istack.internal.NotNull;
import dataaccess.view.MemberCheckoutRecordView;
import dataaccess.view.OverdueView;
import util.Storage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class SuperAdmin extends Admin implements Serializable {

    private Librarian librarian = new Librarian();

    @Override
    public boolean checkout(int libraryMemberId, int isbn, Date dueDate){
        return librarian.checkout(libraryMemberId, isbn, dueDate);
    }

    @Override
    public List<MemberCheckoutRecordView> getRecordByMemberId(int libraryMemberId){
        return librarian.getRecordByMemberId(libraryMemberId);
    }

    @Override
    public void printCheckoutRecords(List<MemberCheckoutRecordView> checkoutRecords){
        librarian.printCheckoutRecords(checkoutRecords);
    }

    @Override
    public OverdueView getOverdueRecord(int isbn){
        return librarian.getOverdueRecord(isbn);
    }

    @Override
    public String getRole() {
        return PersonRole.SUPER_ADMIN_ROLE;
    }

}
