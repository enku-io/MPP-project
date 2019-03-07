import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Storage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Storage.init();
        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 795.0, 488.0);
        scene.getStylesheets().add("./src/DarkTheme.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        Storage.persistData();
        super.stop();
    }
}
