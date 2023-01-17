package so.edu.hodmas.ims.hucims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HUCIMSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HUCIMSApplication.class.getResource("views/students.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);

        stage.setTitle("HUC-IMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}