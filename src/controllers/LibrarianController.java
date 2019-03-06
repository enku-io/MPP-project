package controllers;

import dataaccess.view.BookView;
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

public class LibrarianController {
    @FXML
    private TableView tableView;
    @FXML
    private Button checkoutButton;
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
    public void initialize(){
        isbnColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isbn"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("author"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<BookView,String>("isAvailable"));
        copiesColumn.setCellValueFactory(new PropertyValueFactory<BookView,Number>("copies"));
        tableView.setItems(DataConversion.getBookListView(Storage.session));
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
