package controllers;

import dataaccess.LibraryMember;
import dataaccess.PersonRole;
import dataaccess.view.BookView;
import dataaccess.view.LibraryMemberView;
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
import util.DataConversion;
import util.Storage;

import java.io.IOException;

public class AdminController {
    @FXML
    Button addMemberButton;
    @FXML
    Button addBookButton;
    @FXML
    Button addBookCopyButton;
    @FXML
    TableView<LibraryMemberView> memberTableView;
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

    @FXML
    TableColumn firstNameColumn;
    @FXML
    TableColumn lastNameColumn;
    @FXML
    TableColumn phoneNumberColumn;
    @FXML
    TableColumn addressColumn;
    @FXML
    TableColumn idColumn;
    @FXML
    Button logoutButton;
    @FXML
    Button checkoutButton;
    private ObservableList<BookView> data;

    @FXML
    public void initialize(){

        DataConversion.testData();
        isbnColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("author"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isAvailable"));
        copiesColumn.setCellValueFactory(new PropertyValueFactory<BookView,Number>("copies"));


        firstNameColumn.setCellValueFactory(new PropertyValueFactory<LibraryMemberView,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<LibraryMemberView,String>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<LibraryMemberView,String>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<LibraryMemberView,String>("address"));
        idColumn.setCellValueFactory(new PropertyValueFactory<LibraryMemberView,String>("id"));

        bookTableView.setItems(DataConversion.getBookListView(Storage.session));
        memberTableView.setItems(DataConversion.getLibraryMembersView(Storage.session));
        for(LibraryMemberView libraryMemberView: DataConversion.getLibraryMembersView(Storage.session)){
            System.out.println(libraryMemberView.getId());
        }
        checkoutButton.setVisible(false);
        if(Storage.session.getPersonRole().getRole() == PersonRole.SUPER_ADMIN_ROLE){
            checkoutButton.setVisible(true);
        }

    }

    @FXML
    private void addMemberEvent(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/new_member.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Member");
            stage.setScene(new Scene(root, 600, 700));
            stage.show();
//            ((Node)(event.getSource())).getScene().getWindow().hide();
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
            stage.setScene(new Scene(root, 600, 700));
            stage.show();
//            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleLogout(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddBookCopy(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/add_book_copy.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Book Copy");
            stage.setScene(new Scene(root, 600, 500));
            stage.show();
//            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void checkoutEvent(ActionEvent event){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/checkout_books.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Checkout Book");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
