/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soket_klijent_kontroler;

import DomenskiObjekat.Korisnik;
import TransferObjekat.ClientRequest;
import TransferObjekat.Receiver;
import TransferObjekat.Sender;
import TransferObjekat.ServerResponse;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class KontrolerKlijent {

    private static KontrolerKlijent instance;
    private Korisnik ulogovaniKor;
    private Sender sender;
    private Receiver receiver;

    private KontrolerKlijent() {

    }

    public static KontrolerKlijent getInstance() {
        if (instance == null) {
            instance = new KontrolerKlijent();
        }
        return instance;
    }

    public void initStreams(Socket s) throws IOException {
        sender = new Sender(s);
        receiver = new Receiver(s);
    }

    public Korisnik getUlogovaniKor() {
        return ulogovaniKor;
    }

    public void setUlogovaniKor(Korisnik ulogovaniKor) {
        this.ulogovaniKor = ulogovaniKor;
    }

    public Object pozivSistemskeOperacije(int operation, Object object) throws Exception {
        ClientRequest cr = new ClientRequest(operation, object);
        sender.sendMessage(cr);
        ServerResponse sr = (ServerResponse) receiver.receiveMessage();
        if (sr.getException() != null) {
            throw sr.getException();
        }
        return sr.getOdgovor();
    }

}
