package mainscreen;

/* 
 * @autor prof. dr Sinisa Vlajic,  
 * Univerzitet u Beogradu'
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo 
 * Laboratorija za softversko inzenjerstvo 
 * Datum:2026-05-11 Sudoku aplikacija
 */

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class FXMLGlavnaFormaController {

    @FXML
    public Menu igraj;
    @FXML
    public Menu rezultati;
    @FXML
    public Menu korisnik;
    @FXML
    public Menu izlazIzPrograma;
    @FXML
    public MenuItem novaIgra;
    @FXML
    public MenuItem nastaviIgru;
    @FXML
    public MenuItem rangLista;
    @FXML
    public MenuItem izmeniKorisnika;
    @FXML
    public MenuItem odjaviSe;
    @FXML
    public MenuItem izlaz;

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void closeStage() {
        stage.close();
    }

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        KontrolerGUIMain kngui = new KontrolerGUIMain(this);
    }
}
