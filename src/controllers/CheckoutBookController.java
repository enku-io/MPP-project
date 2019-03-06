package controllers;

import dataaccess.view.BookView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import util.DataConversion;
import util.Storage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CheckoutBookController {
    @FXML
    private TextField librarianID;
    @FXML
    private MenuButton booksMenu;
    @FXML
    private Button checkout;
    @FXML
    private ListView bookList;


    @FXML
    public void initialize(){
        bookList.setCellFactory(new PropertyValueFactory<BookView,String>("isbn"));
        bookList.setItems(DataConversion.getBookListView(Storage.session));
    }

    @FXML
    private void checkoutHandler(ActionEvent event){


    }
}
