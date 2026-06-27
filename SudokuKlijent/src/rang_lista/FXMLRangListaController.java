/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package rang_lista;

import Server_client.Igra;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.List;

/**
 * FXML Controller class
 *
 * @author Korisnik
 */
public class FXMLRangListaController {

    private ObservableList<Igra> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Igra> rangTabela;

    @FXML
    private TableColumn<Igra, Number> redniBrojKolona;

    @FXML
    private TableColumn<Igra, String> korisnikKolona;

    @FXML
    private TableColumn<Igra, String> vremeKolona;

    @FXML
    private TableColumn<Igra, Number> greskeKolona;

    @FXML
    private Label nivoLabel;

    @FXML
    public void initialize() {
        redniBrojKolona.setCellValueFactory(col
                -> new SimpleIntegerProperty(
                        rangTabela.getItems().indexOf(col.getValue()) + 1
                )
        );
        korisnikKolona.setCellValueFactory(col
                -> new SimpleStringProperty(col.getValue().getKorisnik().getKorisnickoIme())
        );
        vremeKolona.setCellValueFactory(col
                -> new SimpleStringProperty(formatirajVreme(col.getValue().getVremeResavanja()))
        );
        greskeKolona.setCellValueFactory(col
                -> new SimpleIntegerProperty(col.getValue().getBrojGresaka())
        );

        rangTabela.setItems(data);
    }

    public void setData(List<Igra> lista, String nivo) {
        data.setAll(lista);
        nivoLabel.setText("Nivo: " + nivo);
    }

    private String formatirajVreme(int sekundi) {
        return String.format("%02d:%02d", sekundi / 60, sekundi % 60);
    }

}
