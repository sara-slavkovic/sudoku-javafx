/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

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
public class FXMLRegisterController {

    @FXML
    public TextField korisnickoIme;

    @FXML
    public PasswordField lozinka;

    @FXML
    public Button registerBtn;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        KontrolerGUIRegister kngui = new KontrolerGUIRegister(this);
    }

    public Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }
}
