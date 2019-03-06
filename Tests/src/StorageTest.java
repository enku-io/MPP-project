import dataaccess.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class StorageTest {

    @Before
    public void setUp() throws Exception {
        Storage.init();
    }

    @After
    public void tearDown() throws Exception {
        Storage.persistData();
    }

    /**
     * test conducted on Storage.books hash map
     */
    @Test
    public void persistenceTest() {

        Book book = initTestData();
        Storage.persistData();

        //Remove all book data
        Storage.books = new HashMap<>();

        //recover from memory
        Storage.init();
        Librarian librarian = new Librarian();
        assertEquals(librarian.bookList().get(0).getIsbn(), book.getIsbn());

    }

    private Book initTestData() {

//        LibraryMember member = new LibraryMember("Mekuanent", "Kassaye", "+1 (641) XXX-XXXX",
//                new Address("1000 N. 4th St.", "Fairfield", "Iowa", "52557"));
        Admin admin = new Admin();

        Address address = new Address("1000 N. 4th St.", "Fairfield", "Iowa", "52557");
        BookAuthor author1 = new BookAuthor("Joan", "hasgd", "+251215", "asdha", "asdgjhasghd", address);
        BookAuthor author2 = new BookAuthor("Gareth", "Bale", "+251215", "asdha", "asdgjhasghd", address);
        BookAuthor author3 = new BookAuthor("Diago", "Maradona", "+251215", "asdha", "asdgjhasghd", address);
        BookAuthor author4 = new BookAuthor("Kylian", "MBappe", "+251215", "asdha", "asdgjhasghd", address);
        BookAuthor author5 = new BookAuthor("Mohammad", "Salah", "+251215", "asdha", "asdgjhasghd", address);

        List<BookAuthor> bookAuthors1 = new ArrayList<>(), bookAuthors2 = new ArrayList<>();
        bookAuthors1.add(author1);
        bookAuthors1.add(author2);
        bookAuthors1.add(author3);

        bookAuthors2.add(author4);
        bookAuthors2.add(author5);

        List<BookCopy> bookCopies1 = new ArrayList<>(), bookCopies2 = new ArrayList<>();
        bookCopies1.add(new BookCopy(3123, true));
        bookCopies1.add(new BookCopy(1232, false));

        bookCopies2.add(new BookCopy(3123, false));
        bookCopies2.add(new BookCopy(1232, false));

        Book book1 = new Book(123456, "Screamin Jay", bookAuthors1, bookCopies1);
        Book book2 = new Book(987612, "Nina Simon", bookAuthors2, bookCopies2);

        Storage.books.put(book1.getIsbn(), book1);
        Storage.books.put(book2.getIsbn(), book2);

        admin.addBooks(book1, book2);
        return book1;
    }

}
