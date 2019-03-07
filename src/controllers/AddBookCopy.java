package controllers;

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


public class AddBookCopy {
    @FXML
    TextField bookISBN;
    @FXML
    TextField bookCopyID;
    @FXML
    Label errorLabel;
    @FXML
    Button saveButton;

    @FXML
    private void saveButtonAction(ActionEvent event){
        try{
            if(bookISBN.getText().isEmpty() || bookCopyID.getText().isEmpty()){
                errorLabel.setText("Please enter BookID or Book Copy ID");
            }else{
                Storage.session.getPersonRole().addBookCopiesToBook(Integer.parseInt(bookISBN.getText()),new BookCopy(Integer.parseInt(bookCopyID.getText()),true));
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("views/admin.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Admin");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch(NumberFormatException ex){
            errorLabel.setText("Only Numbers allowed");
        }
    }

}
