package registration_app.maca_lab_wk_09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is a registration app.
 * <p>
 * This app provides a simple registration form GUI with validation for every input through regex expressions.
 *
 * @author John Maca
 */

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Registration!");
        stage.setScene(scene);
        stage.show();
    }
}