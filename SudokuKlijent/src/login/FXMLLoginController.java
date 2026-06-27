/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class FXMLLoginController {

    public Stage stage;

    @FXML
    public TextField korisnickoIme;

    @FXML
    public PasswordField lozinka;

    @FXML
    public Button loginBtn;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        KontrolerGUILogin kngui = new KontrolerGUILogin(this);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }
}
