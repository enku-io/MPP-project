package dataaccess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class CheckoutRecord {

    private List<CheckoutRecordEntry> entries = new ArrayList<>();
    private LibraryMember libraryMember;

    /**
     * @return the entries
     */
    public List<CheckoutRecordEntry> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(List<CheckoutRecordEntry> entries) {
        this.entries = entries;
    }

    /**
     * @return the libraryMember
     */
    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    /**
     * @param libraryMember the libraryMember to set
     */
    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }

    

}