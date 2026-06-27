/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igra;

import DomenskiObjekat.Igra;
import DomenskiObjekat.NivoTezine;
import DomenskiObjekat.Operations;
import DomenskiObjekat.StatusIgre;
import DomenskiObjekat.SudokuTabla;
import helpers.DialogHelper;
import helpers.IgraHelper;
import helpers.SudokuTablaHelper;
import java.util.Arrays;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.util.Duration;
import soket_klijent_kontroler.KontrolerKlijent;

/**
 *
 * @author Korisnik
 */
public class KontrolerGUIIgra {

    private FXMLIgraController fxcon;
    private Igra igra;
    private Timeline tajmer;
    private int protekloSekundi;
    private SudokuTablaHelper tablaHelper;

    public KontrolerGUIIgra(FXMLIgraController fxcon) {
        this.fxcon = fxcon;
        podesiBtnHandlere();
    }

    private void podesiBtnHandlere() {
        fxcon.novaIgraBtn.setOnAction(e -> onNovaIgra());
        fxcon.odustaniBtn.setOnAction(e -> onOdustani());
    }

    private void inicijalizujCloseHandler() {
        fxcon.getStage().setOnCloseRequest(e -> {
            boolean uspeh = sacuvajStanje(true);
            if (uspeh) {
                poruka("Stanje igre je sačuvano.");
            }
            if (fxcon.parentController != null) {
                fxcon.parentController.getStage().show();
            }
        });
    }

    // poziva se iz FXMLIgraController.setIgra()
    public void postaviIgru(Igra igra) {
        inicijalizujCloseHandler();
        this.igra = igra;
        osveziFormu();
    }

    // ===================== POKRETANJE =====================
    private void pokreniNovuIgru() {
        try {
            zaustaviTajmer();
            boolean uspeh = sacuvajStanje(true); // sacuvaj prethodnu
            if (uspeh) {
                poruka("Stanje igre je sačuvano.");
            }

            NivoTezine nivo = DialogHelper.prikaziIzbor(
                    "Nova igra",
                    "Izaberite nivo težine",
                    "Nivo:",
                    NivoTezine.LAK,
                    Arrays.asList(NivoTezine.LAK, NivoTezine.SREDNJI, NivoTezine.TEZAK)
            );
            if (nivo == null) {
                pokreniTajmer(); // nastavi sa trenutnom igrom
                return;
            }

            SudokuTabla tabla = (SudokuTabla) KontrolerKlijent.getInstance().pozivSistemskeOperacije(Operations.VRATI_NEODIGRANU_TABLU, IgraHelper.napraviParamTablu(nivo));

            if (tabla == null) {
                poruka("Odigrali ste sve table ovog nivoa!");
                pokreniTajmer(); // nastavi prethodnu
                return;
            }

            igra = IgraHelper.napraviNovuIgru(tabla, nivo, KontrolerKlijent.getInstance().getUlogovaniKor());
            igra = (Igra) KontrolerKlijent.getInstance().pozivSistemskeOperacije(Operations.KREIRAJ_IGRU, igra);

            osveziFormu();

        } catch (Exception ex) {
            ex.printStackTrace();
            poruka("Sistem ne može da pokrene novu igru.");
        }
    }

    private void zatvoriIgru() {
        fxcon.closeStage();
        if (fxcon.parentController != null) {
            fxcon.parentController.getStage().show();
        }
    }

    // ===================== FORMA =====================
    private void osveziFormu() {
//        fxcon.nivoLabel.setText("Nivo: " + igra.getNivoTezine());
//        fxcon.greskeLabel.setText("Greške: " + igra.getBrojGresaka());
//        fxcon.vremeLabel.setText("Vreme: " + formatirajVreme(igra.getVremeResavanja()));
        //parametrizzacija skupa naredbi
        String[] tekstovi = {
            "Nivo: " + igra.getNivoTezine(),
            "Greške: " + igra.getBrojGresaka(),
            "Vreme: " + formatirajVreme(igra.getVremeResavanja())
        };
        Label[] labele = {
            fxcon.nivoLabel, fxcon.greskeLabel, fxcon.vremeLabel
        };
        for (int i = 0; i < labele.length; i++) {
            labele[i].setText(tekstovi[i]);
        }
        
        tablaHelper = new SudokuTablaHelper(
                fxcon.sudokuGrid,
                igra,
                this::onGreska, // callback kad je greška
                this::onKrajIgre // callback kad je kraj
        );
        tablaHelper.iscrtaj();
        pokreniTajmer();
    }

    // ===================== CALLBACKS =====================
    private void onGreska() {
        poruka("Pogrešan unos!");
        fxcon.greskeLabel.setText("Greške: " + igra.getBrojGresaka());
    }

    private void onKrajIgre() {
        try {
            zaustaviTajmer();
            igra.setVremeResavanja(protekloSekundi);
            igra.setStatus(StatusIgre.ZAVRSENA);

            KontrolerKlijent.getInstance()
                    .pozivSistemskeOperacije(Operations.AZURIRAJ_IGRU, igra);

            poruka("Čestitamo! Rešili ste Sudoku za "
                    + formatirajVreme(protekloSekundi)
                    + " sa " + igra.getBrojGresaka() + " grešaka.");
            igra = null;
            //fxcon.closeStage();
            zatvoriIgru();
        } catch (Exception ex) {
            poruka("Igra je rešena, ali sistem nije uspeo da sačuva rezultat.");
        }
    }

    // ===================== DUGMAD =====================
    private void onNovaIgra() {
        pokreniNovuIgru();
    }

    private void onOdustani() {
        boolean uspeh = sacuvajStanje(true);
        if (uspeh) {
            poruka("Stanje igre je sačuvano.");
        }
        zatvoriIgru();
    }

    // ===================== ČUVANJE =====================
    private boolean sacuvajStanje(boolean zaustavi) {
        if (igra == null) {
            return true;
        }
        if (igra.getStatus() == StatusIgre.ZAVRSENA) {
            return true;
        }
        try {
            if (zaustavi) {
                zaustaviTajmer();
            }
            igra.setVremeResavanja(protekloSekundi);
            igra.setStatus(StatusIgre.U_TOKU);
            KontrolerKlijent.getInstance()
                    .pozivSistemskeOperacije(Operations.AZURIRAJ_IGRU, igra);
            return true;
        } catch (Exception ex) {
            poruka("Sistem ne može da sačuva stanje igre.");
            return false;
        }
    }

    // ===================== TAJMER =====================
    private void pokreniTajmer() {
        protekloSekundi = igra.getVremeResavanja();
        tajmer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            protekloSekundi++;
            fxcon.vremeLabel.setText("Vreme: " + formatirajVreme(protekloSekundi));
        }));
        tajmer.setCycleCount(Timeline.INDEFINITE);
        tajmer.play();
    }

    private void zaustaviTajmer() {
        if (tajmer != null) {
            tajmer.stop();
        }
    }

    private String formatirajVreme(int sekundi) {
        return String.format("%02d:%02d", sekundi / 60, sekundi % 60);
    }

    public void poruka(String tekst) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Poruka");
        alert.setHeaderText(null);
        alert.setContentText(tekst);
        DialogPane dp = alert.getDialogPane();
        dp.getStylesheets().add("CSS/alert.css");
        dp.getStyleClass().add("sudoku-alert");
        alert.showAndWait();
    }
}
