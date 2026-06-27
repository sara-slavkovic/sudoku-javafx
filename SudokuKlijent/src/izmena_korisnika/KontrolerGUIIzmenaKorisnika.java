/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package izmena_korisnika;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Operations;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import konverter.KonverterGUIDK;
import soket_klijent_kontroler.KontrolerKlijent;

/**
 *
 * @author Korisnik
 */
public class KontrolerGUIIzmenaKorisnika {

    FXMLIzmenaKorisnikaController fxcon;

    public KontrolerGUIIzmenaKorisnika(FXMLIzmenaKorisnikaController fxcon) {
        this.fxcon = fxcon;

        this.fxcon.registerBtn.setOnAction(e -> azurirajKorisnika());
        KonverterGUIDK.konvertujDKUGUI(KontrolerKlijent.getInstance().getUlogovaniKor(), fxcon);
    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        DialogPane dialogPane = infoAlert.getDialogPane();
        dialogPane.getStylesheets().add("CSS/alert.css");
        dialogPane.getStyleClass().add("sudoku-alert");
        infoAlert.showAndWait();
    }

    public void azurirajKorisnika() {
        try {
            Korisnik korisnik = KontrolerKlijent.getInstance().getUlogovaniKor();
            KonverterGUIDK.konvertujGUIUDK(fxcon, korisnik);
            KontrolerKlijent.getInstance().pozivSistemskeOperacije(Operations.AZURIRAJ_KORISNIKA, korisnik);
            poruka("Uspesno izmenjeni podaci!");
            fxcon.parentController.stage.setTitle("Zdravo " + korisnik.getKorisnickoIme());

            this.fxcon.closeStage();
            if (fxcon.parentController != null) {
                fxcon.parentController.getStage().show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne moze da azurira korisnika");
        }
    }
}
