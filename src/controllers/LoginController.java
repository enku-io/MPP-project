package controllers;

import dataaccess.Person;
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
        if(nameTextField.getText().isEmpty()) {
            usernameErrorLabel.setVisible(true);
        }else if(passwordField.getText().isEmpty()){
            passwordErrorLabel.setVisible(true);
        }else if(Person.login(nameTextField.getText().trim(),passwordField.getText().trim()) == null){
            usernameErrorLabel.setText("Username or Password not found");
        }else{
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
