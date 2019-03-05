package dataaccess;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class LibraryMember{

    private int id;
    private String firstName, lastName, phoneNumber;
    private Address address;

    public LibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}