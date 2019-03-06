package controllers;

import dataaccess.Address;
import dataaccess.Book;
import dataaccess.BookAuthor;
import dataaccess.BookCopy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Storage;

import java.io.IOException;
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
    private Button addBook;
    @FXML
    private Label errorLabel;

    @FXML
    private void addBookEvent(ActionEvent event){

        if(isbn.getText().isEmpty() || title.getText().isEmpty() || authorFirstName.getText().isEmpty() || authorLastName.getText().isEmpty() || authorBio.getText().isEmpty()){
            if(isbn.getText().isEmpty()){
                errorLabel.setText( errorLabel.getText() + " ISBN is required\n");
            }
            if(title.getText().isEmpty()){
                errorLabel.setText( errorLabel.getText() + " title is required\n");
            }
            if(authorFirstName.getText().isEmpty()){
                errorLabel.setText( errorLabel.getText() + " authorFirstName is required\n");
            }
            if(authorLastName.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " authorLastName is required\n");
            }
            if(authorBio.getText().isEmpty()){
                errorLabel.setText(errorLabel.getText() + " authorBio is required\n");
            }
        }
        else{
            try {
                ArrayList<BookAuthor> authors = new ArrayList<BookAuthor>();
                authors.add(new BookAuthor(authorFirstName.getText().trim(),authorLastName.getText().trim(),"1-641-451-7053","asdf",authorBio.getText(),new Address("asdf","asdf","asdf","asdf")));
                ArrayList<BookCopy> copy  = new ArrayList<BookCopy>();
                Book book = new Book(Integer.parseInt(isbn.getText().trim()),title.getText().trim(),authors,copy);
                Storage.session.getPersonRole().addBooks(book);
                Parent root;
                root = FXMLLoader.load(getClass().getClassLoader().getResource("views/admin.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Library System");
                stage.setScene(new Scene(root, 450, 450));

                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch(NumberFormatException e){
                errorLabel.setText(errorLabel.getText() + " ISBN and Number of Copies should be Numbers");
            }
        }

    }

}
