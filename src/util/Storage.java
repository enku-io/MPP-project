package util;

import dataaccess.Book;
import dataaccess.Librarian;
import dataaccess.LibraryMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class Storage {

    public static HashMap<Integer, LibraryMember> libraryMembers = new HashMap<>();
    public static HashMap<Integer, Book> books = new HashMap<>();

    private static DataClass dataClass = new DataClass();

    public static int getNextLibraryMemberId(){
        return ++dataClass.libraryMemberId;
    }

    public static int getNextBookAuthorId(){
        return ++dataClass.bookAuthorId;
    }

}
