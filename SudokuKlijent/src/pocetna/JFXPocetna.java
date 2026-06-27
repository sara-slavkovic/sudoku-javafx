/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pocetna;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Korisnik
 */
public class JFXPocetna extends Application {

    FXMLPocetnaController con;

    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLPocetna.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLPocetnaController) fxmlLoader.getController();
        con.setStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/pocetna.css");
        stage.setScene(scene);
        stage.setTitle("Sudoku");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
