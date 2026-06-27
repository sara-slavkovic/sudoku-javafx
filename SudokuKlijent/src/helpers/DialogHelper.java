/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import DomenskiObjekat.NivoTezine;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;

/**
 *
 * @author Korisnik
 */
public class DialogHelper {

    //generic metoda
    public static <T> T prikaziIzbor(String title, String header, String content, T defaultChoice, List<T> choices) {
        ChoiceDialog<T> dialog = new ChoiceDialog<>(defaultChoice, choices);
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(content);

        DialogPane dp = dialog.getDialogPane();
        dp.getStylesheets().add("CSS/alert.css");
        dp.getStyleClass().add("sudoku-alert");

        Optional<T> rezultat = dialog.showAndWait();
        return rezultat.orElse(null);
    }
}
