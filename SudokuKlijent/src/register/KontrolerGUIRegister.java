/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

import DomenskiObjekat.Korisnik;
import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import konverter.KonverterGUIDK;

/**
 *
 * @author Korisnik
 */
public class KontrolerGUIRegister {

    FXMLRegisterController fxcon;
    GenerickiKontrolerServer webServer = new GenerickiKontrolerServer_Service().getGenerickiKontrolerServerPort();

    public KontrolerGUIRegister(FXMLRegisterController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;
        this.fxcon.registerBtn.setOnAction(e -> registrujKorisnika());
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

    public void registrujKorisnika() {
        try {
            Korisnik korisnik = new Korisnik();
            KonverterGUIDK.konvertujGUIUDK(fxcon, korisnik);
            Server_client.Korisnik webKorisnik = new Server_client.Korisnik();
            webKorisnik.setKorisnickoIme(korisnik.getKorisnickoIme());
            webKorisnik.setLozinka(korisnik.getLozinka());

            int idKorisnika = webServer.registrujKorisnika(webKorisnik);
            poruka("Uspesna registracija!");

            this.fxcon.closeStage();
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne moze da registruje korisnika");
        }
    }

}
