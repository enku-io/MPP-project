package controllers;

import dataaccess.Book;
import dataaccess.BookAuthor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Storage;

import java.util.ArrayList;


public class AddBookController {
    @FXML
    private TextField isbn;
    @FXML
    private TextField title;
    @FXML
    private TextField authorFirstName;
    @FXML
    private TextField authorLastName;
    @FXML
    private TextField authorBio;
    @FXML
    private TextField numberOfCopies;
    @FXML
    private Button addBook;
    @FXML
    private Label errorLabel;

    @FXML
    private void addBookEvent(ActionEvent event){
        if(isbn.getText().isEmpty() || title.getText().isEmpty() || authorFirstName.getText().isEmpty() || authorLastName.getText().isEmpty() || authorBio.getText().isEmpty() || numberOfCopies.getText().isEmpty()){
            if(isbn.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " ISBN is required");
            }
            if(title.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " title is required");
            }
            if(authorFirstName.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " authorFirstName is required");
            }
            if(authorLastName.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " authorLastName is required");
            }
            if(authorBio.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " authorBio is required");
            }
            if(numberOfCopies.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " numberOfCopies is required");
            }
        }
        else{
            ArrayList<BookAuthor> authors = new ArrayList<BookAuthor>();
            authors.add(new BookAuthor(authorFirstName.getText().trim(),authorLastName.getText().trim(),null,null,authorBio.getText(),null));
            Book book = new Book(Integer.parseInt(isbn.getText().trim()),title.getText().trim(),authors,null);
            Storage.session.getPersonRole().addBooks(book);
        }

    }

}
