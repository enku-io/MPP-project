package dataaccess;

import util.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mekuanent Kassaye on 2019-03-04.
 */
public class Librarian extends PersonRole{

    public List<Book> bookList(){
        return new ArrayList<>(Storage.books.values());
    }

    public boolean checkout(int libraryMemberId, BookCopy bookCopy){

        return false;
    }

}