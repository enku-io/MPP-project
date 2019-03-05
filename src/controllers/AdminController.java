package controllers;

import dataaccess.LibraryMember;
import dataaccess.view.BookView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    Button addMemberButton;
    @FXML
    Button addBookButton;
    @FXML
    Button addBookCopyButton;
    @FXML
    TableView<LibraryMember> memberTableView;
    @FXML
    TableView<BookView> bookTableView;
    @FXML
    TableColumn isbnColumn;
    @FXML
    TableColumn titleColumn;
    @FXML
    TableColumn authorColumn;
    @FXML
    TableColumn isAvailableColumn;
    @FXML
    TableColumn copiesColumn;

    private ObservableList<BookView> data;

    @FXML
    public void initialize(){
        data = FXCollections.observableArrayList(
                new BookView("123123123", "Smith", "abebe","true",5),
                new BookView("asdf", "Smveith","abebe", "true",5),
                new BookView("asefedf", "efe", "abebe","true",5),
                new BookView("efe", "ef", "abebe","true",5),
                new BookView("asdf", "fe","abebe", "true",5)
        );

        isbnColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("author"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isAvailable"));
        copiesColumn.setCellValueFactory(new PropertyValueFactory<BookView,Number>("copies"));
        bookTableView.setItems(data);
    }

    @FXML
    private void addMemberEvent(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/new_member.fxml"));
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
