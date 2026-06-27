/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

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
public class JFXLogin extends Application {

    FXMLLoginController con;

    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLLogin.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLLoginController) fxmlLoader.getController();
        con.setStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/login_register.css");
        stage.setScene(scene);
        stage.setTitle("Sudoku - prijava");
        stage.show();
    }

}
