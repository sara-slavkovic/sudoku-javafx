/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igra;

import DomenskiObjekat.Igra;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainscreen.FXMLGlavnaFormaController;

/**
 *
 * @author Korisnik
 */
public class JFXIgra extends Application {

    FXMLIgraController con;
    private FXMLGlavnaFormaController parentController;
    private Igra igra; //null je nova igra; konkretan obj je nastavak zapocete igre

    public JFXIgra() {
    }

    public JFXIgra(Igra igra) {
        this.igra = igra;
    }

    public void start(Stage stage) throws Exception {
        String resourcePath = "/igra/FXMLIgra.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLIgraController) fxmlLoader.getController();
        con.setStage(stage);
        con.setParentController(parentController);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/igra.css");
        stage.setScene(scene);
        stage.setTitle("IGRA");

        con.setIgra(igra); //objekat nove igre ili nastavak zapocete

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setParentController(FXMLGlavnaFormaController parentController) {
        this.parentController = parentController;
    }
}
