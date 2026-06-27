/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import Database.DBBroker;
import DomenskiObjekat.Korisnik;

/**
 *
 * @author Korisnik
 */
public class SOAzurirajKorisnika extends SOAzurirajObjekat<Korisnik> {

    public SOAzurirajKorisnika(Class<Korisnik> type) {
        super(type);
    }

    @Override
    protected void validate(Object obj) throws Exception {
        super.validate(obj);
        Korisnik korisnik = (Korisnik) obj;
        korisnik.setWhereGetCondition("WHERE k.korisnickoIme='" + korisnik.getKorisnickoIme() + "' AND k.id!=" + korisnik.getId());
        Korisnik postojeciKorisnik = (Korisnik) DBBroker.getInstance().selectObject(korisnik);
        if (postojeciKorisnik != null) {
            throw new Exception("Korisnik sa datim korisnickim imenom vec postoji u sistemu!");
        }
    }
}
