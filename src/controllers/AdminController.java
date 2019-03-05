package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    Button addMemberButton;
    @FXML
    Button addBookButton;
    @FXML
    Button listMemberButton;
    @FXML
    Button listBooks;
    @FXML
    Button addBookCopyButton;

    @FXML
    private void addMemberEvent(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/add_member.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Member");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addBooksEvent(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/add_book.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Book");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
