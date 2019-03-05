package util;

import dataaccess.*;
import dataaccess.view.BookView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mekuanent Kassaye on 2019-03-05.
 */
public class DataConversion {

    public static ObservableList<BookView> getBookListView(Person person){
        return FXCollections.observableArrayList(person.getPersonRole().bookList().stream()
                .map(book -> new BookView(book.getIsbn() + "", book.getTitle(),
                        book.getAuthors().stream().map(author -> author.getFirstName() + " " + author.getLastName())
                                .collect(Collectors.joining( "\n" )),
                        book.getBookCopies().stream().anyMatch(BookCopy::isAvailable) ?"yes": "no",
                        book.getBookCopies().size())).collect(Collectors.toList()));

    }

    private static void testData() {
        Admin admin = new Admin();

        BookAuthor author1 = new BookAuthor("Joan", "hasgd", "+251215", "asdha", "asdgjhasghd", null);
        BookAuthor author2 = new BookAuthor("Gareth", "Bale", "+251215", "asdha", "asdgjhasghd", null);
        BookAuthor author3 = new BookAuthor("Diago", "Maradona", "+251215", "asdha", "asdgjhasghd", null);
        BookAuthor author4 = new BookAuthor("Kylian", "MBappe", "+251215", "asdha", "asdgjhasghd", null);
        BookAuthor author5 = new BookAuthor("Mohammad", "Salah", "+251215", "asdha", "asdgjhasghd", null);

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

        Book book1 = new Book(902876, "Screamin Jay", bookAuthors1, bookCopies1);
        Book book2 = new Book(987612, "Nina Simon", bookAuthors2, bookCopies2);

        Storage.books.put(book1.getIsbn(), book1);
        Storage.books.put(book2.getIsbn(), book2);

        Person person = new Person("ajhsgd", "ahjsgdhjas", new Admin());

        getBookListView(person).forEach(bookView -> System.out.println(bookView));
    }


}
