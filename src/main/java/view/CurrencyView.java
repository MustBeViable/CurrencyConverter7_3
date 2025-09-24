package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CurrencyView extends Application {

    public void start(Stage stage) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/currency_converter.fxml"));


        if (fxmlLoader == null) {
            throw new IllegalStateException("FXML not found on classpath");
        }
        try {
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Currency converter");
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}