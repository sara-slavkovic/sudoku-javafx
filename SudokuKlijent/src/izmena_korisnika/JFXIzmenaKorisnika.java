/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izmena_korisnika;

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
public class JFXIzmenaKorisnika extends Application {
    
    FXMLIzmenaKorisnikaController con;
    
    FXMLGlavnaFormaController parentController;
    
    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLIzmenaKorisnika.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLIzmenaKorisnikaController) fxmlLoader.getController();
        con.setParentController(parentController);
        con.setStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/login_register.css");
        stage.setScene(scene);
        stage.setTitle("Izmena podatka o korisniku");
        stage.show();
    }

    public void setParentController(FXMLGlavnaFormaController parentController) {
        this.parentController = parentController;
    }
    
}
