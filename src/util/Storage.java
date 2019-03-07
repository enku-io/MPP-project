package util;

import dataaccess.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static util.FileHandler.*;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class Storage {

    public static HashMap<Integer, LibraryMember> libraryMembers = new HashMap<>();
    public static HashMap<Integer, Book> books = new HashMap<>();
    public static HashMap<Integer, CheckoutRecord> checkoutRecords = new HashMap<>();

    private static DataClass dataClass = new DataClass();

    public static List<Person> users = new ArrayList<>();

    public static Person session;


    public static int getNextLibraryMemberId(){
        return ++dataClass.libraryMemberId;
    }

    public static int getNextBookAuthorId(){
        return ++dataClass.bookAuthorId;
    }

    public static void persistData(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeObject(LIBRARY_MEMBER_FNAME, libraryMembers);
        fileHandler.writeObject(BOOKS_FNAME, books);
        fileHandler.writeObject(CHECKOUT_REC_FNAME, checkoutRecords);
        fileHandler.writeObject(DATA_CLASS_FNAME, dataClass);
        fileHandler.writeObject(USER_FNAME, users);
    }

    public static void init(){
        FileHandler fileHandler = new FileHandler();
        libraryMembers = fileHandler.readObject(LIBRARY_MEMBER_FNAME, new HashMap<>());
        books = fileHandler.readObject(BOOKS_FNAME, new HashMap<>());
        checkoutRecords = fileHandler.readObject(CHECKOUT_REC_FNAME, new HashMap<>());
        dataClass = fileHandler.readObject(DATA_CLASS_FNAME, new DataClass());

        List<Person> users = new ArrayList<>();
        users.add(new Person("aman", "1234", new Admin()));
        users.add(new Person("enku", "1234", new Librarian()));
        users.add(new Person("mak", "1234", new SuperAdmin()));
        Storage.users = fileHandler.readObject(USER_FNAME, users);
    }


}
