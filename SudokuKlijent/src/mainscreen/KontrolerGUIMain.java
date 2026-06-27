/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainscreen;

import mainscreen.*;
import DomenskiObjekat.Igra;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.NivoTezine;
import DomenskiObjekat.Operations;
import DomenskiObjekat.SudokuTabla;
import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import helpers.DialogHelper;
import helpers.IgraHelper;
import igra.JFXIgra;
import izmena_korisnika.JFXIzmenaKorisnika;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import rang_lista.JFXRangLista;
import soket_klijent_kontroler.KontrolerKlijent;

/**
 *
 * @author Korisnik
 */
public class KontrolerGUIMain {

    FXMLGlavnaFormaController fxcon;
    GenerickiKontrolerServer webServer = new GenerickiKontrolerServer_Service().getGenerickiKontrolerServerPort();

    public KontrolerGUIMain(FXMLGlavnaFormaController fxcon) {
        this.fxcon = fxcon;

        this.fxcon.izlaz.setOnAction(e -> krajIgrePoruka("Kraj igre"));
        this.fxcon.rangLista.setOnAction(e -> prikaziRangListu());
        this.fxcon.novaIgra.setOnAction(e -> igrajNovuIgru());
        this.fxcon.nastaviIgru.setOnAction(e -> nastaviZapocetuIgru());
        this.fxcon.izmeniKorisnika.setOnAction(e -> izmeniKorisnika());
        this.fxcon.odjaviSe.setOnAction(e -> odjaviSe());
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

    public void krajIgrePoruka(String poruka) {
        try {
            Korisnik ulogovaniKorisnik = KontrolerKlijent.getInstance().getUlogovaniKor();
            if (ulogovaniKorisnik != null) {
                KontrolerKlijent.getInstance()
                        .pozivSistemskeOperacije(Operations.ODJAVI_KORISNIKA, ulogovaniKorisnik);
                KontrolerKlijent.getInstance().setUlogovaniKor(null);
            }
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Poruka:");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText(poruka);
            DialogPane dialogPane = infoAlert.getDialogPane();
            dialogPane.getStylesheets().add("CSS/alert.css");
            dialogPane.getStyleClass().add("sudoku-alert");
            infoAlert.showAndWait();

            this.fxcon.closeStage();
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Greška prilikom izlaska iz aplikacije.");
        }
    }

    private void prikaziRangListu() {
        try {
            NivoTezine nivo = DialogHelper.prikaziIzbor(
                    "Rang lista",
                    "Izaberite nivo težine",
                    "Nivo:",
                    NivoTezine.LAK,
                    Arrays.asList(
                            NivoTezine.LAK,
                            NivoTezine.SREDNJI,
                            NivoTezine.TEZAK
                    )
            );
            if (nivo == null) {
                return;
            }

            List<Server_client.Igra> igre = webServer.vratiRangListu(nivo.getDbValue());

            if (igre == null || igre.isEmpty()) {
                poruka("Nema rezultata za izabrani nivo težine.");
                return;
            }

            new JFXRangLista(igre, nivo.toString()).start(new Stage());
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne moze da pronadje najbolje rezultate");
        }
    }

    private void igrajNovuIgru() {
        try {
            NivoTezine nivo = DialogHelper.prikaziIzbor(
                    "Nova igra",
                    "Izaberite nivo težine",
                    "Nivo:",
                    NivoTezine.LAK,
                    Arrays.asList(NivoTezine.LAK, NivoTezine.SREDNJI, NivoTezine.TEZAK)
            );
            if (nivo == null) {
                return;
            }
            SudokuTabla param = IgraHelper.napraviParamTablu(nivo);
            SudokuTabla tabla = (SudokuTabla) KontrolerKlijent.getInstance()
                    .pozivSistemskeOperacije(Operations.VRATI_NEODIGRANU_TABLU, param);

            if (tabla == null) {
                poruka("Odigrali ste sve table ovog nivoa!");
                return;
            }

            Igra nova = IgraHelper.napraviNovuIgru(tabla, nivo,
                    KontrolerKlijent.getInstance().getUlogovaniKor());
            Igra kreirana = (Igra) KontrolerKlijent.getInstance()
                    .pozivSistemskeOperacije(Operations.KREIRAJ_IGRU, nova);

            JFXIgra jfxIgra = new JFXIgra(kreirana);
            jfxIgra.setParentController(fxcon);
            jfxIgra.start(new Stage());
            this.fxcon.closeStage();
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne može da kreira novu igru.");
        }
    }

    private void nastaviZapocetuIgru() {
        try {
            Igra param = new Igra();
            param.setKorisnik(KontrolerKlijent.getInstance().getUlogovaniKor());

            Igra zapoceta = (Igra) KontrolerKlijent.getInstance().pozivSistemskeOperacije(Operations.VRATI_ZAPOCETU_IGRU, param);
            if (zapoceta == null) {
                poruka("Nemate zapocetu igru.");
                return;
            }

            JFXIgra jfxIgra = new JFXIgra(zapoceta);
            jfxIgra.setParentController(fxcon);
            jfxIgra.start(new Stage());
            this.fxcon.closeStage();
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne može da nastavi započetu igru.");
        }
    }

    private void izmeniKorisnika() {
        try {
            JFXIzmenaKorisnika forma = new JFXIzmenaKorisnika();
            forma.setParentController(fxcon);
            forma.start(new Stage());
            this.fxcon.closeStage();
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka(ex.getMessage());
        }
    }

    private void odjaviSe() {
        try {
            Korisnik ulogovaniKorisnik = KontrolerKlijent.getInstance().getUlogovaniKor();

            boolean uspeh = (boolean) KontrolerKlijent.getInstance().pozivSistemskeOperacije(Operations.ODJAVI_KORISNIKA, ulogovaniKorisnik);
            if (!uspeh) {
                poruka("Sistem ne moze da odjavi korisnika.");
                return;
            }
            KontrolerKlijent.getInstance().setUlogovaniKor(null);
            poruka("Uspešno ste se odjavili.");

            fxcon.closeStage();

            new login.JFXLogin().start(new Stage());
        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne moze da odjavi korisnika.");
        }
    }

}
