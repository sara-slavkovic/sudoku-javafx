/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package izmena_korisnika;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainscreen.FXMLGlavnaFormaController;
//import mainscreen_org.FXMLGlavnaFormaController;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class FXMLIzmenaKorisnikaController {

    public FXMLGlavnaFormaController parentController;
    @FXML
    public TextField korisnickoIme;

    @FXML
    public PasswordField lozinka;

    @FXML
    public Button registerBtn;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        KontrolerGUIIzmenaKorisnika kngui = new KontrolerGUIIzmenaKorisnika(this);
    }

    public Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

    public void setParentController(FXMLGlavnaFormaController parentController) {
        this.parentController = parentController;
    }
}
