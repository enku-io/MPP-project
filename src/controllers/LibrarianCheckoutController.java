package controllers;

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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LibrarianCheckoutController {
    @FXML
    private TextField memberId;
    @FXML
    private TextField bookISBN;
    @FXML
    private Button checkoutButton;
    @FXML
    private Label errorLabel;

    @FXML
    private void checkoutBookHandler(ActionEvent event){
        if(memberId.getText().isEmpty() || bookISBN.getText().isEmpty()){
            errorLabel.setText("Member ID and Book ISBN Requred");
        }else{
            try{
                Parent root;
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MONTH,1);
                if(Storage.session.getPersonRole().checkout(Integer.parseInt(memberId.getText()),Integer.parseInt(bookISBN.getText()), cal.getTime())){
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("views/new_member.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Add Member");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }else{
                    errorLabel.setText("Member ID or Book ISBN can't be found.");
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch(NumberFormatException ex){
                errorLabel.setText("Member ID and Book ISBN should be Numbers");
            }
        }

    }
}
