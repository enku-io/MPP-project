package controllers;

import dataaccess.Person;
import dataaccess.PersonRole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    Button loginButton;
    @FXML
    TextField nameTextField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label usernameErrorLabel;
    @FXML
    Label passwordErrorLabel;

    @FXML
    private void handleButtonAction(ActionEvent action){
        Person person = Person.login(nameTextField.getText().trim(),passwordField.getText().trim());
        if(nameTextField.getText().isEmpty()) {
            usernameErrorLabel.setVisible(true);
        }else if(passwordField.getText().isEmpty()){
            passwordErrorLabel.setVisible(true);
        }else if(person == null){
            usernameErrorLabel.setText("Username or Password not found");
        }else{
            if(person.getPersonRole().getRole() == PersonRole.ADMIN_ROLE || person.getPersonRole().getRole() == PersonRole.SUPER_ADMIN_ROLE){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("views/admin.fxml"));

                    Stage stage = new Stage();
                    stage.setTitle("Library System - Admin");
                    stage.setScene(new Scene(root, 1000, 600));

                    stage.show();
                    ((Node)(action.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("views/librarian.fxml"));

                    Stage stage = new Stage();
                    stage.setTitle("Library System - Librarian");
                    stage.setScene(new Scene(root, 1000, 600));

                    stage.show();
                    ((Node)(action.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
