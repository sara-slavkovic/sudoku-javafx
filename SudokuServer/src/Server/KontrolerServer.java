/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import DomenskiObjekat.Igra;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.SudokuTabla;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import so.SOAzurirajKorisnika;
import so.SOAzurirajObjekat;
import so.SOKreiraj;
import so.SORegistrujKorisnika;
import so.SOVratiNeodigranuTablu;
import so.SOVratiObjekat;
import so.SOVratiZapocetuIgru;

/**
 *
 * @author Korisnik
 */
public class KontrolerServer {

    static ServerSocket ss;
    static List<Klijent> lkl = new ArrayList<>();

    List<Korisnik> korisnici = new ArrayList<>();

    private static KontrolerServer instance;

    private KontrolerServer() {
    }

    public static KontrolerServer getInstance() {
        if (instance == null) {
            instance = new KontrolerServer();
        }
        return instance;
    }

    public static void main(String arg[]) throws Exception {
        KontrolerServer.getInstance().izvrsiGenerickiKontroler();
    }

    public void izvrsiGenerickiKontroler() throws Exception {
        ss = new ServerSocket(9000);
        System.out.println("Server je pokrenut!");
        while (true) {
            Socket soketS = ss.accept();
            Klijent kl = new Klijent(soketS);
            kl.start();
            System.out.println("Klijent se povezao!");
            lkl.add(kl);
        }
    }

    public Korisnik prijaviKorisnika(Korisnik korisnik) throws Exception {
        System.out.println("Usao u metodu kontrolera prijavi korisnika");
        if (korisnici.contains(korisnik)) {
            throw new Exception("Korisnik je vec ulogovan na sistem");
        }
        korisnik.setWhereGetCondition("WHERE k.korisnickoIme='" + korisnik.getKorisnickoIme() + "' AND k.lozinka='" + korisnik.getLozinka() + "'");
        SOVratiObjekat<Korisnik> so = new SOVratiObjekat<>(Korisnik.class);
        so.templateExecute(korisnik);
        Korisnik k = so.getObjekat();
        if (k != null) {
            korisnici.add(k);
            return k;
        } else {
            throw new Exception("Niste uneli dobro korisnicko ime ili lozinku!");
        }
    }

    public int registrujKorisnika(Korisnik korisnik) throws Exception {
        SORegistrujKorisnika so = new SORegistrujKorisnika(Korisnik.class);
        so.templateExecute(korisnik);
        return so.getId();
    }

    public void azurirajKorisnika(Korisnik ulogovaniKorisnik) throws Exception {
        SOAzurirajKorisnika so = new SOAzurirajKorisnika(Korisnik.class);
        so.templateExecute(ulogovaniKorisnik);
    }

    public SudokuTabla vratiNeodigranuTablu(SudokuTabla tabla, Korisnik ulogovaniKor) throws Exception {
        SOVratiNeodigranuTablu so = new SOVratiNeodigranuTablu(SudokuTabla.class, ulogovaniKor);
        so.templateExecute(tabla);
        return so.getNeodigrana();
    }

    public Igra vratiZapocetuIgru(Igra igra) throws Exception {
        SOVratiZapocetuIgru so = new SOVratiZapocetuIgru(Igra.class);
        so.templateExecute(igra);
        return so.getObjekat();
    }

    public Igra kreirajIgru(Igra igra) throws Exception {
        SOKreiraj<Igra> so = new SOKreiraj<>(Igra.class);
        so.templateExecute(igra);
        igra.setId(so.getId());
        return igra;
    }

    public void azurirajIgru(Igra igra) throws Exception {
        SOAzurirajObjekat<Igra> so = new SOAzurirajObjekat<>(Igra.class);
        so.templateExecute(igra);
    }

    public void odjaviKorisnika(Korisnik korisnik) {
        korisnici.remove(korisnik);
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }
}
