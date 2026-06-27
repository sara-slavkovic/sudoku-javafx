/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import DomenskiObjekat.Igra;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Operations;
import DomenskiObjekat.SudokuTabla;
import TransferObjekat.ClientRequest;
import TransferObjekat.Receiver;
import TransferObjekat.Sender;
import TransferObjekat.ServerResponse;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Korisnik
 */
public class Klijent extends Thread {

    private Korisnik ulogovaniKorisnik;
    private Igra trenutnaIgra;
    private Socket s;
    private Receiver receiver;
    private Sender sender;

    public Klijent(Socket socket) {
        s = socket;
        receiver = new Receiver(s);
        sender = new Sender(s);
    }

    @Override
    public void run() {
        try {
            while (!s.isClosed()) {
                ServerResponse sr = new ServerResponse();
                System.out.println("Server ceka zahtev klijenta");
                ClientRequest cr = (ClientRequest) receiver.receiveMessage();
                System.out.println("Server obradjuje klijentski zahtev");
                try {
                    switch (cr.getOperation()) {
                        case Operations.PRIJAVI_KORISNIKA:
                            System.out.println("Usao u case za prijavu");
                            Korisnik korisnik = KontrolerServer.getInstance().prijaviKorisnika((Korisnik) cr.getParametar());
                            this.ulogovaniKorisnik = korisnik;
                            sr.setOdgovor(korisnik);
                            System.out.println("Postavljen odgovor");
                            break;
                        case Operations.REGISTRUJ_KORISNIKA:
                            System.out.println("Usao u case za registraciju");
                            int korisnikId = KontrolerServer.getInstance().registrujKorisnika((Korisnik) cr.getParametar());
                            sr.setOdgovor(korisnikId);
                            System.out.println("Postavljen odgovor");
                            break;
                        case Operations.AZURIRAJ_KORISNIKA:
                            this.ulogovaniKorisnik = (Korisnik) cr.getParametar();
                            KontrolerServer.getInstance().azurirajKorisnika(ulogovaniKorisnik);
                            sr.setOdgovor(true);
                            break;
                        case Operations.VRATI_NEODIGRANU_TABLU:
                            SudokuTabla tabla = KontrolerServer.getInstance().vratiNeodigranuTablu((SudokuTabla) cr.getParametar(), ulogovaniKorisnik);
                            sr.setOdgovor(tabla);
                            break;
                        case Operations.KREIRAJ_IGRU:
                            Igra novaIgra = KontrolerServer.getInstance().kreirajIgru((Igra) cr.getParametar());
                            this.trenutnaIgra = novaIgra;
                            sr.setOdgovor(novaIgra);
                            break;
                        case Operations.VRATI_ZAPOCETU_IGRU:
                            Igra param = new Igra();
                            param.setKorisnik(ulogovaniKorisnik);
                            Igra zapocetaIgra = KontrolerServer.getInstance().vratiZapocetuIgru(param);
                            this.trenutnaIgra = zapocetaIgra;
                            sr.setOdgovor(zapocetaIgra);
                            break;
                        case Operations.AZURIRAJ_IGRU:
                            Igra igraZaUpdate = (Igra) cr.getParametar();
                            KontrolerServer.getInstance().azurirajIgru(igraZaUpdate);
                            this.trenutnaIgra = igraZaUpdate;
                            sr.setOdgovor(true);
                            break;
                        case Operations.ODJAVI_KORISNIKA:
                            KontrolerServer.getInstance().odjaviKorisnika(ulogovaniKorisnik);
                            this.ulogovaniKorisnik = null;
                            sr.setOdgovor(true);
                            break;
                        default:
                            throw new Exception("Nepoznata operacija: " + cr.getOperation());
                    }

                } catch (Exception ex) {
                    System.out.println("Postavljen exception");
                    ex.printStackTrace();
                    sr.setException(ex);
                }
                System.out.println("Salje se poruka");
                sender.sendMessage(sr);
            }

        } catch (SocketException se) {
            System.out.println(KontrolerServer.lkl.size());
            KontrolerServer.getInstance().getKorisnici().remove(ulogovaniKorisnik);
            KontrolerServer.lkl.remove(this);
            System.out.println(KontrolerServer.lkl.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }

    public Igra getTrenutnaIgra() {
        return trenutnaIgra;
    }

    public void setTrenutnaIgra(Igra trenutnaIgra) {
        this.trenutnaIgra = trenutnaIgra;
    }

    public Socket getS() {
        return s;
    }

}
