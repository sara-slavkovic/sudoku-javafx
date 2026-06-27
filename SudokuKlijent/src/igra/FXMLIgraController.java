/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package igra;

import DomenskiObjekat.Igra;
import DomenskiObjekat.NivoTezine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mainscreen.FXMLGlavnaFormaController;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class FXMLIgraController {

    public FXMLGlavnaFormaController parentController;

    @FXML
    public GridPane sudokuGrid;

    @FXML
    public Label infoLabel;

    @FXML
    public Label nivoLabel;

    @FXML
    public Label vremeLabel;

    @FXML
    public Label greskeLabel;

    @FXML
    public Button novaIgraBtn;

    @FXML
    public Button odustaniBtn;

    private KontrolerGUIIgra kngui;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        kngui = new KontrolerGUIIgra(this);
    }

    // JFXIgra poziva ovo nakon stage.show()
    public void setIgra(Igra igra) {
        if (igra != null) {
            kngui.postaviIgru(igra);
        }
    }

    public Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void closeStage() {
        stage.close();
    }

    public void setParentController(FXMLGlavnaFormaController parentController) {
        this.parentController = parentController;
    }

}
