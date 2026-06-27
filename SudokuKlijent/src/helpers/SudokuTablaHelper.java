/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import DomenskiObjekat.Igra;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author Korisnik
 */
public class SudokuTablaHelper {

    private GridPane grid;
    private Igra igra;
    private TextField[][] polja = new TextField[9][9];
    private Runnable onGreskaCallback;
    private Runnable onKrajCallback;

    public SudokuTablaHelper(GridPane grid, Igra igra,
            Runnable onGreskaCallback,
            Runnable onKrajCallback) {
        this.grid = grid;
        this.igra = igra;
        this.onGreskaCallback = onGreskaCallback;
        this.onKrajCallback = onKrajCallback;
    }

    public void iscrtaj() {
        grid.getChildren().clear();

        String pocetna = igra.getSudokuTabla().getPocetnaTabla();
        String trenutna = igra.getTrenutnoStanje();

        for (int red = 0; red < 9; red++) {
            for (int kolona = 0; kolona < 9; kolona++) {
                int index = red * 9 + kolona;
                char pocetni = pocetna.charAt(index);
                char trenutni = trenutna.charAt(index);

                TextField polje = napraviPolje(pocetni, trenutni, index);
                polja[red][kolona] = polje;
                grid.add(polje, kolona, red);
            }
        }
    }

    private TextField napraviPolje(char pocetni, char trenutni, int index) {
        TextField polje = new TextField();
        polje.setPrefWidth(52);
        polje.setPrefHeight(52);
        primeniBorder(polje, index / 9, index % 9);

        if (pocetni != '0') {
            polje.setText(String.valueOf(pocetni));
            polje.setEditable(false);
            polje.getStyleClass().add("sudoku-polje-unapred");
        } else {
            polje.getStyleClass().add("sudoku-polje");
            if (trenutni != '0') {
                polje.setText(String.valueOf(trenutni));
            }
            polje.textProperty().addListener((obs, stara, nova)
                    -> obradiUnos(polje, index, nova));
        }

        return polje;
    }

    private void obradiUnos(TextField polje, int index, String nova) {
        if (nova == null || nova.isEmpty()) {
            updateStanje(index, '0');
            return;
        }
        if (nova.length() > 1) {
            polje.setText(nova.substring(0, 1));
            return;
        }

        char uneti = nova.charAt(0);
        if (uneti < '1' || uneti > '9') {
            polje.setText("");
            return;
        }

        char tacan = igra.getSudokuTabla().getResenjeTabla().charAt(index);

        if (uneti == tacan) {
            updateStanje(index, uneti);
            polje.getStyleClass().removeAll("sudoku-polje", "sudoku-polje-greska");
            polje.getStyleClass().add("sudoku-polje-tacno");
            if (igra.getTrenutnoStanje().equals(igra.getSudokuTabla().getResenjeTabla())) {
                onKrajCallback.run();
            }
        } else {
            igra.setBrojGresaka(igra.getBrojGresaka() + 1);
            polje.getStyleClass().removeAll("sudoku-polje", "sudoku-polje-tacno");
            polje.getStyleClass().add("sudoku-polje-greska");
            new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                polje.setText("");
                updateStanje(index, '0');
                polje.getStyleClass().removeAll("sudoku-polje-greska");
                polje.getStyleClass().add("sudoku-polje");
            })).play();
            onGreskaCallback.run();
        }
    }

    private void updateStanje(int index, char karakter) {
        String s = igra.getTrenutnoStanje();
        igra.setTrenutnoStanje(
                s.substring(0, index) + karakter + s.substring(index + 1)
        );
    }

    private void primeniBorder(TextField polje, int red, int kolona) {
        String top = (red % 3 == 0) ? "2.5" : "0.5";
        String left = (kolona % 3 == 0) ? "2.5" : "0.5";
        String bottom = (red == 8) ? "2.5" : "0.5";
        String right = (kolona == 8) ? "2.5" : "0.5";
        polje.setStyle(String.format(
                "-fx-border-color: #6c7086; -fx-border-width: %s %s %s %s;",
                top, right, bottom, left
        ));
    }
}
