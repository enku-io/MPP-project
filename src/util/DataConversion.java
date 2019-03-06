package util;

import dataaccess.*;
import dataaccess.view.BookView;
import dataaccess.view.LibraryMemberView;
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

    public static ObservableList<LibraryMemberView> getLibraryMembersView(Person person){
        return FXCollections.observableArrayList(person.getPersonRole().libraryMemberList().stream()
                .map(libraryMember -> new LibraryMemberView(libraryMember.getFirstName(),
                        libraryMember.getLastName(), libraryMember.getPhoneNumber(),
                        libraryMember.getAddress().getStreet() + ", " + libraryMember.getAddress().getCity() +
                        ", " + libraryMember.getAddress().getState())).collect(Collectors.toList()));

    }



}
