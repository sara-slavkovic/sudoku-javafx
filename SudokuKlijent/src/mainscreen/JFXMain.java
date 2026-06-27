/* 
 * @autor prof. dr Sinisa Vlajic,  
 * Univerzitet u Beogradu'
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo 
 * Laboratorija za softversko inzenjerstvo 
 * Datum:2026-05-11 Sudoku aplikacija
 */
package mainscreen;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import soket_klijent_kontroler.KontrolerKlijent;

public class JFXMain extends Application {

    FXMLGlavnaFormaController con;

    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLGlavnaForma.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLGlavnaFormaController) fxmlLoader.getController();
        con.setStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/main.css");
        stage.setScene(scene);
        stage.setTitle("Zdravo " + KontrolerKlijent.getInstance().getUlogovaniKor().getKorisnickoIme());
        stage.show();
    }
}
