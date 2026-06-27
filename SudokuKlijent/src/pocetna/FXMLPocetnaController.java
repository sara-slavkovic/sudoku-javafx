/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pocetna;

import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class FXMLPocetnaController {

    @FXML
    public Button register;

    @FXML
    public Button login;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        KontrolerGUIPocetna kngui = new KontrolerGUIPocetna(this);
    }

    public Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }
}
