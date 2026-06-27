/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import DomenskiObjekat.Igra;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.NivoTezine;
import DomenskiObjekat.StatusIgre;
import DomenskiObjekat.SudokuTabla;
import java.sql.Date;

/**
 *
 * @author Korisnik
 */
public class IgraHelper {

    public static SudokuTabla napraviParamTablu(NivoTezine nivo) {
        SudokuTabla param = new SudokuTabla();
        param.setNivoTezine(nivo);
        return param;
    }

    public static Igra napraviNovuIgru(SudokuTabla tabla, NivoTezine nivo, Korisnik korisnik) {
        Igra nova = new Igra();
        nova.setVremeResavanja(0);
        nova.setBrojGresaka(0);
        nova.setNivoTezine(nivo);
        nova.setStatus(StatusIgre.U_TOKU);
        nova.setTrenutnoStanje(tabla.getPocetnaTabla());
        nova.setDatumIgre(new Date(System.currentTimeMillis()));
        nova.setKorisnik(korisnik);
        nova.setSudokuTabla(tabla);
        return nova;
    }
}
