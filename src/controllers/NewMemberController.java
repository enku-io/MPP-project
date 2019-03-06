package controllers;

import dataaccess.Address;
import dataaccess.LibraryMember;
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

public class NewMemberController {
    @FXML
    private Button addMem;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField street;
    @FXML
    private TextField city;
    @FXML
    private TextField state;
    @FXML
    private TextField zip;
    @FXML
    private TextField telephone;
    @FXML
    private Label errorMessage;

    @FXML
    private void handleNewMember(ActionEvent action){
        if(firstName.getText().isEmpty() || lastName.getText().isEmpty() || street.getText().isEmpty() || city.getText().isEmpty() || state.getText().isEmpty() || zip.getText().isEmpty() || telephone.getText().isEmpty()){
            if(firstName.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " first name not set");
            }
            if(lastName.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " lastName not set");
            }
            if(street.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " street name not set");
            }
            if(city.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " city name not set");
            }
            if(state.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " state name not set");
            }
            if(zip.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " zip name not set");
            }
            if(telephone.getText().isEmpty()){
                errorMessage.setText(errorMessage.getText() + " telephone name not set");
            }
        }else{
            LibraryMember member = new LibraryMember(firstName.getText(),lastName.getText(),telephone.getText(),new Address(street.getText(),city.getText(),state.getText(),zip.getText()));
            Storage.session.getPersonRole().addLibraryMembers(member);
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("views/admin.fxml"));

                Stage stage = new Stage();
                stage.setTitle("Library System");
                stage.setScene(new Scene(root, 450, 450));

                stage.show();
                ((Node)(action.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
