//package util;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class Transition {
//    public static void TransitionTo(String view){
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("views/admin.fxml"));
//
//            Stage stage = new Stage();
//            stage.setTitle("Library System");
//            stage.setScene(new Scene(root, 450, 450));
//
//            stage.show();
//            ((Node)(action.getSource())).getScene().getWindow().hide();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
