/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Operations;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import konverter.KonverterGUIDK;
import mainscreen.JFXMain;
//import mainscreen_org.JFXMain;
import soket_klijent_kontroler.KontrolerKlijent;

/**
 *
 * @author Korisnik
 */
public class KontrolerGUILogin {

    FXMLLoginController fxcon;

    public KontrolerGUILogin(FXMLLoginController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;

        this.fxcon.loginBtn.setOnAction(e -> ulogujKorisnika());
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

    public void ulogujKorisnika() {
        try {
            Korisnik k = new Korisnik();
            KonverterGUIDK.konvertujGUIUDK(fxcon, k);

            Korisnik kor = (Korisnik) KontrolerKlijent.getInstance().pozivSistemskeOperacije(Operations.PRIJAVI_KORISNIKA, k);
            KontrolerKlijent.getInstance().setUlogovaniKor(kor);
            poruka("Uspesno prijavljivanje!");
            JFXMain glavnaForma;
            Stage s;
            glavnaForma = new JFXMain();
            s = new Stage();
            glavnaForma.start(s);

            this.fxcon.closeStage();
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Neuspesno prijavljivanje");
        }
    }
}
